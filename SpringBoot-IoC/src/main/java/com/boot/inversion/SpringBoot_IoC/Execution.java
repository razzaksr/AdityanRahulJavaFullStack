package com.boot.inversion.SpringBoot_IoC;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
public class Execution {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MyBeanConfiguration.class);
        Beneficiary beneficiary=context.getBean(Beneficiary.class);
        System.out.println(beneficiary);
        beneficiary=(Beneficiary) context.getBean("ben1");
        System.out.println(beneficiary);
    }
}
