package br.com.postech30.challenge.controller;

import br.com.postech30.challenge.dto.AddressDTO;
import br.com.postech30.challenge.dto.ApplianceDTO;
import br.com.postech30.challenge.dto.DependentDTO;
import br.com.postech30.challenge.service.AddressService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

@OpenAPIDefinition
        (
                info = @Info(
                        title = "Pos-Tech API",
                        version = "2.00"
                )
        )
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

    @Operation(summary = "Cadastro de Endereços",
            description = "Adiciona um Endereço na base de dados do sistema, todos os parâmetros são obrigatórios")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Endereço adicionado"),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")
    })
    @PostMapping
    public ResponseEntity<AddressDTO> addAddress(@RequestBody @Valid AddressDTO addressDTO) {

        var addressSave = addressService.saveAddress(addressDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(addressSave);
    }

    @Operation(summary = "Busca de Endereços",
            description = "Busca todos os Endereços na base de dados do sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de Endereços cadastrados no sistema. Retorna uma lista vazia caso não exista Endereços cadastrados"),
    })
    @GetMapping
    public  ResponseEntity<Page<AddressDTO>> getAddresses(
            @RequestParam(defaultValue = "") String search, Pageable pageable)  {

        Page<AddressDTO> page = addressService.search(search, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @Operation(summary = "Busca um Endereço",
            description = "Busca de um Endereço na base de dados do sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Retorna o Endereço correspondente ao id fornecido e cadastrado no sistema."),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado")
    })
    @GetMapping(value = "{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable Long id) {

        AddressDTO dto = addressService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @Operation(summary = "Remove Endereço",
            description = "Remove um Endereço na base de dados do sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Endereço deletado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado")
    })
    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> removeAddress(@PathVariable Long id) {

        addressService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Endereço deletado com sucesso!");
    }

    @Operation(summary = "Atualiza cadastro de Endereços",
            description = "Atualiza o cadastro de um Endereço na base de dados do sistema, todos os parâmetros são obrigatórios")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Endereço atualizado"),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")
    })
    @PutMapping(value = "{id}")
    public ResponseEntity<String> updateAddress(@PathVariable Long id, @RequestBody @Valid AddressDTO addressDTO) {

        addressService.update(id, addressDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Endereço atualizado com sucesso!");
    }

    @Operation(summary = "Busca de Dependentes associados a um Endereço",
            description = "Retorna uma lista de Dependentes associados a um Endereço.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de Dependentes cadastrados no sistema e associados a um Endereço . Retorna uma lista vazia caso não exista Dependentes cadastrados"),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado")
    })
    @GetMapping(value = "{id}/dependents")
    public ResponseEntity<List<DependentDTO>> findDependentAddress(@PathVariable Long id) {
        var dependent = addressService.findDependentByAddressId(id);
        return ResponseEntity.ok(dependent);
    }

    @Operation(summary = "Busca de Eletrodomésticos associados a um Endereço",
            description = "Retorna uma lista de Eletrodomésticos associados a um Endereço.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de Eletrodomésticos cadastrados no sistema e associados a um Endereço . Retorna uma lista vazia caso não exista Eletrodomésticos cadastrados"),
            @ApiResponse(responseCode = "404", description = "Endereço não encontrado")
    })
    @GetMapping(value = "{id}/appliances")
    public ResponseEntity<List<ApplianceDTO>> findAppliancesAddress(@PathVariable Long id) {
        var appliance = addressService.findApplianceByAddressId(id);
        return ResponseEntity.ok(appliance);
    }
}
