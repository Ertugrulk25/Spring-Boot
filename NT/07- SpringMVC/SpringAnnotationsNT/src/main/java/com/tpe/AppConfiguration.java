package com.tpe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

@Configuration//bu classta yapılandırma ayarları verilecek
@ComponentScan("com.tpe")//bu icerisine girdiginiz path'de yer alan tüm componentları arar.
//default path : AppConfiguration classın bulundugu path tanımlıdır
@PropertySource("classpath:application.properties")
//application.properties bilgilerin okunmasını sağlar
public class AppConfiguration {


    @Autowired
    private Environment environment;

    @Bean//thirdParty classtan bean olusturmasını sağlar
    public Random random(){
        return new Random();
    }

    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }

    //value anatosyonu ile yaptığımız işlemi environment ve properties classlarla da yapabiliriz

    @Bean//build in class
    public Properties properties(){
        Properties properties =new Properties();
        //properties.put("mymail","techproed@gmail.com");
        properties.put("mymail",environment.getProperty("eposta"));
        properties.put("myphone",environment.getProperty("phone"));
        properties.put("password",environment.getProperty("password.admin"));
        properties.put("database",environment.getProperty("database.url"));
        return properties;
    }


}
