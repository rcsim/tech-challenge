package br.com.postech30.challenge.controller;

import br.com.postech30.challenge.entity.PessoaEntity;
import br.com.postech30.challenge.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping()
    public ResponseEntity<PessoaEntity> cadastrarPessoa(@RequestBody @Valid PessoaEntity pessoaEntity) {
        return new ResponseEntity<>(pessoaService.salvarPessoa(pessoaEntity), HttpStatus.CREATED);
    }
}