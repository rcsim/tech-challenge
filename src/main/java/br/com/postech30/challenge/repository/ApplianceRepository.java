package br.com.postech30.challenge.repository;

import br.com.postech30.challenge.entity.Appliance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplianceRepository extends JpaRepository<Appliance,Integer> {
    Appliance save(Appliance appliance);
}
