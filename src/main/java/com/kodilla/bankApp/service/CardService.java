package com.kodilla.bankApp.service;

import com.kodilla.bankApp.domain.Card;
import com.kodilla.bankApp.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    private CardRepository repository;

    public List<Card> getAllCards(){
        return repository.findAll();
    }

    public Optional<Card> getCard(Long id){
        return repository.findById(id);
    }

    public Card saveCard(final Card card){
        return repository.save(card);
    }

    public void deleteCard(final Long id) {
        repository.deleteById(id);
    }
}
