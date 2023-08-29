package br.com.postech30.challenge.service;

import br.com.postech30.challenge.dto.ApplianceDTO;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface ApplianceService {

     Page<ApplianceDTO> findAllAppliance(PageRequest pageRequest);

     ApplianceDTO findByIdAppliance(Long id);
     ApplianceDTO saveAppliance(ApplianceDTO applianceDTO);

     ApplianceDTO upDateAppliance(Long id, ApplianceDTO applianceDTO);

     void  deleteAppliance(Long id);
}
