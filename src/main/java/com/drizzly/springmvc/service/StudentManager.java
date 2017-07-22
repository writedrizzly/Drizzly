/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.service;

import com.drizzly.springmvc.fees.MonthlyFees;
import com.drizzly.springmvc.fees.StudentFees;
import com.drizzly.springmvc.fees.TermFees;
import com.drizzly.springmvc.fees.YearlyFees;
import com.drizzly.springmvc.model.DrMaStudent;
import com.drizzly.springmvc.model.DrTrFeesDue;
import com.drizzly.springmvc.model.IStudent;
import com.drizzly.springmvc.model.IStudentCategory;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author rajaguru
 */
@Configuration
public class StudentManager {
    
   // @Autowired
    StudentDAO studentDao = new StudentDAO();
    
    @Autowired
    MonthlyFees monthlyFees;
    
    @Autowired
    YearlyFees yearlyFees;
    
//    @Autowired
//    TermFees termFees;
    
    public void saveStudent(DrMaStudent student){
          studentDao.saveoOrUpdateStudent(student);
    }
    public void saveStudentFees(DrTrFeesDue drTrFeesDue){
          studentDao.saveoOrUpdateFees(drTrFeesDue);
    }
    
    public IStudent getStudentDetail(Long studId){
        return studentDao.getStudentInfo(studId);
    }
    
    public List<IStudent> getStudentDetail(final Long rollNumber, final String name, final String mobile, final String email, final String category){
        return studentDao.getStudentInfo(rollNumber, name, mobile, email, category);
    }
    public List<IStudent> findStudentsByCategory(final String category) {
        return studentDao.findStudentsByCategory(category);
    }
    public List<IStudent> getAllStudents(){
        return studentDao.findAllStudents();
    }
    
    public void deleteStudent(Long studentId){
        studentDao.deleteStudent(studentId);
    }
       
    public IStudent findByStName(String stNme) {
        return studentDao.findByStName(stNme); 
    }
    
    public List<IStudentCategory> getAllCategory() {
        return studentDao.getAllCategory();
    }

//    public List<IFees> getAllFees() {
//        return studentDao.getAllFees();
//    }

    public List<IStudent> findstudentsByCategoryFeesMode(String category, String feesMode) {
        return studentDao.findStudentsByCategory(category);
    }
    
    public List<IStudent> findstudentsFeesByCategory(String category) {
        //monthlyFees.findStudentsFees();
       // yearlyFees.findStudentsFees();
        StudentFees studentFees;
        //final String[] playPreKgCat = new String[] {"1","2","5","6"};
        //List<String> list = Arrays.asList(playPreKgCat);
        if(!list.contains(category)){
            studentFees = new MonthlyFees();
        }else{
            studentFees = new TermFees();
        }
        return studentFees.findStudentsFees();
        //return studentDao.findStudentsByCategory(category);
    }
    
    public IStudent findstudentsFeesByCategory(IStudent student, String category){
        StudentFees studentFees;
        //final String[] playPreKgCat = new String[] {"1","2","5","6"};
        //List<String> list = Arrays.asList(playPreKgCat);
        if(!list.contains(category)){
            studentFees = new MonthlyFees(category,student);
        }else{
            studentFees = new TermFees(category,student);
        }
        return studentFees.findStudentsFeesDetail(student, category);
    }
    
    private static List<String> list;
    static{
        String[] playPreKgCat = new String[] {"1","2","5","6"};
        list = Arrays.asList(playPreKgCat);
    }
}
