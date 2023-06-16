package br.com.postech30.challenge.service.impl;

import br.com.postech30.challenge.dto.DependentDTO;
import br.com.postech30.challenge.entity.Dependent;
import br.com.postech30.challenge.repository.DependentRepository;
import br.com.postech30.challenge.service.DependentService;
import org.springframework.stereotype.Service;

@Service
public class DependentServiceImpl implements DependentService {
    final DependentRepository dependentRepository;

    public DependentServiceImpl(DependentRepository dependentRepository) {
        this.dependentRepository = dependentRepository;
    }

    @Override
    public Dependent saveDependent(DependentDTO dependentDTO) {
        Dependent dependent = dependentDTO.mapToDependent();
        return dependentRepository.save(dependent);
    }

}