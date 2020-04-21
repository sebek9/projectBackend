package com.kodilla.bankApp.repository;

import com.kodilla.bankApp.domain.Credit;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface CreditRepository extends CrudRepository<Credit,Long> {

    @Override
    List<Credit>findAll();

    @Override
    Optional<Credit> findById(Long id);

    @Override
    Credit save(Credit credit);

    @Override
    void deleteById(Long id);
}