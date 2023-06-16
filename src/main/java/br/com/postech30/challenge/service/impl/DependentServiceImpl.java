package br.com.postech30.challenge.service.impl;

import br.com.postech30.challenge.entity.DependentEntity;
import br.com.postech30.challenge.repository.DependentRepository;
import br.com.postech30.challenge.service.DependentService;
import org.springframework.stereotype.Service;

@Service
public class DependentServiceImpl implements DependentService {
    final DependentRepository dependentRepository;

    public DependentServiceImpl(DependentRepository dependentRepository) {
        this.dependentRepository = dependentRepository;
    }

    public DependentEntity saveDependent(DependentEntity dependentEntity) {
        return dependentRepository.save(dependentEntity);
    }
}