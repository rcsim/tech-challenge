package br.com.postech30.challenge.controller;


import br.com.postech30.challenge.dto.ApplianceDTO;
import br.com.postech30.challenge.service.ApplianceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public  ResponseEntity<List<ApplianceDTO>> getAppliance(
            @RequestParam(defaultValue = "") String search) {

        List<ApplianceDTO> list = service.search(search);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
