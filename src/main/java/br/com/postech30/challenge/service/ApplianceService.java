package br.com.postech30.challenge.service;

import br.com.postech30.challenge.dto.ApplianceDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface ApplianceService {

     void saveAppliance(@Valid ApplianceDTO appliance);

     List<ApplianceDTO> search(String search);
}
