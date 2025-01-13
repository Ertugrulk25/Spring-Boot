package com.tpe.repository;

import com.tpe.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//opsiyonel

public interface StudentRepository extends JpaRepository<Student,Long> {
    //e hocam implement gerçeleştirmedik?
    //çunku JpaRepository deki methodlar otomatik olarak spring tarafından implement ediliyor!!!!


    //5-
    boolean existsByEmail(String email);
}
