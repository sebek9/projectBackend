package com.kodilla.bankApp.scheduler;


import com.kodilla.bankApp.domain.Mail;
import com.kodilla.bankApp.repository.PaymentRepository;
import com.kodilla.bankApp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {


    @Autowired
    private EmailService service;
    @Autowired
    private PaymentRepository repository;


    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail(){

        long size = repository.count();
        String name = " payment";
        if(size > 1) {
            name = " payments";
        }
        service.send(new Mail(
                "sebek9@poczta.onet.pl",
                "Currently in database you got: " + size + name,null));

    }
}

