package org.controller.demo.SpringBoot_Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired // dependency injection
    CardRepository cardRepository;

    public String removingByHQL(int limit){
        cardRepository.deleteByLimit(limit);
        return limit+" matching cards are suspended";
    }

    public String removingById(long id){
        cardRepository.deleteById(id);
        return id+" has suspended permanently";
    }

    public String removingByObject(Creditcard creditcard){
        cardRepository.delete(creditcard);
        return creditcard.getCardNumber()+" has suspended permanently";
    }

    public List<Creditcard> fetchManyBySqlLimit(int limit){
        return cardRepository.findAllBySqlAvailable(limit);
    }

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
