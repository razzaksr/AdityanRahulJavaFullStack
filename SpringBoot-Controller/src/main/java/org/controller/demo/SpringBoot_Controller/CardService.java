package org.controller.demo.SpringBoot_Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    @Autowired // dependency injection
    CardRepository cardRepository;

    public Creditcard savingService(Creditcard creditcard){
        return cardRepository.save(creditcard);
    }

}
