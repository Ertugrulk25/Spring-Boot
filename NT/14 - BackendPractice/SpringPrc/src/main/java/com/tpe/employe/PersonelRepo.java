package com.tpe.employe;

import org.springframework.stereotype.Component;

@Component
public class PersonelRepo implements Repo {

    public void save(Employee employee){
        System.out.println("Personel is saved. Id : "+employee.getId());
    }
}
