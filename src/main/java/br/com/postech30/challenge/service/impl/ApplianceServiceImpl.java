package br.com.postech30.challenge.service.impl;

import br.com.postech30.challenge.dto.AddressDTO;
import br.com.postech30.challenge.dto.ApplianceDTO;
import br.com.postech30.challenge.entity.Address;
import br.com.postech30.challenge.entity.Appliance;
import br.com.postech30.challenge.exceptions.ResourceNotFoundException;
import br.com.postech30.challenge.repository.AddressRepository;
import br.com.postech30.challenge.repository.ApplianceRepository;
import br.com.postech30.challenge.service.ApplianceService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ApplianceServiceImpl implements ApplianceService {
    final ApplianceRepository applianceRepository;
    AddressRepository addressRepository;
    public ApplianceServiceImpl(
            ApplianceRepository applianceRepository,
            AddressRepository addressRepository){
        this.applianceRepository = applianceRepository;
        this.addressRepository = addressRepository;
    }
    @Override
    public Page<ApplianceDTO> findAllAppliance(PageRequest pageRequest){
        var appliance = applianceRepository.findAll(pageRequest);
        return appliance.map(ApplianceDTO::new);
    }

    @Override
    public ApplianceDTO findByIdAppliance(Long id) {
        var appliance = applianceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Eletrodoméstico não encontrado"));
        return new ApplianceDTO(appliance);
    }

    @Override
    public ApplianceDTO saveAppliance(ApplianceDTO applianceDTO){
        Appliance applianceEntity = new Appliance();
        applianceEntity = mapTo(applianceDTO, applianceEntity);
        return new ApplianceDTO(applianceRepository.save(applianceEntity));
    }

    @Override
    public ApplianceDTO upDateAppliance(Long id, ApplianceDTO applianceDTO) {
        try {
            Appliance getApplience = applianceRepository.getReferenceById(id);
            getApplience = mapTo(applianceDTO, getApplience);
            return new ApplianceDTO(applianceRepository.save(getApplience));
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Eletrodoméstico não encontrado com id: " + id);
        }

    }

    @Override
    public void deleteAppliance(Long id) {
        try {
            applianceRepository.deleteById(id);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Eletrodoméstico não encontrado com id: " + id);
        }

    }
    public Appliance mapTo(ApplianceDTO dto, Appliance entity) {
        entity.setName(dto.getName());
        entity.setModel(dto.getModel());
        entity.setPower(dto.getPower());
        entity.setManufacturer(dto.getManufacturer());
        entity.setAddress(addressRepository.findById(dto.getAddressId())
                        .orElseThrow(() -> new ResourceNotFoundException("Não é possível realizar o cadastro em um endereço inexistente")));
        entity.setUserId(dto.getUserId());
        return entity;
    }
}
