package com.fundamentosplatzi.springboot.fundamento.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWitchDependencyImplement implements MyBeanWithDependecy{

    Log LOGGER = LogFactory.getLog(MyBeanWitchDependencyImplement.class);
    private MyOperation myOperation;

    public MyBeanWitchDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("hemos ingresado al metodo printWithDependency");
        int number = 1;
        LOGGER.debug("El numero enviado como parametro a la dependencia operativa es "+ number);
        System.out.println(this.myOperation.suma(number));
        System.out.println("hola desde la implemetracion de un bean c on dependencia");


    }
}
