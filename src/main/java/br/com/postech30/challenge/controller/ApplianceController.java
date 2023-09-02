package br.com.postech30.challenge.controller;


import br.com.postech30.challenge.dto.ApplianceDTO;
import br.com.postech30.challenge.dto.DependentDTO;
import br.com.postech30.challenge.service.ApplianceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.transaction.Transactional;
import org.springframework.validation.annotation.Validated;



@RestController
@RequestMapping(value = "/appliance")
@Validated
@Transactional
public class ApplianceController {

    @Autowired
    private final ApplianceService applianceService;

    public ApplianceController(ApplianceService applianceService) {
        this.applianceService = applianceService;
    }

    @Operation(summary = "Cadastro de Eletrodomésticos",
            description = "Adiciona um Eletrodoméstico na base de dados do sistema, todos os parâmetros são obrigatórios")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Eletrodoméstico adicionado"),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "404", description = "Não é possível realizar o cadastro em um Endereço inexistente"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")
    })
    @PostMapping
    public ResponseEntity<ApplianceDTO> saveAppliance(@RequestBody @Valid ApplianceDTO applianceDTO) {
        var applianceSave = applianceService.saveAppliance(applianceDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(applianceSave);
    }


    @Operation(summary = "Busca um Eletrodoméstico",
            description = "Busca de um Eletrodoméstico na base de dados do sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Retorna o Eletrodoméstico correspondente ao id fornecido e cadastrados no sistema."),
            @ApiResponse(responseCode = "404", description = "Eletrodoméstico não encontrado")
    })
    @GetMapping("{id}")
    public ResponseEntity<ApplianceDTO> findByIdAppliance(@PathVariable Long id) {
        var appliance = applianceService.findByIdAppliance(id);
        return ResponseEntity.ok(appliance);
    }

    @Operation(summary = "Atualiza cadastro de Eletrodomésticos",
            description = "Atualiza o cadastro de um Eletrodoméstico na base de dados do sistema, todos os parâmetros são obrigatórios")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Eletrodoméstico atualizado"),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "404", description = "Eletrodoméstico não encontrado"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")
    })
    @PutMapping("{id}")
    public ResponseEntity<ApplianceDTO> upDateAppliance(@PathVariable Long id,
                                                        @RequestBody @Valid ApplianceDTO applianceDTO) {
        var applianceUpDate = applianceService.upDateAppliance(id, applianceDTO);
        return ResponseEntity.ok(applianceUpDate);
    }

    @Operation(summary = "Remove Eletrodoméstico",
            description = "Remove um Eletrodoméstico na base de dados do sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Eletrodoméstico deletado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Eletrodoméstico não encontrado")
    })
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAppliance(@PathVariable Long id) {
        applianceService.deleteAppliance(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Eletrodoméstico deletado com sucesso.");
    }

    @Operation(summary = "Busca de Eletrodomésticos",
            description = "Busca todos os Eletrodomésticos na base de dados do sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de Eletrodoméstico cadastrados no sistema. Retorna uma lista vazia caso não exista Eletrodomésticos cadastrados"),
    })
    @GetMapping
    public  ResponseEntity<Page<ApplianceDTO>> getAppliance(
            @RequestParam(defaultValue = "") String search, Pageable pageable) {

        Page<ApplianceDTO> page = applianceService.search(search, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @Operation(summary = "Busca de Dependente associados a um Eletrodoméstico",
            description = "Retorna uma lista de Dependentes associados a um Eletrodoméstico.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de Dependentes cadastrados no sistema e associados a um Eletrodoméstico . Retorna uma lista vazia caso não exista Dependentes cadastrados"),
            @ApiResponse(responseCode = "404", description = "Eletrodoméstic não encontrado")
    })
    @GetMapping(value = "{id}/dependents")
    public ResponseEntity<List<DependentDTO>> findApplianceDependent(@PathVariable Long id) {
        var dependent = applianceService.findDependentByApplianceId(id);
        return ResponseEntity.ok(dependent);
    }
}
