package br.com.postech30.challenge.controller;

import br.com.postech30.challenge.dto.AddressDTO;
import br.com.postech30.challenge.service.AddressService;
import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Validation;

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
    public ResponseEntity newAddressDTO(@RequestBody AddressDTO addressDTO) {
        Set<ConstraintViolation<AddressDTO>> violacoes =
                Validation.buildDefaultValidatorFactory().getValidator().validate(addressDTO);
        Map<Path, String> violacoesToMap = violacoes.stream().collect(Collectors.toMap(violacao -> violacao.getPropertyPath(), violacao -> violacao.getMessage()));

        if (!violacoesToMap.isEmpty()) {
            return ResponseEntity.badRequest().body(violacoesToMap);
        }

        service.saveAddress(addressDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Endereço cadastrado com sucesso!");
    }
}
