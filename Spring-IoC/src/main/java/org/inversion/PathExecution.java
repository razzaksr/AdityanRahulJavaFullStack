package org.inversion;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PathExecution {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("mydispatcher.xml");
        Beneficiary beneficiary = (Beneficiary) applicationContext.getBean("ben1");
        System.out.println(beneficiary);
    }
}
