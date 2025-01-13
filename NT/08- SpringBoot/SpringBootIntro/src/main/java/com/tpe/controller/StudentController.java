package com.tpe.controller;

import com.tpe.domain.Student;
import com.tpe.service.StudentService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
clienttan 3 şekilde veri alınır
1-requestion body(JSON)
2-requestion URL query PARAM
3-requestion URL path PARAM


 */



//request(isteklerin)karşılanmasını sağlar
@RestController//json formati oop'ye uygun bir format xml formati ile de alabiliriz txt formati ilede alabiliriz
//@ResponseBody : Methodun dönuş değerini json formatında cevap olarak hazırlanır:
//@RequestBody : requestin içindeki (body) JSON formatında olan değeri(datayi) methodlarin parametlerinde kullanılmasını sağlar
//obje<->JSON dönüşümü Jackson kütüphanesi
@RequestMapping("/students")//http://localhost:8080/students....
//@RequiredArgsConstructor//sadece final olan fieldları set eder
//public StudentController(StudentService service) {
//        this.service = service;
//        }
public class StudentController {


    private final StudentService service;
    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }


    //SpringBOOT'u selamlama :)
    //http://localhost:8080/students/greet + get
    @GetMapping("/greet")
    public String greet(){
        return "Hello spring Boot";
    }

    //1-Tüm öğrencileri listeleyelim : READ
    //Request : http://localhost:8080/students + GET
    //response: tüm öğrencilerin listesini + 200 : OK(httpStatus Code)
    @GetMapping
    public ResponseEntity<List<Student>>getAllStudents(){
        //tablodan tüm öğrencilerimi getireyim
        List<Student>allStudent=service.findAllStudents();//TODO
        return new ResponseEntity<>(allStudent, HttpStatus.OK);//200
    }

    //ResponseEntity : response body + status code

    //3-öğrenci ekleme : CREATE
    //request : http://localhost:8080/students + POST + body(JSON)
    /*
    {
    "name":"ali",
    "lastname":"can",
    "grade":90,
    "email":"alican@gmail.com"
    }
     */
    //response : öğrenciyi tabloya eklenir,başarılı bir geri bildirim + 201(CREATED).
    @PostMapping
    public ResponseEntity<String>createStudent(@Valid @RequestBody Student student){//JSON

        service.saveStudent(student);

        return new ResponseEntity<>("Student is created succesfully....", HttpStatus.CREATED);
    }

    //6-query param ile id'si verilen öğrenciyi getirme
    //request : http://localhost:8080/students/query?id=1 + get
    //response student + 200
    @GetMapping("/query")
    public ResponseEntity<Student>getStudent(@RequestParam("id") Long id){
        Student student=service.getStudentById(id);

        return new ResponseEntity<>(student,HttpStatus.OK);

    }

    //ÖDEV : (ALTERNATİF)path param ile id'si verilen öğrenciyi getirme
    //request : http://localhost:8080/students/1 + get
    //response student + 200

}
