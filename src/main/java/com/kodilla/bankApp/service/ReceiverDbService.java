package com.kodilla.bankApp.service;

import com.kodilla.bankApp.domain.Mail;
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

    @Autowired
    private EmailService emailService;

    public List<Receiver> getAllReceivers(){
        return repository.findAll();
    }
    public Optional<Receiver> getReceiver(Long id){
        return repository.findById(id);
    }
    public Receiver saveReceiver(final Receiver receiver){
        //TODO mail functionality works - > need to be implemented in other services
        emailService.send(new Mail("sebastian.kalinkowski@gmail.com","Odbiorca","Nowy odbiorca został dodany"));
        return repository.save(receiver);
    }

    public void deleteReceiver(final Long id) {
        repository.deleteById(id);
    }
}

