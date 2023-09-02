package br.com.postech30.challenge.repository;

import br.com.postech30.challenge.entity.Appliance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplianceRepository extends JpaRepository<Appliance, Long> {
   // Appliance save(Appliance appliance);

    List<Appliance> findByAddress_Id(Long id);

    List<Appliance> findByDependentSet_Id(Long id);

    Page<Appliance> findByNameIgnoreCaseContainingOrModelIgnoreCaseContainingOrPowerIgnoreCaseContainingOrManufacturerIgnoreCaseContaining(String name, String model, String power, String manufacturer, Pageable pageable);

}
