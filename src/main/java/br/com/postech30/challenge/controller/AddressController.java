package br.com.postech30.challenge.controller;

import br.com.postech30.challenge.dto.AddressDTO;
import br.com.postech30.challenge.service.AddressService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
import jakarta.validation.Valid;
import jakarta.validation.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    AddressService service;

    @PostMapping
    public ResponseEntity addAddressDTO(@RequestBody @Valid AddressDTO addressDTO) {

        service.saveAddress(addressDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Endereço cadastrado com sucesso!");
    }
}
