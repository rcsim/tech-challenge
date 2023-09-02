package br.com.postech30.challenge.service;

import br.com.postech30.challenge.dto.AddressDTO;
import br.com.postech30.challenge.dto.ApplianceDTO;
import br.com.postech30.challenge.dto.DependentDTO;
import br.com.postech30.challenge.entity.Appliance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AddressService {

    AddressDTO saveAddress(AddressDTO addressDTO);

    AddressDTO findById(Long id);

    void delete(Long id);

    void update(Long id, AddressDTO addressDTO);

    Page<AddressDTO> search(String search, Pageable pageable);

    List<DependentDTO> findDependentByAddressId(Long id);

    List<ApplianceDTO> findApplianceByAddressId(Long id);
}
