package br.com.postech30.challenge.service;

import br.com.postech30.challenge.dto.EletrodomesticoDTO;

import javax.validation.Valid;

public interface EletrodomesticoService {

     void salvarEletrodomestico(@Valid EletrodomesticoDTO eletrodomestico);
}
