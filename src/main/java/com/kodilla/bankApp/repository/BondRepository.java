package com.kodilla.bankApp.repository;

import com.kodilla.bankApp.domain.Bond;
import com.kodilla.bankApp.domain.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface BondRepository extends CrudRepository<Bond,Long> {

    @Override
    List<Bond>findAll();

    @Override
    Optional<Bond> findById(Long id);

    @Override
    Bond save(Bond bond);
}
