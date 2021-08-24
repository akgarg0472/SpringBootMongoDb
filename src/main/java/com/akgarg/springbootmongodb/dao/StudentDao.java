package com.akgarg.springbootmongodb.dao;

import com.akgarg.springbootmongodb.entity.Student;

import java.util.List;

@SuppressWarnings("unused")
public interface StudentDao {
    void updateStudent(Student oldStudent, Student updatedStudent) throws Exception;

    void addStudent(Student student) throws Exception;

    Student getStudent(int rollNumber) throws Exception;

    void removeStudent(int rollNumber) throws Exception;

    void removeStudent(Student student) throws Exception;

    List<Student> getAllStudents();

    int getTotalStudentsCount();
}