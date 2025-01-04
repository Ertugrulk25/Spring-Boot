package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.Scanner;

@Configuration//bu classta yapılandırma ayarları verilecek
@ComponentScan("com.tpe")//bu icerisine girdiginiz path'de yer alan tüm componentları arar.
//default path : AppConfiguration classın bulundugu path tanımlıdır
public class AppConfiguration {

    @Bean//thirdParty classtan bean olusturmasını sağlar
    public Random random(){
        return new Random();
    }

    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }


}
