package br.com.postech30.challenge.controller;


import br.com.postech30.challenge.dto.ApplianceDTO;
import br.com.postech30.challenge.service.ApplianceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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

}
