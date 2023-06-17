package br.com.postech30.challenge.service;

import br.com.postech30.challenge.dto.DependentDTO;
import br.com.postech30.challenge.entity.Dependent;

public interface DependentService {

    Dependent saveDependent(DependentDTO dependentDTO);

}