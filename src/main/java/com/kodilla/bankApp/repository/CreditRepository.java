package com.kodilla.bankApp.repository;

import com.kodilla.bankApp.domain.Card;
import com.kodilla.bankApp.domain.Credit;
import com.kodilla.bankApp.domain.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CreditRepository extends CrudRepository<Credit,Long> {

    @Override
    List<Credit>findAll();

    @Override
    Optional<Credit> findById(Long id);

    @Override
    Credit save(Credit credit);
}