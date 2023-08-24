package br.com.postech30.challenge.service.impl;

import br.com.postech30.challenge.dto.DependentDTO;
import br.com.postech30.challenge.entity.Dependent;
import br.com.postech30.challenge.exceptions.ResourceNotFoundException;
import br.com.postech30.challenge.repository.AddressRepository;
import br.com.postech30.challenge.repository.DependentRepository;
import br.com.postech30.challenge.service.DependentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DependentServiceImpl implements DependentService {
    final DependentRepository dependentRepository;
    AddressRepository addressRepository;

    public DependentServiceImpl(DependentRepository dependentRepository, AddressRepository addressRepository) {
        this.dependentRepository = dependentRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DependentDTO> search(String text) {
        List<Dependent> list;
        if (Objects.equals(text, "")) {
            list = dependentRepository.findAll();
        } else {
            list = dependentRepository.findByNameIgnoreCaseContainingOrDateOfBirthIgnoreCaseContainingOrGenderIgnoreCaseContainingOrParentageIgnoreCaseContaining(text, text, text, text);
        }
        return list.stream().map(DependentDTO::new).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public DependentDTO findById(Long id) {
        var dependent = dependentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Dependente não encontrado"));
        return new DependentDTO(dependent);
    }

    @Override
    @Transactional
    public DependentDTO saveDependent(DependentDTO dependentDTO) {
        Dependent dependentEntity = new Dependent();
        dependentEntity = mapTo(dependentDTO, dependentEntity);
        return new DependentDTO(dependentRepository.save(dependentEntity));
    }

    @Override
    @Transactional
    public DependentDTO update(Long id, DependentDTO dependentDTO) {
        try {
            Dependent getDependent = dependentRepository.getReferenceById(id);
            getDependent = mapTo(dependentDTO, getDependent);
            return new DependentDTO(dependentRepository.save(getDependent));
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Dependente não encontrado, id: " + id);
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        try {
            dependentRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Nenhum dependente encontrado com o id: " + id);
        }
    }

    public Dependent mapTo(DependentDTO dto, Dependent entity) {
        entity.setName(dto.getName());
        entity.setDateOfBirth(String.valueOf(dto.getDateOfBirth()));
        entity.setGender(dto.getGender());
        entity.setParentage(dto.getParentage());
        entity.setAddress(addressRepository.findById(dto.getAddressId()).orElseThrow(() -> new ResourceNotFoundException("Não é possível realizar o cadastro em um endereço inexistente")));
        entity.setUserId(dto.getUserId());
        return entity;
    }

}