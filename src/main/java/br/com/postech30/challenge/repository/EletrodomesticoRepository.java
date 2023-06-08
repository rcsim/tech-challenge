package br.com.postech30.challenge.repository;

import br.com.postech30.challenge.entity.EletrodomesticoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EletrodomesticoRepository extends JpaRepository<EletrodomesticoEntity,Integer> {
    EletrodomesticoEntity save(EletrodomesticoEntity eletrodomesticoEntity);
}
