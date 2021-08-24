package com.akgarg.springbootmongodb.repository;

import com.akgarg.springbootmongodb.entity.College;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CollegeRepository extends MongoRepository<College, String> {
}
