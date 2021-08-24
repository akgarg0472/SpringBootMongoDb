package com.akgarg.springbootmongodb.dao;

import com.akgarg.springbootmongodb.entity.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CollegeMongoDaoImpl implements CollegeMongoDao {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public CollegeMongoDaoImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<College> getAllColleges() {
        return this.mongoTemplate.findAll(College.class);
    }

    @Override
    public College getCollegeById(int collegeId) {
        return null;
    }

    @Override
    public College getCollegeByCollegeName(String collegeName) {
        return null;
    }

    @Override
    public String toString() {
        return "CollegeMongoDaoImpl{" +
                "mongoTemplate=" + mongoTemplate +
                '}';
    }
}
