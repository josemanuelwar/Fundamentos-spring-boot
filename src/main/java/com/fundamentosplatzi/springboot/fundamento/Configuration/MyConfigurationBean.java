package com.fundamentosplatzi.springboot.fundamento.Configuration;

import com.fundamentosplatzi.springboot.fundamento.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation(){
        return new MyBeanImplementTow();
    }
    @Bean
    public MyOperation beMyOperation(){
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependecy beanMyBeanWithDependecy(MyOperation myOperation){
        return  new MyBeanWitchDependencyImplement (myOperation);
    }

}
