package br.com.postech30.challenge.service.impl;

import br.com.postech30.challenge.dto.AddressDTO;
import br.com.postech30.challenge.entity.Address;
import br.com.postech30.challenge.repository.AddressRepository;
import br.com.postech30.challenge.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Override
    public void saveAddress(AddressDTO addressDTO) {
        Address address = addressDTO.mapToAddress();
        addressRepository.save(address);
    }
}
