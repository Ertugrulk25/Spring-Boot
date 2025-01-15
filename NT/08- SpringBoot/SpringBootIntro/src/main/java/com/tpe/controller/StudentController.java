package com.tpe.controller;

import com.tpe.domain.Student;
import com.tpe.dto.UpdateStudentDTO;
import com.tpe.service.StudentService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    //response: student + 200
    @GetMapping("/{id}")
    public ResponseEntity<Student> findStudent(@PathVariable("id") Long id){
        Student foundstudent=service.getStudentById(id);
        return new ResponseEntity<>(foundstudent,HttpStatus.OK);
    }

    //8-path param ile idsi verilen öğrenciyi silme
    //request : http://localhost:8080/students/1 + DELETE
    //response: tablodan kayıt silinir + bir mesaj verelim + 200(OK)
    @DeleteMapping("/{deletedId}")
    public ResponseEntity<String>deleteStudent(@PathVariable("deletedId")Long id){
        service.deleteStudentById(id);
        // return new ResponseEntity<>("Student is deleted succesfully.",HttpStatus.OK);//200
        return ResponseEntity.ok("Student is deleted succesfully.");
    }

    //10-idsi verilen öğrencinin name,lastname ve emailini değiştirme(güncelleme)
    //request : http://localhost:8080/students/1 + PUT(yerine koyma)/PATCH(kısmi)+body(JSON)
    //response: güncelleme + başaralı bir mesaj + 201
    @PatchMapping("/{id}")
    public ResponseEntity<String>updateStudent(@PathVariable("id")Long id, @Valid @RequestBody UpdateStudentDTO studentDTO){
        service.updateStudent(id,studentDTO);
        return new ResponseEntity<>("Student is updated successfully...",HttpStatus.CREATED);
    }

    //12-tüm öğrencileri listeleyelim : READ
    //pagination(sayfalandırma):hız/performans
    //tüm kayıtları page page(sayfa sayfa)gösterelim
    //request :http://localhost:8080/students/page?
    //                                        page=1&
    //                                        size=4&
    //                                        sort=grade&
    //                                        direction=desc(asc) + GET
    @GetMapping("/page")
    public ResponseEntity<Page<Student>>getAllStudent(@RequestParam("page") int pageNo,//kaçıncı sayfa
                                                      @RequestParam("size") int size,//kaç tane kayıt
                                                      @RequestParam("sort") String property,//hangi özelliğe göre sırlama
                                                      @RequestParam("direction") Sort.Direction direction){//sıralamanın neye göre yapılıcagını
        //findAll methodunun sayfa getirmesi icin gerekli olan bilgiler
        //pageable tipinde verilmelidir
        Pageable pageable= PageRequest.of(pageNo,size,Sort.by(direction,property));

        Page<Student>studentPage=service.getAllStudentByPage(pageable);

        return new ResponseEntity<>(studentPage,HttpStatus.OK);
    }

    //14-grade ile öğrencileri filtreleyelim - path param
//request : http://localhost:8080/students/grade/80 + GET
//response: grade=80 olan öğrencileri listeleyip + 200
    @GetMapping("/grade/{grade}")
    public ResponseEntity<List<Student>>getAllStudentByGrade(@PathVariable("grade")Integer grade){
        List<Student>studentList=service.getStudentsByGrade(grade);
        //return new ResponseEntity<>(studentList,HttpStatus.OK);
        return ResponseEntity.ok(studentList);

        //ÖDEVV
//JPA methodu türetme
//JPQL/SQL ile sorgu
//16-lastname ile öğrencileri filtreleme
//request : http://localhost:8080/students/lastname?lastname=Can + GET
//response: studentList(lastname'i Can a eşit olan) + 200,

//meraklısına ÖDEV-->  isim veya soyisim göre filtreleme
//http://localhost:8080/students/search?word=Ali + GET
//http://localhost:8080/students/search?word=Can + GET



    }











}