package com.kodilla.bankApp.controller;

import com.kodilla.bankApp.controller.exceptions.CardNotFoundException;
import com.kodilla.bankApp.domain.dTo.CardDto;
import com.kodilla.bankApp.mapper.CardMapper;
import com.kodilla.bankApp.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("v1/card")
@CrossOrigin(origins ="*")
public class CardController {
    @Autowired
    private CardService service;
    @Autowired
    private CardMapper cardMapper;

    @RequestMapping(method = RequestMethod.GET,value = "/getCards")
    public List<CardDto> getCards() {
        return cardMapper.mapToCardDtoList(service.getAllCards());
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getCard")
    public CardDto getCard(Long cardId) throws CardNotFoundException {
        return cardMapper.mapToCardDto(service.getCard(cardId).orElseThrow(CardNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/deleteCard")
    public void deleteCard(@PathVariable Long cardId){

    }
    @RequestMapping(method = RequestMethod.PUT,value = "/updateCard")
    public CardDto updateCard(@RequestBody CardDto cardDto){
        return cardMapper.mapToCardDto(service.saveCard(cardMapper.mapToCard(cardDto))); }

    //
    @RequestMapping(method = RequestMethod.POST,value = "/createCard",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCard(@RequestBody CardDto cardDto){
        service.saveCard(cardMapper.mapToCard(cardDto));
    }
}
