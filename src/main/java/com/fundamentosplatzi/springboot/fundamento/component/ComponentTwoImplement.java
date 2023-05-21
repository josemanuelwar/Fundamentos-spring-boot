package com.fundamentosplatzi.springboot.fundamento.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("ComponentTwoImplement")
public class ComponentTwoImplement implements ComponentDependency{
    @Override
    public void saludar() {
        System.out.println("hola desde mi complemeto dos");
    }
}
