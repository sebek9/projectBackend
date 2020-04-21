package com.kodilla.bankApp.repository;

import com.kodilla.bankApp.domain.Card;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface CardRepository extends CrudRepository<Card,Long> {

    @Override
    List<Card>findAll();

    @Override
    Optional<Card> findById(Long id);

    @Override
    Card save(Card card);

    @Override
    void deleteById(Long id);
}
