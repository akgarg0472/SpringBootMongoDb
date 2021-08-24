package com.akgarg.springbootmongodb.repository;

import com.akgarg.springbootmongodb.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, Integer> {
}
