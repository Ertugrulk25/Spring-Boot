package com.tpe.service;
import com.tpe.domain.Student;
import com.tpe.dto.UpdateStudentDTO;
import com.tpe.exception.ConflictException;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@NoArgsConstructor
//@RequiredArgsConstructor//finallarin set edilmesini sağlar
public class StudentService {


    private final StudentRepository repository;
    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    //2.tablodan tüm kayıtları cekelim
    public List<Student> findAllStudents() {
        return repository.findAll();
    }



    //4. adım
    public void saveStudent(Student student) {
        //student unique olan değer var mı?->email id database tarafından yönetilir
        //ayni email değeri var mı diye kontrol edelim
        //select *from t_student where email=student.getEmail>0 -->t/f
        boolean existStudent=repository.existsByEmail(student.getEmail());
        if (existStudent){
            //bu mail daha öncesinden kullanılmış -> exception
            throw new ConflictException("Email Already Exception");
        }
        repository.save(student);//insert into
    }

    //7-
    public Student getStudentById(Long id) {

        Student student=repository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Student is not found by id : "+id));
        return student;

    }

    //9-
    public void deleteStudentById(Long id) {
        //bu id ile öğrenci var mı?
        Student student=getStudentById(id);
        repository.delete(student);
    }

    //11-id verilen öğrencinin bilgilerini dto'dan gelen bilgiler ile değiştirelim
    public void updateStudent(Long id, UpdateStudentDTO studentDTO) {
        Student foundStudent=getStudentById(id);//1,ali,can,alican@gmail.com,90,13.01
        //email değeri başka bir öğrencide var ise
        /*
        dto'dan gelen yeni email            Tablodaki emailler
        1-aaa@gmail.com                     Yok (existbyemail:false)-->update
        2-velican@gmail.com                 başka bir öğrenciye ait(existByEmail:true)-->conflictExceptipn
        3-alican@gmail.com                  kendisine ait (existByEmail:true)-->bu bir çakışma durumu değil
         */

        //istek ile gönderilen mail tabloda var mı
        boolean existEmail=repository.existsByEmail(studentDTO.getEmail());
        boolean selfEmail=foundStudent.getEmail().equals(studentDTO.getEmail());
        if (existEmail && !selfEmail){
            //2 numaralı olay
            throw new ConflictException("Email already exists!!!");
        }

        foundStudent.setName(studentDTO.getName());
        foundStudent.setLastname(studentDTO.getLastname());
        foundStudent.setEmail(studentDTO.getEmail());
        repository.save(foundStudent);//saveOrUpdate
    }

    //13- gerekli parametreleri(bilgileri) pageable ile verilen
    //tüm öğrencileri sayfalandırılma talep edilen sayfanın döndürülmesini sağlayalım
    public Page<Student> getAllStudentByPage(Pageable pageable) {
        //sql select * from t_student order by grade desc limit 4
        Page<Student>studentPage=repository.findAll(pageable);
        return studentPage;
    }
///15-
public List<Student> getStudentsByGrade(Integer grade) {
    //sql select * from t_student where grade=80
    //hql from Student where grade=80;
    //return repository.findAllByGrade(grade);
    //return repository.filterStudentByGrade(grade);
    return repository.filterStudentByGradeSQL(grade);

}






    }

