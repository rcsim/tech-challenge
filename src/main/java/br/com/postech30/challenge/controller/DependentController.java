package br.com.postech30.challenge.controller;

import br.com.postech30.challenge.dto.DependentDTO;
import br.com.postech30.challenge.service.DependentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dependent")
@Validated
@Transactional
public class DependentController {

    private final DependentService dependentService;


    public DependentController(DependentService dependentService) {
        this.dependentService = dependentService;
    }

    @GetMapping
    public ResponseEntity<List<DependentDTO>> findAll(@RequestParam(defaultValue = "") String search) {
        var dependents = dependentService.search(search);
        return ResponseEntity.ok(dependents);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DependentDTO> findById(@PathVariable Long id) {
        var dependent = dependentService.findById(id);
        return ResponseEntity.ok(dependent);
    }

    @PostMapping
    public ResponseEntity<DependentDTO> save(@RequestBody @Valid DependentDTO dependentDTO) {
        var dependentSaved = dependentService.saveDependent(dependentDTO);
        return ResponseEntity.ok(dependentSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DependentDTO> update(@PathVariable Long id, @RequestBody DependentDTO dependentDTO) {
        var dependentUpdated = dependentService.update(id, dependentDTO);
        return ResponseEntity.ok(dependentUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        dependentService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Dependente excluído!");
    }
}