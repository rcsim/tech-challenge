package br.com.postech30.challenge.repository;

import br.com.postech30.challenge.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
    PessoaEntity save(PessoaEntity pessoaEntity);

}