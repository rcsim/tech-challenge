package br.com.postech30.challenge.service.impl;

import br.com.postech30.challenge.dto.ApplianceDTO;
import br.com.postech30.challenge.dto.DependentDTO;
import br.com.postech30.challenge.entity.Appliance;
import br.com.postech30.challenge.entity.Dependent;
import br.com.postech30.challenge.exceptions.ResourceNotFoundException;
import br.com.postech30.challenge.repository.AddressRepository;
import br.com.postech30.challenge.repository.DependentRepository;
import br.com.postech30.challenge.service.DependentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DependentServiceImpl implements DependentService {
    final DependentRepository dependentRepository;

    public DependentServiceImpl(DependentRepository dependentRepository) {
        this.dependentRepository = dependentRepository;
    }

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Dependent saveDependent(DependentDTO dependentDTO) {
        Dependent dependent = new Dependent();
        dependent = mapTo(dependentDTO, dependent);
        return dependentRepository.save(dependent);
    }

    public Dependent mapTo(DependentDTO dto, Dependent entity) {
        entity.setName(dto.getName());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setGender(dto.getGender());
        entity.setParentage(dto.getParentage());
        entity.setAddress(
                addressRepository.findById(dto.getAddressId()).orElseThrow(
                        () -> new ResourceNotFoundException("Não é possível realizar o cadastro em um endereço inexistente")));
        entity.setUserId(dto.getUserId());
        return entity;
    }

}