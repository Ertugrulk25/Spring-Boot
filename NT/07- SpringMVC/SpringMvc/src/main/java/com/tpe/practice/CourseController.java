package com.tpe.practice;

import com.tpe.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/courses")
    @GetMapping
    public String listCourses(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courseList", courses);
        return "course-list"; // course-list.jsp
    }

    @RequestMapping("/add")
    @GetMapping
    public String showAddForm(Model model) {
        model.addAttribute("course", new Course());
        return "course-form"; // course-form.jsp
    }

    @RequestMapping("/save")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.saveCourse(course);
        return "redirect:/courses";
    }

    @RequestMapping("/courses/edit")
    @GetMapping
    public String showEditForm(@RequestParam Long id, Model model) {
        Course course = courseService.getCourseById(id);
        model.addAttribute("course", course);
        return "course-form";
    }
    @RequestMapping("/courses/delete")
    @GetMapping
    public String deleteCourse(@RequestParam Long id) {
        courseService.deleteCourse(id);
        return "redirect:/courses";
    }
}
