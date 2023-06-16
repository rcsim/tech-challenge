package br.com.postech30.challenge.controller;

import br.com.postech30.challenge.entity.DependentEntity;
import br.com.postech30.challenge.service.DependentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/dependent")
public class DependentController {

    private final DependentService dependentService;

    public DependentController(DependentService dependentService) {
        this.dependentService = dependentService;
    }

    @PostMapping()
    public ResponseEntity<DependentEntity> addDependent(@RequestBody @Valid DependentEntity dependentEntity) {
        return new ResponseEntity<>(dependentService.saveDependent(dependentEntity), HttpStatus.CREATED);
    }
}