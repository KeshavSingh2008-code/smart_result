package com.substring.smartresult.Service;

import com.substring.smartresult.Payload.StudentForm;
import com.substring.smartresult.entities.Marks;
import com.substring.smartresult.entities.Student;
import com.substring.smartresult.repository.StudentRepo;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.error.Mark;

import java.util.List;
import java.util.UUID;



@Service
public class ResultService {

    @Autowired
    private StudentRepo studentRepo;

    public String save(StudentForm studentForm){

        Student student =new Student();


        student.setId(UUID.randomUUID().toString());
        student.setName(studentForm.getName());
        student.setRollNumber(studentForm.getRollnumber());
        student.setEmail(studentForm.getEmail());
        student.setSchoolname(studentForm.getSchoolname());
        student.setDob(studentForm.getDob());
        student.setGender(studentForm.getGender());


       List<Marks> marksList= studentForm.getMarks().stream().map(markForm -> {
            Marks marks= new Marks();
            marks.setSubject(markForm.getSubject());
            marks.setMarks(markForm.getMarks());
            marks.setMaxMarks(markForm.getMaxMarks());
            marks.setRemark(markForm.getRemarks());
            marks.setGrade(markForm.getGrade());
            marks.setStudent(student);
            return marks;
        }).toList();

       student.setMarkList(marksList);

       Student savedStudent= studentRepo.save(student);

        System.out.println("student saved with id" +savedStudent.getId());

        return savedStudent.getId();
    }


    public Student getResultByRollNumber(String rollNumber){
        return studentRepo.findByRollNumber(rollNumber);
    }
}

