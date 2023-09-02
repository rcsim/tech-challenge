package br.com.postech30.challenge.controller;

import br.com.postech30.challenge.dto.AddressDTO;
import br.com.postech30.challenge.dto.ApplianceDTO;
import br.com.postech30.challenge.dto.DependentDTO;
import br.com.postech30.challenge.service.AddressService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/address")
@Validated
@Transactional
public class AddressController {

    @Autowired
    AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<AddressDTO> addAddress(@RequestBody @Valid AddressDTO addressDTO) {

        var addressSave = addressService.saveAddress(addressDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(addressSave);
    }

    @GetMapping
    public  ResponseEntity<Page<AddressDTO>> getAddresses(
            @RequestParam(defaultValue = "") String search, Pageable pageable)  {

        Page<AddressDTO> page = addressService.search(search, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable Long id) {

        AddressDTO dto = addressService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> removeAddress(@PathVariable Long id) {

        addressService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Endereço deletado com sucesso!");
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<String> updateAddress(@PathVariable Long id, @RequestBody @Valid AddressDTO addressDTO) {

        addressService.update(id, addressDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Endereço atualizado com sucesso!");
    }

    @GetMapping(value = "{id}/dependents")
    public ResponseEntity<List<DependentDTO>> findDependentAddress(@PathVariable Long id) {
        var dependent = addressService.findDependentByAddressId(id);
        return ResponseEntity.ok(dependent);
    }

    @GetMapping(value = "{id}/appliances")
    public ResponseEntity<List<ApplianceDTO>> findAppliancesAddress(@PathVariable Long id) {
        var appliance = addressService.findApplianceByAddressId(id);
        return ResponseEntity.ok(appliance);
    }
}
