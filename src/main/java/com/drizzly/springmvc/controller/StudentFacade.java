/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.controller;

import com.drizzly.springmvc.model.DrMaStudent;
import com.drizzly.springmvc.model.DrTrFeesDue;
import com.drizzly.springmvc.model.IFees;
import com.drizzly.springmvc.model.IStudent;
import com.drizzly.springmvc.model.IStudentCategory;
import com.drizzly.springmvc.model.IStudentFees;
import com.drizzly.springmvc.service.StudentManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rajaguru
 */
@Service("studentService")
@Transactional
public class StudentFacade {

    @Autowired
    StudentManager manager;
    
    protected List<IStudent> getAllStudents() {
        List<IStudent> iStudent = manager.getAllStudents();
        return iStudent;
    }

    protected List<IStudentCategory> getAllCategory(){
        return manager.getAllCategory();
    }
    protected IStudent findByStudent(final Long studentId) {
        IStudent iStudent = manager.getStudentDetail(studentId);
        return iStudent;
    }
    
    protected List<IStudent> findStudentFees(final Long rollNumber, final String name, final String mobile, final String email, final String category) {
        return manager.getStudentDetail(rollNumber, name, mobile, email, category);
    }
    
    protected List<IStudent> findstudentsByCategory(final String category) {
        return manager.findStudentsByCategory(category);
    }
    
    protected List<IStudent> findstudentsFeesByCategory(final String category){
        return manager.findstudentsFeesByCategory(category);
    }
    
    protected IStudent findstudentsFeesByCategory(final IStudent student, final String category){
        return manager.findstudentsFeesByCategory(student,category);
    }
    
    protected List<IStudent> findstudentsByCategoryFeesMode(final String category,final String feesMode) {
        return manager.findstudentsByCategoryFeesMode(category,feesMode);
    }
    
    protected void saveStudent(final DrMaStudent student) {
        manager.saveStudent(student);
    }
    protected void saveStudentFees(final DrTrFeesDue drTrFeesDue) {
        manager.saveStudentFees(drTrFeesDue);
    }
    
    protected void deleteStudent(final Long studentId) {
        manager.deleteStudent(studentId);
    }
    protected boolean updateStudent(final DrMaStudent student) {
        if(isStudentExist(student)){
            manager.saveStudent(student);
        return true;
        }
        return false;        
    }
    protected boolean isStudentExist(final DrMaStudent student) {
        return null != manager.getStudentDetail(student.getStId());
    }

//    protected List<IFees> getAllFees() {
//        return manager.getAllFees();
//    }
    
}
