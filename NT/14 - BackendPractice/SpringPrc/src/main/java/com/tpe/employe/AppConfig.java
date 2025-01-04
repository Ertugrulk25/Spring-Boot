package com.tpe.employe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan("com.tpe")
public class AppConfig {

    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }
}
