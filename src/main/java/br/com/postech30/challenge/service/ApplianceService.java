package br.com.postech30.challenge.service;

import br.com.postech30.challenge.dto.ApplianceDTO;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface ApplianceService {

     Page<ApplianceDTO> findAll(PageRequest pageRequest);

     ApplianceDTO findById(Long id);
     void saveAppliance(@Valid ApplianceDTO applianceDTO);
}
