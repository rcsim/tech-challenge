package br.com.postech30.challenge.controller;

import br.com.postech30.challenge.dto.DependentDTO;
import br.com.postech30.challenge.entity.Dependent;
import br.com.postech30.challenge.service.DependentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/dependent")
@Validated
public class DependentController {

    private final DependentService dependentService;

    public DependentController(DependentService dependentService) {
        this.dependentService = dependentService;
    }

    @PostMapping()
    public ResponseEntity<DependentDTO> addDependent(@RequestBody @Valid DependentDTO dependentDTO) {
        return new ResponseEntity<>(dependentService.saveDependent(dependentDTO), HttpStatus.CREATED);
    }
}