package com.akgarg.springbootmongodb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@SuppressWarnings("unused")
@Getter
@Setter
@ToString
@NoArgsConstructor
@Document(collection = "student_collection")
public class Student {

    @MongoId(FieldType.IMPLICIT)
    private int rollNumber;

    private String name;
    private String sClass;
    private String section;

    public Student(int rollNumber,
                   String name,
                   String sClass,
                   String section) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.sClass = sClass;
        this.section = section;
    }
}