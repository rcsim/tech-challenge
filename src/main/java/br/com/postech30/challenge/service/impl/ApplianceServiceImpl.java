package br.com.postech30.challenge.service.impl;

import br.com.postech30.challenge.dto.ApplianceDTO;
import br.com.postech30.challenge.entity.Appliance;
import br.com.postech30.challenge.repository.ApplianceRepository;
import br.com.postech30.challenge.service.ApplianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplianceServiceImpl implements ApplianceService {

    @Autowired
    private ApplianceRepository repository;
    @Override
    public void saveAppliance(ApplianceDTO applianceDTO) {
        Appliance appliance = applianceDTO.mapToAppliance();
        repository.save(appliance);
    }
}
