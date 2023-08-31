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


@RestController
@RequestMapping(value = "/appliance")
public class ApplianceController {



    @Autowired
    ApplianceService service;


    @PostMapping()
    public ResponseEntity<String> addAppliance(@RequestBody @Valid ApplianceDTO appliance){

        service.saveAppliance(appliance);
        return ResponseEntity.status(HttpStatus.CREATED).body("Eletrodoméstico cadastrado com sucesso!");
    }

    @GetMapping
    public  ResponseEntity<Page<ApplianceDTO>> getAppliance(
            @RequestParam(defaultValue = "") String search, Pageable pageable) {

        Page<ApplianceDTO> page = service.search(search, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping(value = "{id}/dependents")
    public ResponseEntity<List<DependentDTO>> findApplianceDependent(@PathVariable Long id) {
        var dependent = service.findDependentByApplianceId(id);
        return ResponseEntity.ok(dependent);
    }
}
