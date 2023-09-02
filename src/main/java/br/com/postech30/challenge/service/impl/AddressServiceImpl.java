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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    DependentRepository dependentRepository;
    @Autowired
    ApplianceRepository applianceRepository;

    static final String RESPONSEENDERECONAOENCONTRADO = "Endereço não encontrado";
    @Override
    @Transactional
    public AddressDTO saveAddress(AddressDTO addressDTO) {
        Address addressEntity = new Address();
        addressEntity = mapTo(addressDTO, addressEntity);
        return new AddressDTO(addressRepository.save(addressEntity));
    }


    @Override
    @Transactional(readOnly = true)
    public Page<AddressDTO> search(String text, Pageable pageable) {
        Page<Address> page;
        if (Objects.equals(text, "")) {
            page = addressRepository.findAll(pageable);
        } else {
            page = addressRepository.findByStreetIgnoreCaseContainingOrDistrictIgnoreCaseContainingOrCityIgnoreCaseContainingOrStateIgnoreCaseContaining(text, text, text, text, pageable);
        }
        return page.map(AddressDTO::new);
    }

    @Override
    @Transactional
    public List<DependentDTO> findDependentByAddressId(Long id) {
        Address address = addressRepository.getReferenceById(id);
        List<Dependent> addressDependent = dependentRepository.findByAddress_Id(address.getId());
        return addressDependent.stream().map(DependentDTO::new).toList();
    }

    @Override
    @Transactional
    public List<ApplianceDTO> findApplianceByAddressId(Long id) {
        Address address = addressRepository.getReferenceById(id);
        List<Appliance> addressAppliance =applianceRepository.findByAddress_Id(address.getId());
        return addressAppliance.stream().map(ApplianceDTO::new).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public AddressDTO findById(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(RESPONSEENDERECONAOENCONTRADO));

        return new AddressDTO(address);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!addressRepository.existsById(id)) {
            throw new ResourceNotFoundException(RESPONSEENDERECONAOENCONTRADO);
        }

        addressRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Long id, AddressDTO addressDTO) {
        if (!addressRepository.existsById(id)) {
            throw new ResourceNotFoundException(RESPONSEENDERECONAOENCONTRADO);
        }

        Address address = addressRepository.getReferenceById(id);
        address = mapTo(addressDTO, address);
        addressRepository.save(address);
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
