/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.controller;

import com.drizzly.springmvc.configuration.DrizzlyInitializer;
import com.drizzly.springmvc.model.DrMaStudent;
import com.drizzly.springmvc.model.IStudent;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author rajaguru
 */
public class StudentRestControllerIT {
    DrizzlyInitializer  initializer;
    public StudentRestControllerIT() {
         initializer = new DrizzlyInitializer();
    }
    
    @BeforeClass
    public static void setUpClass() {
       // initializer.
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
     * Test of listAllStudent method, of class StudentRestController.
     */
   // @Test
    public void testListAllStudent() {
        System.out.println("listAllStudent");
        StudentRestController instance = new StudentRestController();
        ResponseEntity<List<IStudent>> expResult = null;
        ResponseEntity<List<IStudent>> result = instance.listAllStudent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addStudent method, of class StudentRestController.
     */
   // @Test
    public void testAddStudent() {
        System.out.println("addStudent");
        DrMaStudent student = null;
        UriComponentsBuilder ucBuilder = null;
        StudentRestController instance = new StudentRestController();
        ResponseEntity<Void> expResult = null;
        ResponseEntity<Void> result = instance.addStudent(student, ucBuilder);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteStudent method, of class StudentRestController.
     */
  //  @Test
    public void testDeleteStudent() {
        System.out.println("deleteStudent");
        long id = 0L;
        StudentRestController instance = new StudentRestController();
        ResponseEntity<IStudent> expResult = null;
        ResponseEntity<IStudent> result = instance.deleteStudent(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUser method, of class StudentRestController.
     */
    //@Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        long id = 0L;
        DrMaStudent student = null;
        StudentRestController instance = new StudentRestController();
        ResponseEntity<Boolean> expResult = null;
        ResponseEntity<Boolean> result = instance.updateUser(id, student);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of FindUser method, of class StudentRestController.
     */
    @Test
    public void testFindUser() {
        System.out.println("FindUser");
        long id = 7L;
        String name = null;
        String mobile = null;
        String email = null;
        String category = null;
        StudentRestController instance = new StudentRestController();
        ResponseEntity<List<IStudent>> expResult = null;
        ResponseEntity<List<IStudent>> result = instance.FindUser(id, name, mobile, email, category);
        System.out.println("result  ::  "+result);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
