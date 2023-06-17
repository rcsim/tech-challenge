package br.com.postech30.challenge.repository;

import br.com.postech30.challenge.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Address save(Address address);
}
