package com.akgarg.springbootmongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@SuppressWarnings("unused")
@Document(collection = "student")
public class Student {

    @Id
    private int rollNumber;
    private String name;
    private String sClass;
    private String section;

    public Student() {
    }

    public Student(int rollNumber, String name, String sClass, String section) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.sClass = sClass;
        this.section = section;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber=" + rollNumber +
                ", name='" + name + '\'' +
                ", sClass='" + sClass + '\'' +
                ", section='" + section + '\'' +
                '}';
    }
}