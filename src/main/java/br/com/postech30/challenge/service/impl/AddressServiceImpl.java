package br.com.postech30.challenge.service.impl;

import br.com.postech30.challenge.dto.AddressDTO;
import br.com.postech30.challenge.dto.ApplianceDTO;
import br.com.postech30.challenge.dto.DependentDTO;
import br.com.postech30.challenge.entity.Address;
import br.com.postech30.challenge.entity.Appliance;
import br.com.postech30.challenge.entity.Dependent;
import br.com.postech30.challenge.exceptions.ResourceNotFoundException;
import br.com.postech30.challenge.repository.AddressRepository;
import br.com.postech30.challenge.repository.ApplianceRepository;
import br.com.postech30.challenge.repository.DependentRepository;
import br.com.postech30.challenge.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository repository;
    @Autowired
    DependentRepository dependentRepository;
    @Autowired
    ApplianceRepository applianceRepository;

    static final String RESPONSEENDERECONAOENCONTRADO = "Endereço não encontrado";
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
        return list.stream().map(AddressDTO::new).toList();
    }

    @Override
    @Transactional
    public List<DependentDTO> findDependentByAddressId(Long id) {
        Address address = repository.getReferenceById(id);
        List<Dependent> addressDependent = dependentRepository.findByAddress_Id(address.getId());
        return addressDependent.stream().map(DependentDTO::new).toList();
    }

    @Override
    @Transactional
    public List<ApplianceDTO> findApplianceByAddressId(Long id) {
        Address address = repository.getReferenceById(id);
        List<Appliance> addressAppliance =applianceRepository.findByAddress_Id(address.getId());
        return addressAppliance.stream().map(ApplianceDTO::new).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public AddressDTO findById(Long id) {
        Address address = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(RESPONSEENDERECONAOENCONTRADO));

        return new AddressDTO(address);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(RESPONSEENDERECONAOENCONTRADO);
        }

        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Long id, AddressDTO addressDTO) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(RESPONSEENDERECONAOENCONTRADO);
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
        entity.setUserId(dto.getUserId());
        return entity;
    }
}
