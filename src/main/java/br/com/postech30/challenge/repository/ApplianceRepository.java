package br.com.postech30.challenge.repository;

import br.com.postech30.challenge.entity.Appliance;
import br.com.postech30.challenge.entity.Dependent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplianceRepository extends JpaRepository<Appliance,Integer> {
    Appliance save(Appliance appliance);

    List<Appliance> findByAddress_Id(Long id);

    List<Appliance> findByNameIgnoreCaseContainingOrModelIgnoreCaseContainingOrPowerIgnoreCaseContainingOrManufacturerIgnoreCaseContaining(String name, String model, String power, String manufacturer);

}
