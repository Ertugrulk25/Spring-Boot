package com.tpe.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateStudentDTO {

    @NotBlank(message = "Name can not be blank!")//null, "","    ", kabul etmez
    //@NotEmpty//null,"" kabul etmez "        " kabul eder
    //@NotNull//null kabul etmez "" ,"       " kabul eder.
    @Size(min = 2,max = 50,message = "name must be between 2 and 50")
    /*final*/ private String name;

    @NotBlank(message = "Lastname can not be blank!")
    @Size(min = 2,max = 50,message = "lastname must be between 2 and 50")
    /*final*/private String lastname;

    @Email(message = "please provide valid email!!!")//aaa@bbb.ccc email formatında olmasını dogrulama
    //@Pattern():regex ile formatlama yapmayi sağlar
    private String email;


}