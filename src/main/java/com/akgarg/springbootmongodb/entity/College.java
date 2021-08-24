package com.akgarg.springbootmongodb.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@SuppressWarnings("unused")
@Document(collection = "college")
public class College {

    private String name;
    private String city;
    private String state;
    private String field;
    private int students;

    public College() {
    }

    public College(String name, String city, String state, String field, int students) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.field = field;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "College{name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", field='" + field + '\'' +
                ", students=" + students +
                '}';
    }
}
