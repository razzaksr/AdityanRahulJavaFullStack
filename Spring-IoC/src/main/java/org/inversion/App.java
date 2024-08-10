package org.inversion;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
//        Insurance insurance=new Insurance();
//        insurance.setInsuranceId(765);
//        System.out.println(insurance);
//        Insurance insurance1=new Insurance(123,"PMAKY","Health",5,200000);
//        System.out.println(insurance1.getInsuranceName());
        BeanFactory beanFactory=new FileSystemXmlApplicationContext("spring-dispatcher.xml");
        Insurance insurance=(Insurance) beanFactory.getBean("axis1");
        System.out.println(insurance);
        insurance=(Insurance)beanFactory.getBean("icici1");
        System.out.println(insurance);
        insurance=(Insurance)beanFactory.getBean("canara");
        System.out.println(insurance);


    }
}
