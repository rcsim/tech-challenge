package br.com.postech30.challenge.controller;


import br.com.postech30.challenge.dto.EletrodomesticoDTO;
import br.com.postech30.challenge.service.EletrodomesticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Valid;
import javax.validation.Validation;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/eletrodomesticos")
public class EletrodomesticoController {



    @Autowired
    EletrodomesticoService service;


    @PostMapping()
    public ResponseEntity cadastrarEletrodomestico( @RequestBody @Valid EletrodomesticoDTO eletrodomestico){

        Set<ConstraintViolation<EletrodomesticoDTO>> violacoes =
                Validation.buildDefaultValidatorFactory().getValidator().validate(eletrodomestico);
        Map<Path, String> violacoesToMap = violacoes.stream().collect(Collectors.toMap(violacao -> violacao.getPropertyPath(), violacao -> violacao.getMessage()));

        if (!violacoesToMap.isEmpty()) {
            return ResponseEntity.badRequest().body(violacoesToMap);
        }
        service.salvarEletrodomestico(eletrodomestico);
        return ResponseEntity.status(HttpStatus.CREATED).body("Eletrodoméstico cadastrado com sucesso!");
    }

}
