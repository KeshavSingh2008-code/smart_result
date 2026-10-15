package com.substring.smartresult.Payload;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentForm {

    private String name;
    private String rollnumber;
    private String email;
    private String schoolname;
    private LocalDate dob;
    private String gender;


    private List<MarksForm> marks =new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(String rollnumber) {
        this.rollnumber = rollnumber;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<MarksForm> getMarks() {
        return marks;
    }

    public void setMarks(List<MarksForm> marks) {
        this.marks = marks;
    }
}
