package com.tpe.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter//tüm fieldlar için getter methodunun tanımlanmasını sağlar
@Setter//tüm fieldlar için setter methodunun tanımlanmasını sağlar
@AllArgsConstructor//tüm fieldlarin icerisinde tanımlı oldugu bir cons. olusturmayi saglar
@NoArgsConstructor//defualt cons. olusmasını sağlar

//@RequiredArgsConstructor//sadece final değerleri atamayı sağlayan cons.
////objeyi const ederken final olan zorunlu degerleri
//public Student(String name, String lastname) {
//        this.name = name;
//        this.lastname = lastname;
//        }
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotBlank(message = "Name can not be blank!")//null, "","    ", kabul etmez
    //@NotEmpty//null,"" kabul etmez "        " kabul eder
    //@NotNull//null kabul etmez "" ,"       " kabul eder.
    @Size(min = 2,max = 50,message = "name must be between 2 and 50")
    @Column(nullable = false)
    /*final*/ private String name;

    @NotBlank(message = "Lastname can not be blank!")
    @Size(min = 2,max = 50,message = "lastname must be between 2 and 50")
    @Column(nullable = false)
    /*final*/private String lastname;

    @NotNull(message = "Please provide grade")
    @Column(nullable = false)
    private Integer grade;

    @Email(message = "please provide valid email!!!")//aaa@bbb.ccc email formatında olmasını dogrulama
    //@Pattern():regex ile formatlama yapmayi sağlar
    @Column(nullable = false,unique = true)
    private String email;

    @Setter(AccessLevel.NONE)
    private LocalDateTime createDate=LocalDateTime.now();

    //getter-setter


}