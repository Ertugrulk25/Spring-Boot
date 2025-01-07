package com.tpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller//requestler bu classta karşılanacak ve ilgili metodlarla maplenecek
@RequestMapping("/students")//http:localhost:8080/SpringMvc/students/....
//class:tüm metodlar için geçerli olur
//method:sadece ilgili metodu requestle mapler
public class StudentController {


    //NOT:controllerda metodlar geriye mav veya String data tipi döndürebilir.



    //http:localhost:8080/SpringMvc/students/hi + GET--okuma
    //http:localhost:8080/SpringMvc/students/hi + POST--kayıt
    //@RequestMapping("/students")
    @GetMapping("/hi")
    public ModelAndView sayHi(){
        //response u hazırlayacak
        ModelAndView mav=new ModelAndView();
        mav.addObject("message","Hi,");
        mav.addObject("messagebody","I'm a Student Management System");
        mav.setViewName("hi");
        return mav;
    }

    //view resolver : /WEB-INF/views/hi.jsp dosyasını bulur ve mav içindeki modelı
    //dosyaya bind eder ve clienta gönderir.

    //1-tüm öğrencileri listeleme:
    //http://localhost:8080/SpringMvc/students + GET
    @GetMapping
    public ModelAndView getStudents(){
        ModelAndView mav=new ModelAndView();
        //todo:dbden liste gelecek...
        mav.setViewName("students");
        return mav;
    }








}
