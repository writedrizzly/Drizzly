/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.controller;

import com.drizzly.springmvc.model.DrMaStudent;
import com.drizzly.springmvc.model.IStudent;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rajaguru
 */
public class StudentFacadeIT {
    
    public StudentFacadeIT() {
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
     * Test of getAllStudents method, of class StudentFacade.
     */
    @Test
    public void testGetAllStudents() {
        System.out.println("getAllStudents");
        StudentFacade instance = new StudentFacade();
        List<IStudent> expResult = null;
        List<IStudent> result = instance.getAllStudents();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByStudent method, of class StudentFacade.
     */
    @Test
    public void testFindByStudent() {
        System.out.println("findByStudent");
        Long studentId = null;
        StudentFacade instance = new StudentFacade();
        IStudent expResult = null;
        IStudent result = instance.findByStudent(studentId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveStudent method, of class StudentFacade.
     */
    @Test
    public void testSaveStudent() {
        System.out.println("saveStudent");
        DrMaStudent student = null;
        StudentFacade instance = new StudentFacade();
        instance.saveStudent(student);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteStudent method, of class StudentFacade.
     */
    @Test
    public void testDeleteStudent() {
        System.out.println("deleteStudent");
        Long studentId = null;
        StudentFacade instance = new StudentFacade();
        instance.deleteStudent(studentId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateStudent method, of class StudentFacade.
     */
    @Test
    public void testUpdateStudent() {
        System.out.println("updateStudent");
        DrMaStudent student = null;
        StudentFacade instance = new StudentFacade();
        boolean expResult = false;
        boolean result = instance.updateStudent(student);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isStudentExist method, of class StudentFacade.
     */
    @Test
    public void testIsStudentExist() {
        System.out.println("isStudentExist");
        DrMaStudent student = null;
        StudentFacade instance = new StudentFacade();
        boolean expResult = false;
        boolean result = instance.isStudentExist(student);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
