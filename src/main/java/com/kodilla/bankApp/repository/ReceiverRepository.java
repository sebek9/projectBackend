package com.kodilla.bankApp.repository;

import com.kodilla.bankApp.domain.Payment;
import com.kodilla.bankApp.domain.Receiver;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReceiverRepository extends CrudRepository<Receiver,Long> {

    @Override
    List<Receiver> findAll();

    @Override
    Optional<Receiver> findById(Long id);

    @Override
    Receiver save(Receiver receiver);
}
