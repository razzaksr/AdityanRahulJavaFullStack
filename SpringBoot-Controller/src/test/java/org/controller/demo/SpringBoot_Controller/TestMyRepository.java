package org.controller.demo.SpringBoot_Controller;

import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Mockito : to generate mock data
JUnit : to test the resource either using original/ mock data
 */

// test class
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TestMyRepository {
    // methods annotated by @Test: test cases
    @Mock
    CardRepository cardRepository;// mock data generation

    @InjectMocks
    CardService cardService;// applying mock data

    List<Creditcard> myCustomers;

    @BeforeEach
    public void initialize(){
        Creditcard creditcard1=new Creditcard();
        creditcard1.setCardPin(1234);creditcard1.setCardNumber(87654567876567L);creditcard1.setCardAvailable(75000);
        Creditcard creditcard2=new Creditcard();
        creditcard2.setCardPin(1112);creditcard2.setCardNumber(98788388333L);creditcard2.setCardAvailable(50000);
        Creditcard creditcard3=new Creditcard();
        creditcard3.setCardPin(9991);creditcard3.setCardNumber(98765676562L);creditcard3.setCardAvailable(100000);

        myCustomers = Stream.of(creditcard1,creditcard2,creditcard3).collect(Collectors.toList());

    }

    @Test // test case
    public void testFindAll1(){
        // using mockito to inject mock values
        when(cardRepository.findAll()).thenReturn(myCustomers);
        // expected vs actual
        assertSame(3,cardService.fetchService().size());
    }

    @Test
    public void testFindAll2(){
        // using mockito to inject mock values
        when(cardRepository.findAll()).thenReturn(myCustomers);
        assertFalse(cardService.fetchService().get(1).getCardNumber()==98765676562L);
    }

    @Test
    public void testInsertion(){
        Creditcard creditcard=new Creditcard();
        creditcard.setCardPin(1991);creditcard.setCardNumber(111232323233L);creditcard.setCardAvailable(50000);

        when(cardRepository.save(creditcard)).thenReturn(creditcard);

        assertEquals(50000,cardService.savingService(creditcard).getCardAvailable());
    }

    @Test
    public void testFindByID(){
        Creditcard creditcard=new Creditcard();
        creditcard.setCardPin(1991);creditcard.setCardNumber(111232323233L);creditcard.setCardAvailable(50000);
        when(cardRepository.findById(111232323233L)).thenReturn(Optional.of(creditcard));

//        assertNotSame(1991,cardService.fetchOneService(111232323233L).getCardPin());
        assertNotEquals(1992,cardService.fetchOneService(111232323233L).getCardPin());
    }

    @Test
    public void testDeleteId(){
        Creditcard creditcard=new Creditcard();
        creditcard.setCardPin(1991);creditcard.setCardNumber(111232323233L);creditcard.setCardAvailable(50000);
        Creditcard creditcard2=new Creditcard();
        creditcard2.setCardPin(1112);creditcard2.setCardNumber(98788388333L);creditcard2.setCardAvailable(50000);

        // for void methods
        doNothing().when(cardRepository).deleteById(111232323233L);

        cardService.removingById(111232323233L);

        verify(cardRepository).deleteById(111232323233L);
    }

}
