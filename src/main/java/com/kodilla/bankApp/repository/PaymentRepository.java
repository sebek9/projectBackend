package com.kodilla.bankApp.repository;

import com.kodilla.bankApp.domain.Payment;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends CrudRepository<Payment,Long> {

    @Override
    List<Payment>findAll();

    @Override
    Optional<Payment> findById(Long id);

    @Override
    Payment save(Payment payment);

    @Override
    void deleteById(Long id);
}
