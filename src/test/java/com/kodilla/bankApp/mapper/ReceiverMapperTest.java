package com.kodilla.bankApp.mapper;

import com.kodilla.bankApp.domain.Receiver;
import com.kodilla.bankApp.domain.dTo.ReceiverDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ReceiverMapperTest {

    @InjectMocks
    private ReceiverMapper receiverMapper;


    @Test
    public void testMapToTask() {
        //Given
        ReceiverDto receiverDto1 = new ReceiverDto(1L, "Jan", "Dabrowski", "Polna");
        //When
        Receiver receiver = receiverMapper.mapToReceiver(receiverDto1);
        //Then
        //Then
        assertEquals("Jan", receiver.getName());
        assertEquals("Dabrowski", receiver.getSurname());
        assertEquals("Polna", receiver.getAddress());
    }

    @Test
    public void testMapToTaskDto() {
        //Given
        Receiver receiver1 = new Receiver(1L, "Jan", "Dabrowski", "Polna");
        //When
        ReceiverDto receiverDto = receiverMapper.mapToReceiverDto(receiver1);
        //Then
        assertEquals("Jan", receiver1.getName());
        //TODO poprawic
        //  assertEquals(200.00, payment1.getAmount());
        assertEquals("Polna", receiver1.getAddress());
    }

    @Test
    public void testMapToTaskDtoList() {
        //Given
        List<ReceiverDto> dtoList = new ArrayList<>();
        dtoList.add(new ReceiverDto(1L, "Jan", "Dabrowski", "Polna"));
        List<Receiver> receiverList = new ArrayList<>();
        receiverList.add(new Receiver(1L, "Jan", "Dabrowski", "Polna"));

        //When
        List<ReceiverDto> theReceiverDto = receiverMapper.mapToReceiverDtoList(receiverList);

        //Then
        assertEquals(1, theReceiverDto.size());
    }

}