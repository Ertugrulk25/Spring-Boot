package com.tpe.repository;

import com.tpe.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//opsiyonel

public interface StudentRepository extends JpaRepository<Student,Long> {
    //e hocam implement gerçeleştirmedik?
    //çunku JpaRepository deki methodlar otomatik olarak spring tarafından implement ediliyor!!!!


    //5-
    boolean existsByEmail(String email);

//15*a
    List<Student> findAllByGrade(Integer grade);

    //15-b
    //JPQL : javaca hql

    @Query("FROM Student where grade =: pGrade")
    List<Student> filterStudentByGrade(@Param(("pGrade")) Integer grade);
//@Param methodun parametresindeki değeri pGrade icersine alır
//ve bu değişkeni sorgu içerisinde kullanmamızı sağlar

//15-c
    //SQL
@Query(value = "select * from student where grade=:pGrade",nativeQuery = true)
List<Student> filterStudentByGradeSQL(@Param("pGrade")Integer grade);

}




