package br.com.postech30.challenge.service;

import br.com.postech30.challenge.dto.ApplianceDTO;
import br.com.postech30.challenge.dto.DependentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ApplianceService {

     Page<ApplianceDTO> search(String search, Pageable pageable);

     List<DependentDTO> findDependentByApplianceId(Long id);

     ApplianceDTO findByIdAppliance(Long id);
     ApplianceDTO saveAppliance(ApplianceDTO applianceDTO);

     ApplianceDTO upDateAppliance(Long id, ApplianceDTO applianceDTO);

     void  deleteAppliance(Long id);
}
