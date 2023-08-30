package br.com.postech30.challenge.repository;

import br.com.postech30.challenge.entity.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Address save(Address address);

    Page<Address> findByStreetIgnoreCaseContainingOrDistrictIgnoreCaseContainingOrCityIgnoreCaseContainingOrStateIgnoreCaseContaining(String street, String district, String city, String state, Pageable pageable);
}
