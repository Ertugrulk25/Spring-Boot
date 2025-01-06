package com.tpe.employe;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class EmployeeController {
    public static void main(String[] args) {
        //kullanıcıdan alınan bilgilerle employee olusturalım
        //

        Employee employee=new Employee(1,"Ali Can","5000$");

        //employee objesini kaydetmeden önce service icerisinde manipulation gerekli olabilir

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        Scanner input=context.getBean(Scanner.class);

        EmployeeService service=context.getBean(EmployeeService.class);

        service.saveEmployee(employee);
    }
}
