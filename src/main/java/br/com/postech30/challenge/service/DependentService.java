package br.com.postech30.challenge.service;

import br.com.postech30.challenge.dto.DependentDTO;

import java.util.List;

public interface DependentService {

    List<DependentDTO> search(String search);

    DependentDTO findById(Long id);

    DependentDTO saveDependent(DependentDTO dependentDTO);

    DependentDTO update(Long id, DependentDTO dependentDTO);

    void delete(Long id);

}