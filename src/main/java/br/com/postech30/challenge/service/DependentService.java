package br.com.postech30.challenge.service;

import br.com.postech30.challenge.dto.DependentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface DependentService {

    Page<DependentDTO> findAll(PageRequest pageRequest);

    DependentDTO findById(Long id);

    DependentDTO saveDependent(DependentDTO dependentDTO);

    DependentDTO update(Long id, DependentDTO dependentDTO);

    void delete(Long id);

}