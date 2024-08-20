package org.controller.demo.SpringBoot_Controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/card")
public class CrudApi {

    // collection as storage logic: temporary memory
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

//    @DeleteMapping("/erase/{cardNumber}")
//public String deleteByKey(@PathVariable long cardNumber){
    @DeleteMapping("/erase")
    public String deleteByKey(@RequestBody long cardNumber){
        //myBankCustomers=myBankCustomers.stream().filter(each->each.getCardNumber()==cardNumber).collect(Collectors.toList());
        Creditcard creditcard=null;
        for(int index=0;index< myBankCustomers.size();index++){
            if(myBankCustomers.get(index).getCardNumber()==cardNumber){
                creditcard=myBankCustomers.get(index);
                break;
            }
        }
        if(creditcard!=null){
            myBankCustomers.remove(creditcard);
            return creditcard.getCardNumber()+" has been suspended";
        }
        return cardNumber+" hasn't matched with our records";
    }

    @PutMapping("/alter")
    public Creditcard updateExists(@RequestBody Creditcard creditcard){
        for(int index=0;index< myBankCustomers.size();index++){
            if(myBankCustomers.get(index).getCardNumber()== creditcard.getCardNumber()){
                myBankCustomers.set(index,creditcard);
                return creditcard;
            }
        }
        return null;
    }

    @PostMapping("/new")
    public Creditcard saveNew(@RequestBody Creditcard creditcard){
        myBankCustomers.add(creditcard);
        return creditcard;
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
