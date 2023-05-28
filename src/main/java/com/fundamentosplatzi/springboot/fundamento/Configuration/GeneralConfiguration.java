package com.fundamentosplatzi.springboot.fundamento.Configuration;

import com.fundamentosplatzi.springboot.fundamento.bean.MyBeanImplemetUser;
import com.fundamentosplatzi.springboot.fundamento.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:conection.properties")
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;
    @Value("${value.apellido}")
    private String apellido;
    @Value("${value.random}")
    private String random;
    @Value("${jdbc.url}")
    private String urlConnetion;
    @Value("${driver}")
    private String driver;
    @Value("${username}")
    private String userName;
    @Value("${password}")
    private String password;
    @Bean
    public MyBeanImplemetUser function(){
        return new MyBeanImplemetUser(name,apellido);
    }

    @Bean
    public DataSource dataSource(){
        this.imprimirDatosPantalla();
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(this.driver);
        dataSourceBuilder.url(this.urlConnetion);
        dataSourceBuilder.username(this.userName);
        dataSourceBuilder.password(this.password);
        return dataSourceBuilder.build();
    }

    private void imprimirDatosPantalla(){
        System.out.println("hola");
        System.out.println(this.urlConnetion+" "+ this.driver
                +" "+this.userName+" "+ this.password);
    }
}
