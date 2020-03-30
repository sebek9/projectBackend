package com.kodilla.bankApp.mapper;


import com.kodilla.bankApp.domain.Receiver;
import com.kodilla.bankApp.domain.ReceiverDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReceiverMapper {
    public Receiver mapToReceiver(final ReceiverDto receiverDto){
        return new Receiver(
                receiverDto.getId(),
                receiverDto.getName(),
                receiverDto.getSurname(),
                receiverDto.getAddress()
        );
    }
    public ReceiverDto mapToReceiverDto(final Receiver receiver){
        return new ReceiverDto(
                receiver.getId(),
                receiver.getName(),
                receiver.getSurname(),
                receiver.getAddress()
        );
    }

    public List<ReceiverDto> mapToReceiverDtoList(final List<Receiver>receiversList){
        return receiversList.stream()
                .map(p->new ReceiverDto(p.getId(),p.getName(),p.getSurname(),p.getAddress()))
                .collect(Collectors.toList());
    }
}