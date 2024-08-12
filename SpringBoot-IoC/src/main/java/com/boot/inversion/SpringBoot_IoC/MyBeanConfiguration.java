package com.boot.inversion.SpringBoot_IoC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.boot.inversion.SpringBoot_IoC")
public class MyBeanConfiguration {
    @Bean
    public Beneficiary getBeneficiary(){
        return new Beneficiary(937,"Razak Mohamed S",87656787656L);
    }
    @Bean(autowireCandidate = false, name = "ben1")
    public Beneficiary getBeneficiaryOne(){
        Beneficiary beneficiary=new Beneficiary();
        beneficiary.setBeneficiaryName("Adhityan");
        return beneficiary;
    }
}
