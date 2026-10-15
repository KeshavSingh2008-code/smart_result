package com.substring.smartresult.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Student {


    @Id
    private String id;

    private String name;

   @Column(unique =true)
    private String rollNumber;

    @Column(unique = true)
    private String email;

    private String schoolname;

    private LocalDate dob;

    private String gender;


    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Marks> markList =new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public List<Marks> getMarkList() {
        return markList;
    }

    public void setMarkList(List<Marks> markList) {
        this.markList = markList;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
