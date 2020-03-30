package com.kodilla.bankApp.service;

import com.kodilla.bankApp.domain.Mail;
import com.kodilla.bankApp.domain.Payment;
import com.kodilla.bankApp.domain.Receiver;
import com.kodilla.bankApp.repository.PaymentRepository;
import com.kodilla.bankApp.repository.ReceiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private PaymentRepository repository;

    @Autowired
    private SimpleEmailService emailService;


    public List<Payment> getAllPayments(){
        return repository.findAll();
    }
    public Optional<Payment> getPayment(Long id){
        return repository.findById(id);
    }
    public Payment savePayment(final Payment payment){
        //do poprawy - email dziala
    emailService.send(new Mail("sebastian.kalinkowski@gmail.com","Nowa płatność","Płatnośc została zlecona"));
        return repository.save(payment);
    }
}

