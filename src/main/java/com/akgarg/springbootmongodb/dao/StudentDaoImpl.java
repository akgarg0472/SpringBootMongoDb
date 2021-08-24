package com.akgarg.springbootmongodb.dao;

import com.akgarg.springbootmongodb.entity.Student;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public StudentDaoImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;

        // if collection of Student class doesn't exist
        // then create collection for the same in DB
        if (!this.mongoTemplate.collectionExists(Student.class)) {
            this.mongoTemplate.createCollection(Student.class);
        }
    }


    @Override
    public void updateStudent(Student oldStudent, Student updatedStudent) throws Exception {
        if (oldStudent.getRollNumber() != updatedStudent.getRollNumber()) {
            throw new Exception("Invalid data provided to update student.");
        }

        Query query = new Query();
        query.addCriteria(Criteria.where("rollNumber").is(oldStudent.getRollNumber()));
        query.addCriteria(Criteria.where("sClass").is(oldStudent.getSClass()));

        Update update = new Update();
        update.set("rollNumber", updatedStudent.getRollNumber());
        update.set("name", updatedStudent.getName());
        update.set("sClass", updatedStudent.getName());
        update.set("section", updatedStudent.getSection());

        UpdateResult updated = this.mongoTemplate.updateFirst(query, update, Student.class);
        System.out.println("Update student: " + updated);
    }


    @Override
    public void addStudent(Student student) throws Exception {
        if (this.getStudent(student) != null) {
            throw new Exception("Student already exists to the database.");
        }

        this.mongoTemplate.save(student);
    }


    @Override
    public List<Student> getAllStudents() {
        return this.mongoTemplate.findAll(Student.class);
    }


    public Student getStudent(int rollNumber) throws Exception {
        if (rollNumber < 0) {
            throw new Exception("Roll number of student is invalid (less than 0).");
        }

        Query query = Query.query(Criteria.where("rollNumber").is(rollNumber));
        return this.mongoTemplate.findOne(query, Student.class);
    }


    private Student getStudent(Student student) {
        if (student == null) {
            return null;
        }

        Query query = new Query();
        query.addCriteria(Criteria.where("rollNumber").is(student.getRollNumber()));
        query.addCriteria(Criteria.where("name").is(student.getName()));
        query.addCriteria(Criteria.where("sClass").is(student.getSClass()));
        query.addCriteria(Criteria.where("section").is(student.getSection()));

        return this.mongoTemplate.findOne(query, Student.class);
    }


    @Override
    public void removeStudent(int rollNumber) throws Exception {
        if (rollNumber < 0) {
            throw new Exception("Roll number of student is invalid (less than 0).");
        }

        if (this.getStudent(this.getStudent(rollNumber)) == null) {
            throw new Exception("Student with roll number " + rollNumber + " doesn't exists in the database.");
        }

        Query query = Query.query(Criteria.where("rollNumber").is(rollNumber));
        this.mongoTemplate.remove(query, Student.class);
    }


    @Override
    public void removeStudent(Student student) throws Exception {
        if (this.getStudent(student) == null) {
            throw new Exception("Student doesn't exists in the database.");
        }

        this.mongoTemplate.remove(student);
    }


    @Override
    public int getTotalStudentsCount() {
        return this.getAllStudents().size();
    }
}