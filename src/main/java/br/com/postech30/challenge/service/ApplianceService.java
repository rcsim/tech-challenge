package br.com.postech30.challenge.service;

import br.com.postech30.challenge.dto.ApplianceDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ApplianceService {

     void saveAppliance(@Valid ApplianceDTO appliance);

     Page<ApplianceDTO> search(String search, Pageable pageable);
}
