package br.com.postech30.challenge.service;

import br.com.postech30.challenge.dto.AddressDTO;
import br.com.postech30.challenge.dto.DependentDTO;

import java.util.List;

public interface AddressService {

    void saveAddress(AddressDTO addressDTO);

    AddressDTO findById(Long id);

    void delete(Long id);

    void update(Long id, AddressDTO addressDTO);

    List<AddressDTO> search(String search);

    List<DependentDTO> findByAddressId(Long id);
}
