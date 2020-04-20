package com.kodilla.bankApp.service;


        import com.kodilla.bankApp.controller.ReceiverController;
        import com.kodilla.bankApp.domain.Receiver;
        import com.kodilla.bankApp.repository.ReceiverRepository;
        import org.junit.jupiter.api.Test;
        import org.junit.runner.RunWith;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.mockito.junit.MockitoJUnitRunner;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Optional;

        import static org.mockito.Mockito.*;
        import static org.junit.Assert.assertEquals;
        import static org.mockito.ArgumentMatchers.any;
        import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReceiverPaymentServiceTest {

    @InjectMocks
    private ReceiverDbService receiverDbService;

    @Mock
    private ReceiverRepository receiverRepository;

    @Mock
    private ReceiverController receiverController;

    @Test
    public void shouldGetAllTasks() {
        //Given
        List<Receiver> receivers = new ArrayList<>();
        receivers.add(new Receiver(1L, "Jan", "Dabrowski", "Polna"));

        when(receiverRepository.findAll()).thenReturn(receivers);

        //When
        List<Receiver> theList = receiverDbService.getAllReceivers();

        //Then
        assertEquals(1, theList.size());
    }

    @Test
    public void shouldGetTask() {
        //Given
        Receiver receiver = new Receiver(1L, "Jan", "Dabrowski", "Polna");
        long t = 1L;
        when(receiverRepository.findById(t)).thenReturn(Optional.ofNullable(receiver));

        //When
        Optional<Receiver> theList = receiverDbService.getReceiver(t);
        long o = theList.get().getId();

        //Then
        assertEquals(1L, o);
    }

    @Test
    public void shouldSaveTask() {
        //Given
        Receiver receiver = new Receiver(1L, "Jan", "Dabrowski", "Polna");

        when(receiverRepository.save(any())).thenReturn(receiver);

        //When
        Receiver theReceiver = receiverDbService.saveReceiver(receiver);
        long id = theReceiver.getId();

        //Then
        assertEquals(1L, id);
        assertEquals("Jan", theReceiver.getName());
    }

    @Test
    public void shouldDeleteTask() {
        //Given
        Receiver receiver = new Receiver(1L, "Jan", "Dabrowski", "Polna");
        long receiverId = receiver.getId();

        //When
        receiverController.deleteReceiver(receiverId);

        //Then
        verify(receiverController, times(1)).deleteReceiver(receiverId);
    }
}
