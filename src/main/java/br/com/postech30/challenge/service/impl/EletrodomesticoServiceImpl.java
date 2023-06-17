package br.com.postech30.challenge.service.impl;

import br.com.postech30.challenge.dto.EletrodomesticoDTO;
import br.com.postech30.challenge.entity.EletrodomesticoEntity;
import br.com.postech30.challenge.repository.EletrodomesticoRepository;
import br.com.postech30.challenge.service.EletrodomesticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EletrodomesticoServiceImpl implements EletrodomesticoService {

    @Autowired
    private EletrodomesticoRepository repository;
    @Override
    public void salvarEletrodomestico(EletrodomesticoDTO eletrodomesticoDTO) {
        EletrodomesticoEntity eletrodomesticoEntity = eletrodomesticoDTO.mapToEletrodomestico();
        repository.save(eletrodomesticoEntity);
    }
}
