package org.controller.demo.SpringBoot_Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CardDbApi {
    @Autowired
    CardService cardService;

    @PostMapping("/submit")
    public ResponseEntity savings(@RequestBody Creditcard creditcard){
        return ResponseEntity.ok().body(cardService.savingService(creditcard));
    }
}
