package com.kodilla.bankApp.service;

import com.kodilla.bankApp.domain.Receiver;
import com.kodilla.bankApp.repository.ReceiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceiverDbService {
    @Autowired
    private ReceiverRepository repository;

    public List<Receiver> getAllReceivers(){
        return repository.findAll();
    }
    public Optional<Receiver> getReceiver(Long id){
        return repository.findById(id);
    }
    public Receiver saveReceiver(final Receiver receiver){
        return repository.save(receiver);
    }
}

