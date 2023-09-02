package br.com.postech30.challenge.controller;

import br.com.postech30.challenge.dto.ApplianceDTO;
import br.com.postech30.challenge.dto.DependentDTO;
import br.com.postech30.challenge.service.DependentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dependent")
@Validated
@Transactional
public class DependentController {

    @Autowired
    private final DependentService dependentService;

    public DependentController(DependentService dependentService) {
        this.dependentService = dependentService;
    }

    @Operation(summary = "Busca de Dependentes",
            description = "Busca todos os Dependentes na base de dados do sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de dependentes cadastrados no sistema. Retorna uma lista vazia caso não exista depentendes cadastrados"),
    })
    @GetMapping
    public ResponseEntity<Page<DependentDTO>> findAll(@RequestParam(defaultValue = "") String search, Pageable pageable) {
        Page<DependentDTO> page = dependentService.search(search, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @Operation(summary = "Busca um Dependente",
            description = "Busca de um Dependente na base de dados.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Retorna o dependente correspondente ao id fornecido e cadastrados no sistema."),
            @ApiResponse(responseCode = "404", description = "Dependente não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<DependentDTO> findById(@PathVariable Long id) {
        var dependent = dependentService.findById(id);
        return ResponseEntity.ok(dependent);
    }

    @Operation(summary = "Cadastro de Dependentes",
            description = "Adiciona um Dependente na base de dados do sistema, todos os parâmetros são obrigatórios")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Dependente adicionado"),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "404", description = "Não é possível realizar o cadastro em um endereço inexistente"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")
    })
    @PostMapping
    public ResponseEntity<DependentDTO> save(@RequestBody @Valid DependentDTO dependentDTO) {
        var dependentSaved = dependentService.saveDependent(dependentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dependentSaved);
    }

    @Operation(summary = "Atualiza cadastro de Dependentes",
            description = "Atualiza o cadastro de um Dependente na base de dados do sistema, todos os parâmetros são obrigatórios")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Dependente atualizado"),
            @ApiResponse(responseCode = "400", description = "Request incorreto"),
            @ApiResponse(responseCode = "404", description = "Dependente não encontrado"),
            @ApiResponse(responseCode = "422", description = "Parâmetro não pode ser nulo")
    })
    @PutMapping("/{id}")
    public ResponseEntity<DependentDTO> update(@PathVariable Long id, @RequestBody DependentDTO dependentDTO) {
        var dependentUpdated = dependentService.update(id, dependentDTO);
        return ResponseEntity.ok(dependentUpdated);
    }

    @Operation(summary = "Remove Dependente",
            description = "Remove um Dependente na base de dados do sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Dependente deletado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Dependente não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        dependentService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Dependente excluído!");
    }


    @Operation(summary = "Busca de Eletrodomésticos associados a um Dependente",
            description = "Retorna uma lista de Eletrodomésticos associados a um Dependente.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de Eletrodomésticos cadastrados no sistema e associados a um Dependente . Retorna uma lista vazia caso não exista Eletrodomésticos cadastrados"),
            @ApiResponse(responseCode = "404", description = "Dependente não encontrado")
    })
    @GetMapping(value = "{id}/appliances")
    public ResponseEntity<List<ApplianceDTO>> findApplianceDependent(@PathVariable Long id) {
        var appliance = dependentService.findApplianceByDependentId(id);
        return ResponseEntity.ok(appliance);
    }
}