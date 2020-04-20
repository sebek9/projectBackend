package com.kodilla.bankApp.repository;

import com.kodilla.bankApp.domain.Card;
import com.kodilla.bankApp.domain.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends CrudRepository<Card,Long> {

    @Override
    List<Card>findAll();

    @Override
    Optional<Card> findById(Long id);

    @Override
    Card save(Card card);
}
