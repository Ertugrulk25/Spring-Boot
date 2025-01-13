package com.tpe.service;

import com.tpe.domain.Student;
import com.tpe.exception.ConflictException;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
