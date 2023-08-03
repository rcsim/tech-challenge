package br.com.postech30.challenge.service.impl;

import br.com.postech30.challenge.dto.AddressDTO;
import br.com.postech30.challenge.entity.Address;
import br.com.postech30.challenge.repository.AddressRepository;
import br.com.postech30.challenge.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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
    public List<AddressDTO> findAll() {
        List<Address> list = repository.findAll();
        return list.stream().map(AddressDTO::new).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public AddressDTO findById(Long id) {
        Optional<Address> address = repository.findById(id);

        return new AddressDTO(address.get());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Long id, AddressDTO addressDTO) {
        Address address = repository.getReferenceById(id);
        address = mapTo(addressDTO, address);
        repository.save(address);
    }

    public Address mapTo(AddressDTO dto, Address entity) {
        entity.setCity(dto.getCity());
        entity.setDistrict(dto.getDistrict());
        entity.setEstate(dto.getEstate());
        entity.setStreet(dto.getStreet());
        entity.setNumber(dto.getNumber());
        return entity;
    }
}
