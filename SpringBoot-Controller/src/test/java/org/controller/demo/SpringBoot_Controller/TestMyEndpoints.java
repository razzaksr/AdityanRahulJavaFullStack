package org.controller.demo.SpringBoot_Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestMyEndpoints {
    @MockBean
    CardService cardService;
    @InjectMocks
    CardDbApi cardDbApi;
    @Autowired
    MockMvc mockMvc;

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

    @Test
    public void testRead() throws Exception {
        when(cardService.fetchService()).thenReturn(myCustomers);
        mockMvc.perform(get("/api/show")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].cardNumber").value(87654567876567L))
                .andExpect(jsonPath("$[0].cardAvailable").value(75000))
                .andExpect(jsonPath("$[0].cardPin").value(1234))
                .andExpect(jsonPath("$[1].cardNumber").value(98788388333L))
                .andExpect(jsonPath("$[1].cardAvailable").value(50000))
                .andExpect(jsonPath("$[1].cardPin").value(1112))
                .andExpect(jsonPath("$[2].cardNumber").value(98765676562L))
                .andExpect(jsonPath("$[2].cardAvailable").value(100000))
                .andExpect(jsonPath("$[2].cardPin").value(9991));
    }

    /*
        {
          "cardNumber": 3477346734,
          "cardAvailable": 65000,
          "cardPin": 9239
        }
    */
    @Test
    public void testSavings() throws Exception {
        String myRequest = "{\n" +
                "  \"cardNumber\": 3477346734,\n" +
                "  \"cardAvailable\": 65000,\n" +
                "  \"cardPin\": 9239\n" +
                "}";
        Creditcard creditcard=new Creditcard();
        creditcard.setCardAvailable(65000);creditcard.setCardNumber(3477346734L);
        creditcard.setCardPin(9239);

        when(cardService.savingService(any())).thenReturn(creditcard);

        mockMvc.perform(post("/api/submit").contentType
                (MediaType.APPLICATION_JSON).
                content(myRequest)).
                andExpect(status().isOk())
                .andExpect(jsonPath("$.cardNumber").value(3477346734L))
                .andExpect(jsonPath("$.cardAvailable").value(65000))
                .andExpect(jsonPath("$.cardPin").value(9239));

    }

    @Test
    public void testErase() throws Exception {
        String myRequest = "{\n" +
                "  \"cardNumber\": 3477346734,\n" +
                "  \"cardAvailable\": 65000,\n" +
                "  \"cardPin\": 9239\n" +
                "}";

        Creditcard creditcard=new Creditcard();
        creditcard.setCardAvailable(65000);creditcard.setCardNumber(3477346734L);
        creditcard.setCardPin(9239);

        when(cardService.removingByObject(any())).thenReturn("3477346734 has suspended permanently");

        mockMvc.perform(delete("/api/remove")
                .contentType(MediaType.APPLICATION_JSON)
                .content(myRequest))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("3477346734 has suspended permanently"));
        ;
    }

}
