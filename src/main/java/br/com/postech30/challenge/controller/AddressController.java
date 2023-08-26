package br.com.postech30.challenge.controller;

import br.com.postech30.challenge.dto.AddressDTO;
import br.com.postech30.challenge.dto.DependentDTO;
import br.com.postech30.challenge.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    AddressService service;

    @PostMapping
    public ResponseEntity<String> addAddress(@RequestBody @Valid AddressDTO addressDTO) {

        service.saveAddress(addressDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Endereço cadastrado com sucesso!");
    }

    @GetMapping
    public  ResponseEntity<List<AddressDTO>> getAddresses(
            @RequestParam(defaultValue = "") String search) {

        List<AddressDTO> list = service.search(search);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable Long id) {

        AddressDTO dto = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> removeAddress(@PathVariable Long id) {

        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Endereço deletado com sucesso!");
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<String> updateAddress(@PathVariable Long id, @RequestBody @Valid AddressDTO addressDTO) {

        service.update(id, addressDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Endereço atualizado com sucesso!");
    }

    @GetMapping(value = "{id}/dependents")
    public ResponseEntity<List<DependentDTO>> findDependentAddress(@PathVariable Long id) {
        var dependent = service.findByAddressId(id);
        return ResponseEntity.ok(dependent);
    }
}
