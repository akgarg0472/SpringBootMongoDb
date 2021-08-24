package com.akgarg.springbootmongodb.dao;

import com.akgarg.springbootmongodb.entity.College;

import java.util.List;

public interface CollegeMongoDao {
    List<College> getAllColleges();

    College getCollegeById(int collegeId);

    College getCollegeByCollegeName(String collegeName);
}
