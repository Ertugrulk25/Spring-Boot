package com.tpe.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//requestler bu classtaki metodlarla eşleştirilecek ve responselar hazırlanacak
//@ResponseBody :metodun dönüş değerini JSON formatında cevap olarak hazırlar
// obje<->Jackson
@RequestMapping("/students")//https://localhost:8080/students...
public class StudentController {
}
