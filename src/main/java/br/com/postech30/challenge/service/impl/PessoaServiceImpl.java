package br.com.postech30.challenge.service.impl;

import br.com.postech30.challenge.entity.PessoaEntity;
import br.com.postech30.challenge.repository.PessoaRepository;
import br.com.postech30.challenge.service.PessoaService;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImpl implements PessoaService {
    final PessoaRepository pessoaRepository;

    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public PessoaEntity salvarPessoa(PessoaEntity pessoaEntity) {
        return pessoaRepository.save(pessoaEntity);
    }
}