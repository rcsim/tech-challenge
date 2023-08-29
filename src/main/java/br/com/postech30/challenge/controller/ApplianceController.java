package br.com.postech30.challenge.controller;


import br.com.postech30.challenge.dto.ApplianceDTO;
import br.com.postech30.challenge.service.ApplianceService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;


@Validated
@Transactional
@RestController
@RequestMapping(value = "/appliance")
public class ApplianceController {

    private final ApplianceService applianceService;

    public ApplianceController(ApplianceService applianceService) {
        this.applianceService = applianceService;
    }

    @PostMapping
    public ResponseEntity<ApplianceDTO> saveAppliance(@RequestBody @Valid ApplianceDTO applianceDTO) {
        var applianceSave = applianceService.saveAppliance(applianceDTO);
        return ResponseEntity.ok(applianceSave);
    }

    @GetMapping
    public ResponseEntity<Page<ApplianceDTO>> findAllAppliance(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                      @RequestParam(value = "size", defaultValue = "5") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        var appliance = applianceService.findAllAppliance(pageRequest);
        return ResponseEntity.ok(appliance);
    }

    @GetMapping("/appliance/{id}")
    public ResponseEntity<ApplianceDTO> findByIdAppliance(@PathVariable Long id) {
        var appliance = applianceService.findByIdAppliance(id);
        return ResponseEntity.ok(appliance);
    }

    @PutMapping("/appliance/{id}")
    public ResponseEntity<ApplianceDTO> upDateAppliance(@PathVariable Long id,
                                                        @RequestBody @Valid ApplianceDTO applianceDTO) {
        var applianceUpDate = applianceService.upDateAppliance(id, applianceDTO);
        return ResponseEntity.ok(applianceUpDate);
    }

    @DeleteMapping("/appliance/{id}")
    public ResponseEntity deleteAppliance(@PathVariable Long id) {
        applianceService.deleteAppliance(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Eletrodoméstico deletado com sucesso.");
    }

}
