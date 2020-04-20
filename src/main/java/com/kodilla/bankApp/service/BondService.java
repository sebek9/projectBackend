package com.kodilla.bankApp.service;

import com.kodilla.bankApp.domain.Bond;
import com.kodilla.bankApp.domain.Mail;
import com.kodilla.bankApp.domain.Payment;
import com.kodilla.bankApp.repository.BondRepository;
import com.kodilla.bankApp.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BondService {
    @Autowired
    private BondRepository repository;

    public List<Bond> getAllBonds(){
        return repository.findAll();
    }

    public Optional<Bond> getBond(Long id){
        return repository.findById(id);
    }

    public Bond saveBond(final Bond bond){
       return repository.save(bond);
    }

    public void deleteBond(final Long id) {
        repository.deleteById(id);
    }
}
