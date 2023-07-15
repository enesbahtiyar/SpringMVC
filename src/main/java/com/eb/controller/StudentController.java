package com.eb.controller;

import com.eb.domain.Student;
import com.eb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/students") //http://localhost:8080/SpringMVC/students
public class StudentController
{
    @Autowired
    private StudentService studentService;

    @GetMapping("/hi") //http://localhost:8080/SpringMVC/students/hi
    public ModelAndView sayHi()
    {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "Hello");
        mav.addObject("messagebody", "I'm a student management system!");
        mav.setViewName("hi");  //hi.jsp


        return mav;
    }

    //send the form
    @GetMapping("/new") //http://localhost:8080/SpringMVC/students/new
    public String sendStudentForm(@ModelAttribute("student")Student student)
    {
        return "studentForm";
    }

    //save the student
    @PostMapping("/saveStudent") //http://localhost:8080/SpringMVC/students/saveStudent
    public String createStudent(@ModelAttribute Student student)
    {
        studentService.saveStudent(student);
        return "redirect:/students"; //http://localhost:8080/SpringMVC/students
    }

    //@GetMapping("students") //http://localhost:8080/SpringMVC/students/students

    //get all the students
    @GetMapping //http://localhost:8080/SpringMVC/students
    public ModelAndView listAllStudents()
    {
        List<Student> students = studentService.findAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("students", students);
        mav.setViewName("students");
        return mav;
    }

    @GetMapping("/update")
    public String showUpdateForm(@RequestParam("id")Long id, Model model) //http://localhost:8080/SpringMVC/students/update?id=1
    {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "studentForm";
    }

    @GetMapping("/delete/{id}") //http://localhost:8080/SpringMVC/students/delete/1
    public String deleteStudents(@PathVariable("id")Long id)
    {
        studentService.delete(id);
        return "redirect:/students";
    }
}
