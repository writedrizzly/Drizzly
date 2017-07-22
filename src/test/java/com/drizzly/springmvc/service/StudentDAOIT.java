/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.service;

import com.drizzly.springmvc.model.DrMaCategory;
import com.drizzly.springmvc.model.DrMaStudent;
import com.drizzly.springmvc.model.DrTrFeesDue;
import com.drizzly.springmvc.model.IFees;
import com.drizzly.springmvc.model.IStudent;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author rajaguru
 */
public class StudentDAOIT {
    
    StudentDAO dAO;
    public StudentDAOIT() {
        dAO= new StudentDAO();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of saveoOrUpdateStudent method, of class StudentDAO.
     */
    //@Test
    public void testSaveoOrUpdateStudent() {
        System.out.println("saveoOrUpdateStudent");
        DrMaStudent student = new DrMaStudent();
        student.setStAddress("TEST");
        student.setStEmail1("test@test.com");
        student.setStFatherName("TEST");
        student.setStFeesMode("1");
        student.setStJoinedDate(new Date());
        student.setStMobile1("3423432432232");
        student.setStMotherName("test");
        student.setStName("tetesttets");
        student.setStPincode("334333");
        DrTrFeesDue feesDue = new DrTrFeesDue();
        feesDue.setFpMode("1");
        feesDue.setFpPaidAmount(BigInteger.valueOf(2222));
        feesDue.setFpPaidDate(new Date());
        //feesDue.setDrMaStudent(student);
        Set fees = new HashSet();
        fees.add(feesDue);
        DrMaCategory category = new DrMaCategory();
        category.setCtId(Long.valueOf("1"));
        student.setDrTrFeesDues(fees);
        student.setDrMaCategory(category);
        dAO.saveoOrUpdateStudent(student);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    //@Test
    public void testgetStudentInfo(){
        System.out.println("findByStName");
        Long stId = 7L;
        String stName = null;
        //StudentDAO instance = new StudentDAO();
        List<IStudent> result = dAO.getStudentInfo(stId, stName, null, null, null);
        System.out.println("List size: " + result.size());
        if(result.size() > 0){
            System.out.println(" fees due  "+result.get(0).getDrTrFeesDues().size());
            System.out.println("Fees paid  "+result.get(0).getDrTrFeesDues());
        }
        System.out.println("result  "+result);
    }
    
   // @Test
    public void testfindAllStudents(){
        List<IStudent> students = dAO.findAllStudents();
        System.out.println("Students  :: "+students);
    }
    
    @Test
    public void testfindStudentsByCategory(){
        List<IStudent> students = dAO.findStudentsByCategory("1");
        System.out.println("Students  :: "+students);
    }
    
    @Test
    public void testgetAllFees(){
        List<IFees> feeses = dAO.getAllFees(2015);
        System.out.println("feeses  :: "+feeses);
    }
    
    /**
     * Test of findByStName method, of class StudentDAO.
     */
//    @Test
//    public void testFindByStName() {
//        System.out.println("findByStName");
//        String stName = "";
//        StudentDAO instance = new StudentDAO();
//        IStudent expResult = null;
//        IStudent result = instance.findByStName(stName);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getStudentInfo method, of class StudentDAO.
//     */
//    @Test
//    public void testGetStudentInfo() {
//        System.out.println("getStudentInfo");
//        Long studentId = null;
//        StudentDAO instance = new StudentDAO();
//        IStudent expResult = null;
//        IStudent result = instance.getStudentInfo(studentId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findAllStudents method, of class StudentDAO.
//     */
//    @Test
//    public void testFindAllStudents() {
//        System.out.println("findAllStudents");
//        StudentDAO instance = new StudentDAO();
//        List<IStudent> expResult = null;
//        List<IStudent> result = instance.findAllStudents();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteStudent method, of class StudentDAO.
//     */
//    @Test
//    public void testDeleteStudent() {
//        System.out.println("deleteStudent");
//        Long studentId = null;
//        StudentDAO instance = new StudentDAO();
//        instance.deleteStudent(studentId);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateStudent method, of class StudentDAO.
//     */
//    @Test
//    public void testUpdateStudent() {
//        System.out.println("updateStudent");
//        DrMaStudent student = null;
//        StudentDAO instance = new StudentDAO();
//        instance.updateStudent(student);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
