package com.kodilla.bankApp.service;

import com.kodilla.bankApp.domain.Payment;
import com.kodilla.bankApp.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private PaymentRepository repository;

    public List<Payment> getAllPayments(){
        return repository.findAll();
    }
    public Optional<Payment> getPayment(Long id){
        return repository.findById(id);
    }
    public Payment savePayment(final Payment payment){
        return repository.save(payment);
    }
}
