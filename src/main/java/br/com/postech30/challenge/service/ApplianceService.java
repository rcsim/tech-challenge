package br.com.postech30.challenge.service;

import br.com.postech30.challenge.dto.ApplianceDTO;

import javax.validation.Valid;

public interface ApplianceService {

     void saveAppliance(@Valid ApplianceDTO appliance);
}
