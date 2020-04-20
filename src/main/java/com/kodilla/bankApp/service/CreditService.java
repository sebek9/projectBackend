package com.kodilla.bankApp.service;


import com.kodilla.bankApp.domain.Credit;
import com.kodilla.bankApp.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CreditService {
    @Autowired
    private CreditRepository repository;

    public List<Credit> getAllCredits(){
        return repository.findAll();
    }

    public Optional<Credit> getCredit(Long id){
        return repository.findById(id);
    }

    public Credit saveCredit(final Credit credit){
        return repository.save(credit);
    }

    public void deleteCredit(final Long id) {
        repository.deleteById(id);
    }
}
