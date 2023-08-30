package br.com.postech30.challenge.service.impl;

import br.com.postech30.challenge.dto.ApplianceDTO;
import br.com.postech30.challenge.entity.Appliance;
import br.com.postech30.challenge.exceptions.ResourceNotFoundException;
import br.com.postech30.challenge.repository.AddressRepository;
import br.com.postech30.challenge.repository.ApplianceRepository;
import br.com.postech30.challenge.service.ApplianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class ApplianceServiceImpl implements ApplianceService {

    @Autowired
    private ApplianceRepository repository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void saveAppliance(ApplianceDTO applianceDTO) {
        Appliance appliance = new Appliance();
        appliance = mapTo(applianceDTO, appliance);
        repository.save(appliance);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ApplianceDTO> search(String text, Pageable pageable) {
        Page<Appliance> page;
        if (Objects.equals(text, "")) {
            page = repository.findAll(pageable);
        } else {
            page = repository.findByNameIgnoreCaseContainingOrModelIgnoreCaseContainingOrPowerIgnoreCaseContainingOrManufacturerIgnoreCaseContaining(text, text, text, text, pageable);
        }
        return page.map(ApplianceDTO::new);
    }

    public Appliance mapTo(ApplianceDTO dto, Appliance entity) {
        entity.setName(dto.getName());
        entity.setModel(dto.getModel());
        entity.setPower(dto.getPower());
        entity.setManufacturer(dto.getManufacturer());
        entity.setAddress(
                addressRepository.findById(dto.getAddressId()).orElseThrow(
                        () -> new ResourceNotFoundException("Não é possível realizar o cadastro em um endereço inexistente")));
        entity.setUserId(dto.getUserId());
        return entity;
    }
}
