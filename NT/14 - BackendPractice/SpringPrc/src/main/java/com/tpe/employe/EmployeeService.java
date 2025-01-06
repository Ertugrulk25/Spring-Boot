package com.tpe.employe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {

//    private Repo repo;//maliyetli hemde cok sıkı değil bağlı bir yapı
//
//
//    public EmployeeService(Repo repo) {
//        this.repo = repo;
//    }

    @Autowired
    @Qualifier("employeeRepo")
    private Repo repo;

    //kaydetme
    public void saveEmployee(Employee employee){
        System.out.println("Employee is saving....");
        repo.save(employee);
    }
}
