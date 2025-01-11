package com.tpe.practice;

import com.tpe.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

  @Autowired
  private CourseRepository repository;

    public List<Course> getAllCourses() {
        return repository.getAllCourses();
    }

    public Course getCourseById(Long id) {

        return repository.getCourseById(id);
    }

    public void saveCourse(Course course) {
        repository.saveCourse(course);
    }

    public void deleteCourse(Long id) {
         repository.deleteCourse(id);
    }

}
