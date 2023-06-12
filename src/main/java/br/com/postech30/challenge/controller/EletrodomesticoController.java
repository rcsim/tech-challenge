package br.com.postech30.challenge.controller;


import br.com.postech30.challenge.entity.EletrodomesticoEntity;
import br.com.postech30.challenge.service.EletrodomesticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/eletrodomesticos")
public class EletrodomesticoController {



    @Autowired
    EletrodomesticoService service;


    @PostMapping()
    public String cadastrarEletrodomestico( @RequestBody @Valid EletrodomesticoEntity eletrodomestico){
        service.salvarEletrodomestico(eletrodomestico);
        return "está tudo ok";
    }

}
