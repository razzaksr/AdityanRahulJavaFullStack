package org.controller.demo.SpringBoot_Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/card")
public class CrudApi {
    private List<Creditcard> myBankCustomers=new ArrayList<>();
    public CrudApi(){
        Creditcard creditcard1=new Creditcard();
        creditcard1.setCardAvailable(100000);creditcard1.setCardNumber(876545678L);creditcard1.setCardPin(1111);
        Creditcard creditcard2=new Creditcard();
        creditcard2.setCardAvailable(50000);creditcard2.setCardNumber(8765434567654L);creditcard2.setCardPin(1910);
        Creditcard creditcard3=new Creditcard();
        creditcard3.setCardAvailable(20000);creditcard3.setCardNumber(98765454545454L);creditcard3.setCardPin(9999);
        myBankCustomers= Stream.of(creditcard1,creditcard2,creditcard3).collect(Collectors.toList());
    }

    @GetMapping("/customers")
    public List<Creditcard> viewCustomers(){
        return myBankCustomers;
    }

    @GetMapping("/one/{cards}")
    public Creditcard viewOneCustomer(@PathVariable("cards") long cards){
        return myBankCustomers.stream().filter(each->each.getCardNumber()==cards).collect(Collectors.toList()).get(0);
    }
}
