package br.com.postech30.challenge.service;

import br.com.postech30.challenge.dto.ApplianceDTO;
import br.com.postech30.challenge.dto.DependentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DependentService {

    Page<DependentDTO> search(String search, Pageable pageable);

    DependentDTO findById(Long id);

    DependentDTO saveDependent(DependentDTO dependentDTO);

    DependentDTO update(Long id, DependentDTO dependentDTO);

    void delete(Long id);

    List<ApplianceDTO> findApplianceByDependentId(Long id);

}