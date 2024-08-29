package org.controller.demo.SpringBoot_Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired // dependency injection
    CardRepository cardRepository;

    public List<Long> fetchManyByLimitLt(int limit){
        return cardRepository.findAllByLesserAvailable(limit);
    }

    public List<Creditcard> fetchManyByLimitGt(int limit){
        return cardRepository.findAllByGreaterAvailable(limit);
    }

    public List<Creditcard> fetchManyByLimit(int limit){
        return cardRepository.findAllByCardAvailable(limit);
    }

    public List<Creditcard> fetchManyByPin(int pin){
        return cardRepository.findAllByCardPin(pin);
    }

    public Creditcard fetchOneService(long userCard){
        return cardRepository.findById(userCard).orElse(new Creditcard());
    }

//    public Optional<Creditcard> fetchOneService(long userCard){
//        return cardRepository.findById(userCard);
//    }

    public List<Creditcard> fetchService(){
        return (List<Creditcard>) cardRepository.findAll();
    }

    public Creditcard savingService(Creditcard creditcard){
        return cardRepository.save(creditcard);
    }

}
