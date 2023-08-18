package br.com.postech30.challenge.service.impl;

import br.com.postech30.challenge.dto.DependentDTO;
import br.com.postech30.challenge.entity.Dependent;
import br.com.postech30.challenge.exceptions.ResourceNotFoundException;
import br.com.postech30.challenge.repository.AddressRepository;
import br.com.postech30.challenge.repository.DependentRepository;
import br.com.postech30.challenge.service.DependentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class DependentServiceImpl implements DependentService {
    final DependentRepository dependentRepository;
    AddressRepository addressRepository;

    public DependentServiceImpl(DependentRepository dependentRepository, AddressRepository addressRepository) {
        this.dependentRepository = dependentRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public Page<DependentDTO> findAll(PageRequest pageRequest) {
        var dependents = dependentRepository.findAll(pageRequest);
        return dependents.map(DependentDTO::new);
    }

    @Override
    public DependentDTO findById(Long id) {
        var dependent = dependentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Dependente não encontrado"));
        return new DependentDTO(dependent);
    }

    @Override
    public DependentDTO saveDependent(DependentDTO dependentDTO) {
        Dependent dependentEntity = new Dependent();
        dependentEntity = mapTo(dependentDTO, dependentEntity);
        return new DependentDTO(dependentRepository.save(dependentEntity));
    }

    @Override
    public DependentDTO update(Long id, DependentDTO dependentDTO) {
        try {
            Dependent dependentUpdated = new Dependent();
            dependentUpdated = mapTo(dependentDTO, dependentUpdated);
            return new DependentDTO(dependentRepository.save(dependentUpdated));
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Dependente não encontrado, id: " + id);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            dependentRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Nenhum dependente encontrado com o id: " + id);
        }
    }

    public Dependent mapTo(DependentDTO dto, Dependent entity) {
        entity.setName(dto.getName());
        entity.setDateOfBirth(dto.getDateOfBirth());
        entity.setGender(dto.getGender());
        entity.setParentage(dto.getParentage());
        entity.setAddress(addressRepository.findById(dto.getAddressId()).orElseThrow(() -> new ResourceNotFoundException("Não é possível realizar o cadastro em um endereço inexistente")));
        entity.setUserId(dto.getUserId());
        return entity;
    }

}