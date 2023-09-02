package br.com.postech30.challenge.controller;

import br.com.postech30.challenge.dto.ApplianceDTO;
import br.com.postech30.challenge.dto.DependentDTO;
import br.com.postech30.challenge.service.DependentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Autowired
    private final DependentService dependentService;

    public DependentController(DependentService dependentService) {
        this.dependentService = dependentService;
    }

    @GetMapping
    public ResponseEntity<Page<DependentDTO>> findAll(@RequestParam(defaultValue = "") String search, Pageable pageable) {
        Page<DependentDTO> page = dependentService.search(search, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DependentDTO> findById(@PathVariable Long id) {
        var dependent = dependentService.findById(id);
        return ResponseEntity.ok(dependent);
    }

    @PostMapping
    public ResponseEntity<DependentDTO> save(@RequestBody @Valid DependentDTO dependentDTO) {
        var dependentSaved = dependentService.saveDependent(dependentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dependentSaved);
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

    @GetMapping(value = "{id}/appliances")
    public ResponseEntity<List<ApplianceDTO>> findApplianceDependent(@PathVariable Long id) {
        var appliance = dependentService.findApplianceByDependentId(id);
        return ResponseEntity.ok(appliance);
    }
}