package com.drizzly.springmvc.controller;

import com.drizzly.springmvc.model.DrMaStudent;
import com.drizzly.springmvc.model.DrTrFeesDue;
import com.drizzly.springmvc.model.IFees;
import com.drizzly.springmvc.model.IStudent;
import com.drizzly.springmvc.model.IStudentCategory;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class StudentRestController {

    @Autowired
    StudentFacade studentFacade;

    //-------------------Retrieve All Students--------------------------------------------------------
    @RequestMapping(value = "/students/", method = RequestMethod.GET)
    public ResponseEntity<List<IStudent>> listAllStudent() {
        List<IStudent> students = studentFacade.getAllStudents();
        System.out.println("listAllStudents  " + students);
        if (students.isEmpty()) {
            return new ResponseEntity<List<IStudent>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        ResponseEntity responseEntity = new ResponseEntity<List<IStudent>>(students, HttpStatus.OK);
        System.out.println("responseEntity  " + responseEntity.toString());
        return responseEntity;
    }

    //-------------------Create a student--------------------------------------------------------
    @RequestMapping(value = "/students/", method = RequestMethod.POST)
    public ResponseEntity<Void> addStudent(@RequestBody DrMaStudent student, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating student " + student.getStId());

        studentFacade.saveStudent(student);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/students/{id}").buildAndExpand(student.getStId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    //-------------------Add fees--------------------------------------------------------
    @RequestMapping(value = "/payStudentfees/", method = RequestMethod.POST)
    public ResponseEntity<Void> addStudentFees(@RequestBody DrTrFeesDue drTrFeesDue, UriComponentsBuilder ucBuilder) {
        System.out.println("Fees paid details " + drTrFeesDue);

        studentFacade.saveStudentFees(drTrFeesDue);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/students/{id}").buildAndExpand(drTrFeesDue.getFpId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    //------------------- Delete a Student --------------------------------------------------------

    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<IStudent> deleteStudent(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Student with id " + id);
        studentFacade.deleteStudent(id);
        return new ResponseEntity<IStudent>(HttpStatus.NO_CONTENT);
    }

    //------------------- Update a Student --------------------------------------------------------
    @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Boolean> updateUser(@PathVariable("id") long id, @RequestBody DrMaStudent student) {
        System.out.println("Updating User " + id);

        boolean isStudExist = studentFacade.updateStudent(student);

        if (!isStudExist) {
            System.out.println("Please check the student adm.no");
            return new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Boolean>(isStudExist, HttpStatus.OK);
    }
    //------------------- Find Students by categorry --------------------------------------------------------
    
    @RequestMapping(value = "/studentsByCategory/{category}", method = RequestMethod.GET)
    public ResponseEntity<List<IStudent>> findstudentsByCategory(@PathVariable("category") String category) {
        System.out.println("FindUser category " + category);
        List<IStudent> students = studentFacade.findstudentsByCategory(category);
        System.out.println("FindUser  " + students.size());
        if(students.size() > 0){
            System.out.println(" fees due  "+students.get(0).getDrTrFeesDues().size());
            System.out.println("Fees paid  "+students.get(0).getDrTrFeesDues());
        }
        if (students.isEmpty()) {
            return new ResponseEntity<List<IStudent>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        ResponseEntity responseEntity = new ResponseEntity<List<IStudent>>(students, HttpStatus.OK);
        //System.out.println("FindUser responseEntity  " + responseEntity.toString());
        return responseEntity;
    }
    
    //------------------- Find students By Category and Feesmode---------------------------------
    @RequestMapping(value = "/studentsByCategory/{category}/{feesMode}", method = RequestMethod.GET)
    public ResponseEntity<List<IStudent>> findstudentsByCategoryFeesMode(@PathVariable("category") String category,
            @PathVariable("feesMode") String feesMode) {
        System.out.println("FindUser category " + category);
        List<IStudent> students = studentFacade.findstudentsByCategoryFeesMode(category,feesMode);
        System.out.println("FindUser  " + students.size());
        if(students.size() > 0){
            System.out.println(" fees due  "+students.get(0).getDrTrFeesDues().size());
            System.out.println("Fees paid  "+students.get(0).getDrTrFeesDues());
        }
        if (students.isEmpty()) {
            return new ResponseEntity<List<IStudent>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        ResponseEntity responseEntity = new ResponseEntity<List<IStudent>>(students, HttpStatus.OK);
        //System.out.println("FindUser responseEntity  " + responseEntity.toString());
        return responseEntity;
    }
    //------------------- Find a Student --------------------------------------------------------
    @RequestMapping(value = "/students/{id}/{name}/{mobile}/{email}/{category}", method = RequestMethod.GET)
    public ResponseEntity<List<IStudent>> FindUser(@PathVariable("id") long id,@PathVariable("name") String name,@PathVariable("mobile") String mobile,@PathVariable("email") String email,@PathVariable("category") String category) {
        System.out.println("FindUser name " + name);
        
        System.out.println("FindUser id " + id);
        System.out.println("FindUser category " + category);
        List<IStudent> students = studentFacade.findStudentFees(id, name, mobile, email, category);
        System.out.println("FindUser  " + students.size());
        if(students.size() > 0){
            System.out.println(" fees due  "+students.get(0).getDrTrFeesDues().size());
            System.out.println("Fees paid  "+students.get(0).getDrTrFeesDues());
        }
        if (students.isEmpty()) {
            return new ResponseEntity<List<IStudent>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        ResponseEntity responseEntity = new ResponseEntity<List<IStudent>>(students, HttpStatus.OK);
        //System.out.println("FindUser responseEntity  " + responseEntity.toString());
        return responseEntity;
    }
    
    //------------------- Find a Student --------------------------------------------------------
    @RequestMapping(value = "/students/{id}/{category}", method = RequestMethod.GET)
    public ResponseEntity<IStudent> findstudentsFeesByCategory(@PathVariable("id") long id,@PathVariable("category") String category) {
        System.out.println("Find Student id " + id);
        System.out.println("Fine student category " + category);
        IStudent student = studentFacade.findstudentsFeesByCategory(studentFacade.findByStudent(id), category);
        System.out.println("findstudentsFeesByCategory  " + student);
        
        if (student == null) {
            return new ResponseEntity<IStudent>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        ResponseEntity responseEntity = new ResponseEntity<IStudent>(student, HttpStatus.OK);
        //System.out.println("FindUser responseEntity  " + responseEntity.toString());
        return responseEntity;
    }
    
    //-------------------Retrieve All Category--------------------------------------------------------
    @RequestMapping(value = "/getAllCategory/", method = RequestMethod.GET)
    public ResponseEntity<List<IStudentCategory>> getAllCategory() {
        List<IStudentCategory> studentCategorys = studentFacade.getAllCategory();
        System.out.println("studentCategorys  " + studentCategorys);
        if (studentCategorys.isEmpty()) {
            return new ResponseEntity<List<IStudentCategory>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        ResponseEntity responseEntity = new ResponseEntity<List<IStudentCategory>>(studentCategorys, HttpStatus.OK);
        System.out.println("responseEntity  " + responseEntity.toString());
        return responseEntity;
    }
    
}
