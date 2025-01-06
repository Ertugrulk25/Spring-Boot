package com.tpe.employe;

import org.springframework.stereotype.Component;

@Component
public class EmployeeRepo implements Repo{
    //repo db işlemleri
    public void save(Employee employee){
        System.out.println("Employee is saved. Id : "+employee.getId());
    }
}
