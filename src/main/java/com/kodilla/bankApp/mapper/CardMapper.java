package com.kodilla.bankApp.mapper;

import com.kodilla.bankApp.domain.Card;
import com.kodilla.bankApp.domain.dTo.CardDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CardMapper {
    public Card mapToCard(final CardDto cardDto){
        return new Card(
                cardDto.getId(),
                cardDto.getCardNumber(),
                cardDto.getCardType(),
                cardDto.getCardHolder(),
                cardDto.getStatus()
        );
    }
    public CardDto mapToCardDto(final Card card){
        return new CardDto(
                card.getId(),
                card.getCardNumber(),
                card.getCardType(),
                card.getCardHolder(),
                card.getStatus()
        );
    }

    public List<CardDto>mapToCardDtoList(final List<Card>cardList){
        return cardList.stream()
                .map(p->new CardDto(p.getId(),p.getCardNumber(),p.getCardType(),p.getCardHolder(),p.getStatus()))
                .collect(Collectors.toList());
    }
}
