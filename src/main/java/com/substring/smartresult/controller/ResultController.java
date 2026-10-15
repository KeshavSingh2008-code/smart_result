package com.substring.smartresult.controller;


import com.substring.smartresult.Service.ResultService;
import com.substring.smartresult.entities.Marks;
import com.substring.smartresult.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.substring.smartresult.Payload.StudentForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.error.Mark;

@Controller
@RequestMapping("/results")
public class ResultController {



    @Autowired
    private ResultService resultService;


//roll number
    @RequestMapping("/input")
    public String viewResult() {
        System.out.println("result page");
        return "view_result";
    }


        @RequestMapping("/view")
        public String getResult() {
            //logic to fetch and return the results
            return "result_data";
        }



//add rsult ka form show kar raha ha
    @RequestMapping("/add")
    public String addResult(Model model) {
        //logic to fetch and return the results

        StudentForm studentForm=new StudentForm();
        model.addAttribute("studentForm",studentForm);
        return "add_result";
    }

    @RequestMapping( value= "/process-form", method = RequestMethod.POST)
    public String saveResults(
            @ModelAttribute StudentForm studentForm,
            Model model
    ){
       // System.out.println(studentForm.getName());
//        System.out.println(studentForm.getRollnumber());
//        System.out.println(studentForm.getEmail());
//
//        System.out.println(studentForm.getMarks().size());
//
//
//        //to show marks of the console
//
//        studentForm.getMarks().forEach(marks ->{
//            System.out.println("subject" +marks.getSubject());
//            System.out.println("marks" +marks.getMarks());
//            System.out.println("max marks " +marks.getMaxMarks());
//            System.out.println("Remarks" +marks.getRemarks());
//            System.out.println("Grade"  +marks.getGrade());
//            System.out.println("--------------------------");
//        });
      String studentid=  resultService.save(studentForm);

      model.addAttribute("studentid" ,studentid);
        return "result_success"; //placeholder or actual results date.
    }


    // @RequestMapping(value = "/view-result", method = RequestMethod.POST)
    @PostMapping("/view-result")

    public String viewResultByRollNumber(@RequestParam("rollNumber") String rollNumber, Model model){
        System.out.println("Roll Number" + rollNumber) ;

        Student student = resultService.getResultByRollNumber(rollNumber);
        //System.out.println(student.getName());
        //System.out.println(student.getMarkList().size());
        if(student==null){
            return "result_not_found";
        }else {


            double totalMarks=0;
            double totalMaxMarks=0;

            for(Marks mark:student.getMarkList()){
                totalMarks +=mark.getMarks();
                totalMaxMarks += mark.getMaxMarks();
            }

            double percentage =(totalMarks/totalMaxMarks) *100;
            model.addAttribute("percentage",String.format("%.2f",percentage)+"");
            model.addAttribute("totalMarks",((int)totalMarks));
            model.addAttribute("totalMaxMarks",Double.valueOf(totalMaxMarks));

            String totalGrade="f";

            if(percentage>90){
                totalGrade="A+";

            }else if(percentage>80 && percentage <=90){
                totalGrade ="A";
            }else if(percentage>70 && percentage<=80){
                totalGrade ="B+";
            }else if(percentage>60 && percentage<70){
                totalGrade ="B";

            }
            else{
                totalGrade="F";
            }

            model.addAttribute("totalGrade", totalGrade);


            model.addAttribute("student", student);
            model.addAttribute("marks", student.getMarkList());
            return "result_data";

        }

    }

        }
        //form ka under koi v data v name sa fetch karna ho to requestParam use kar sakta ho



