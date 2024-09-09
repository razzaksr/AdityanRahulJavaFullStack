package org.controller.demo.SpringBoot_Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CardDbApi {
    @Autowired
    CardService cardService;

    @DeleteMapping("/remove/hql/{limit}")
    public String eraseByHql(@PathVariable("limit") int limit){
        return cardService.removingByHQL(limit);
    }

    @DeleteMapping("/remove/key/{id}")
    public String eraseById(@PathVariable("id") long id){
        return cardService.removingById(id);
    }

    @DeleteMapping("/remove")
    public String eraseByObject(@RequestBody Creditcard creditcard){
        return cardService.removingByObject(creditcard);
    }

    @GetMapping("/sql/{value}")
    public List<Creditcard> readManyBySqlLimit(@PathVariable("value") int value){
        return cardService.fetchManyBySqlLimit(value);
    }

    @GetMapping("/lesser/{value}")
    public List<Long> readManyByLimitLt(@PathVariable("value") int value){
        return cardService.fetchManyByLimitLt(value);
    }

    @GetMapping("/greater/{value}")
    public List<Creditcard> readManyByLimitGt(@PathVariable("value") int value){
        return cardService.fetchManyByLimitGt(value);
    }

    @GetMapping("/limit/{value}")
    public List<Creditcard> readManyByLimit(@PathVariable("value") int value){
        return cardService.fetchManyByLimit(value);
    }

    @GetMapping("/pin/{number}")
    public List<Creditcard> readManyByPin(@PathVariable("number") int number){
        return cardService.fetchManyByPin(number);
    }

    @GetMapping("/one/{number}")
    public Creditcard readOne(@PathVariable("number") long number){
        return cardService.fetchOneService(number);
    }

//    @GetMapping("/one/{number}")
//    public Optional<Creditcard> readOne(@PathVariable("number") long number){
//        return cardService.fetchOneService(number);
//    }

    @GetMapping("/show")
    public List<Creditcard> read(){
        return cardService.fetchService();
    }

//    @PostMapping("/submit")
//    public ResponseEntity savings(@RequestBody Creditcard creditcard){
//        return ResponseEntity.ok().body(cardService.savingService(creditcard));
//    }
    @PostMapping("/submit")
    public Creditcard savings(@RequestBody Creditcard creditcard){
        return cardService.savingService(creditcard);
    }
}
