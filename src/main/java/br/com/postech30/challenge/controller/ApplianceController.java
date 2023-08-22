package br.com.postech30.challenge.controller;


import br.com.postech30.challenge.dto.ApplianceDTO;
import br.com.postech30.challenge.dto.DependentDTO;
import br.com.postech30.challenge.service.ApplianceService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.transaction.Transactional;
import org.springframework.validation.annotation.Validated;



@Validated
@Transactional
@RestController
@RequestMapping(value = "/appliance")
public class ApplianceController {

    @Autowired
    private final ApplianceService applianceService;

    public ApplianceController(ApplianceService applianceService) {
        this.applianceService = applianceService;
    }

    @PostMapping
    public ResponseEntity<ApplianceDTO> saveAppliance(@RequestBody @Valid ApplianceDTO applianceDTO) {
        var applianceSave = applianceService.saveAppliance(applianceDTO);
        return ResponseEntity.ok(applianceSave);
    }


    @GetMapping("{id}")
    public ResponseEntity<ApplianceDTO> findByIdAppliance(@PathVariable Long id) {
        var appliance = applianceService.findByIdAppliance(id);
        return ResponseEntity.ok(appliance);
    }

    @PutMapping("{id}")
    public ResponseEntity<ApplianceDTO> upDateAppliance(@PathVariable Long id,
                                                        @RequestBody @Valid ApplianceDTO applianceDTO) {
        var applianceUpDate = applianceService.upDateAppliance(id, applianceDTO);
        return ResponseEntity.ok(applianceUpDate);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAppliance(@PathVariable Long id) {
        applianceService.deleteAppliance(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Eletrodoméstico deletado com sucesso.");
    }

    @GetMapping
    public  ResponseEntity<Page<ApplianceDTO>> getAppliance(
            @RequestParam(defaultValue = "") String search, Pageable pageable) {

        Page<ApplianceDTO> page = applianceService.search(search, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping(value = "{id}/dependents")
    public ResponseEntity<List<DependentDTO>> findApplianceDependent(@PathVariable Long id) {
        var dependent = applianceService.findDependentByApplianceId(id);
        return ResponseEntity.ok(dependent);
    }
}
