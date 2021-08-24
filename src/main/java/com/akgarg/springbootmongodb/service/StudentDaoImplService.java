package com.akgarg.springbootmongodb.service;

import com.akgarg.springbootmongodb.dao.StudentDaoImpl;
import com.akgarg.springbootmongodb.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("unused")
@Service
public class StudentDaoImplService {

    private final StudentDaoImpl studentDaoImpl;

    @Autowired
    public StudentDaoImplService(StudentDaoImpl studentDaoImpl) {
        this.studentDaoImpl = studentDaoImpl;
    }


    public void updateStudent(Student oldStudent, Student updatedStudent) throws Exception {
        this.studentDaoImpl.updateStudent(oldStudent, updatedStudent);
    }


    public String addStudent(Student student) {
        try {
            this.studentDaoImpl.addStudent(student);
            return "Student " + student + " added to the database successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage() + " Consider updating details if necessary";
        }
    }


    public String getStudent(int rollNumber) {
        try {
            Student student = this.studentDaoImpl.getStudent(rollNumber);
            return student != null ? student.toString() : "Student not found with id: " + rollNumber;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }


    public String removeStudent(int rollNumber) {
        try {
            this.studentDaoImpl.removeStudent(rollNumber);
            return "Student with roll number " + rollNumber + " removed from the database";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }


    public void removeStudent(Student student) throws Exception {
        this.studentDaoImpl.removeStudent(student);
    }


    public List<Student> getAllStudents() {
        return this.studentDaoImpl.getAllStudents();
    }


    public String getTotalStudentsCount() {
        return "Total students: " + this.studentDaoImpl.getTotalStudentsCount();
    }
}