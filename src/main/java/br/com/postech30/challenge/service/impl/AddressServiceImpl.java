package br.com.postech30.challenge.service.impl;

import br.com.postech30.challenge.dto.AddressDTO;
import br.com.postech30.challenge.entity.Address;
import br.com.postech30.challenge.exceptions.ResourceNotFoundException;
import br.com.postech30.challenge.repository.AddressRepository;
import br.com.postech30.challenge.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository repository;
    @Override
    @Transactional
    public void saveAddress(AddressDTO addressDTO) {
        Address address = new Address();
        address = mapTo(addressDTO, address);
        repository.save(address);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AddressDTO> search(String text) {
        List<Address> list;
        if (Objects.equals(text, "")) {
            list = repository.findAll();
        } else {
            list = repository.findByStreetIgnoreCaseContainingOrDistrictIgnoreCaseContainingOrCityIgnoreCaseContainingOrStateIgnoreCaseContaining(text, text, text, text);
        }
        return list.stream().map(AddressDTO::new).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public AddressDTO findById(Long id) {
        Address address = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Endereço não encontrado"));

        return new AddressDTO(address);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Endereço não encontrado");
        }

        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Long id, AddressDTO addressDTO) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Endereço não encontrado");
        }

        Address address = repository.getReferenceById(id);
        address = mapTo(addressDTO, address);
        repository.save(address);
    }

    public Address mapTo(AddressDTO dto, Address entity) {
        entity.setCity(dto.getCity());
        entity.setDistrict(dto.getDistrict());
        entity.setState(dto.getState());
        entity.setStreet(dto.getStreet());
        entity.setNumber(dto.getNumber());
        return entity;
    }
}
