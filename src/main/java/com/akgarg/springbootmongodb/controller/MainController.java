package com.akgarg.springbootmongodb.controller;

import com.akgarg.springbootmongodb.dummyData.StudentDummyData;
import com.akgarg.springbootmongodb.entity.Student;
import com.akgarg.springbootmongodb.repository.StudentRepository;
import com.akgarg.springbootmongodb.service.StudentDaoImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    private final StudentDaoImplService studentDaoImplService;
    private final StudentRepository studentRepository;


    @Autowired
    public MainController(StudentDaoImplService studentDaoImplService,
                          StudentRepository studentRepository) {
        this.studentDaoImplService = studentDaoImplService;
        this.studentRepository = studentRepository;
    }


    // method to accept and handle the home page request
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "Home page of MongoDB spring boot";
    }


    // method to accept and handle the request to add student in DB
    @RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
    public String addStudent(@PathVariable("id") int studentId) {
        // adding dummy data to the database
        // this data is supposed to come with incoming HTTP request
        Student student = StudentDummyData.getDummyStudent(studentId);
        return this.studentDaoImplService.addStudent(student);
    }


    // method to accept and handle the request to remove a particular student from DB
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") int studentId) {
        return this.studentDaoImplService.removeStudent(studentId);
    }


    // method to accept and handle the request to return all students available in DB
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Student> getAllStudents() {
        System.out.println(this.studentRepository.findAll());
        return this.studentDaoImplService.getAllStudents();
    }


    // method to accept and handle the request to fetch and return specific student
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public String getStudent(@PathVariable("id") int studentId) {
        System.out.println("Student having rollNumber " + studentId + ": " + this.studentRepository.findById(studentId));
        return this.studentDaoImplService.getStudent(studentId);
    }


    // method to accept and handle the request to return total students count
    @RequestMapping(value = "/total", method = RequestMethod.GET)
    public String totalStudents() {
        System.out.println("Total students: " + this.studentRepository.findAll().size());
        return this.studentDaoImplService.getTotalStudentsCount();
    }
}