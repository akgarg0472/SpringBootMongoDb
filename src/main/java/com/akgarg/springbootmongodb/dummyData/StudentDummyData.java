package com.akgarg.springbootmongodb.dummyData;

import com.akgarg.springbootmongodb.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentDummyData {

    public static Student getDummyStudent(int requested) {
        List<Student> students = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < random.nextInt(requested > 10 ? requested : requested * 10); i++) {
            if (i < 5) {
                students.add(new Student(i, "Student " + (i), "CSE", "A"));
            } else {
                students.add(new Student(i, "Student " + (i), "ECE", "A"));
            }
        }

        return students.get(requested % (random.nextInt(9) + 1));
    }
}