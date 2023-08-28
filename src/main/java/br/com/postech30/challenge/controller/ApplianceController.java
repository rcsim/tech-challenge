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
    public ResponseEntity<ApplianceDTO> save(@RequestBody @Valid ApplianceDTO applianceDTO) {
        var applianceSave = applianceService.saveAppliance(applianceDTO);
        return ResponseEntity.ok(applianceSave);
    }

    @GetMapping
    public ResponseEntity<Page<ApplianceDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                      @RequestParam(value = "size", defaultValue = "5") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        var appliance = applianceService.findAll(pageRequest);
        return ResponseEntity.ok(appliance);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplianceDTO> findById(@PathVariable Long id) {
        var appliance = applianceService.findById(id);
        return ResponseEntity.ok(appliance);
    }

//    @Autowired
//    ApplianceService service;

//    @PostMapping()
//    public ResponseEntity addAppliance(@RequestBody @Valid ApplianceDTO appliance){
//
//        service.saveAppliance(appliance);
//        return ResponseEntity.status(HttpStatus.CREATED).body("Eletrodoméstico cadastrado com sucesso!");
//    }

}
