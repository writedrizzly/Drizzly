/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.service;

import com.drizzly.springmvc.model.DrMaEmployee;
import com.drizzly.springmvc.model.DrTrFeesDue;
import com.drizzly.springmvc.model.IEmployee;
import java.util.Date;
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
public class EmployeeDAOIT {
    
    public EmployeeDAOIT() {
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
     * Test of saveoOrUpdateEmployee method, of class EmployeeDAO.
     */
    @Test
    public void testSaveoOrUpdateEmployee() {
        System.out.println("saveoOrUpdateEmployee");
        DrTrFeesDue feesDue = new DrTrFeesDue();
        DrMaEmployee employee = new DrMaEmployee();
        employee.setEmAddress("TEST");
        employee.setEmEmail1("test@test.com");
        employee.setEmJoinDate(new Date());
        employee.setEmMobile1("435343242342");
        employee.setEmName("TEST");
        EmployeeDAO instance = new EmployeeDAO();
        
        instance.saveoOrUpdateEmployee(employee);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllEmployees method, of class EmployeeDAO.
     */
    @Test
    public void testFindAllEmployees() {
        System.out.println("findAllEmployees");
        EmployeeDAO instance = new EmployeeDAO();
        List<IEmployee> expResult = null;
        List<IEmployee> result = instance.findAllEmployees();
        System.out.println("result "+result);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteEmployeeByEmId method, of class EmployeeDAO.
     */
    @Test
    public void testDeleteEmployeeByEmId() {
        System.out.println("deleteEmployeeByEmId");
        Long emId = null;
        EmployeeDAO instance = new EmployeeDAO();
        instance.deleteEmployeeByEmId(emId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByEmId method, of class EmployeeDAO.
     */
    @Test
    public void testFindByEmId() {
        System.out.println("findByEmId");
        Long emId = null;
        EmployeeDAO instance = new EmployeeDAO();
        IEmployee expResult = null;
        IEmployee result = instance.findByEmId(emId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByEmName method, of class EmployeeDAO.
     */
    @Test
    public void testFindByEmName() {
        System.out.println("findByEmName");
        String emName = "";
        EmployeeDAO instance = new EmployeeDAO();
        IEmployee expResult = null;
        IEmployee result = instance.findByEmName(emName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateEmployee method, of class EmployeeDAO.
     */
    @Test
    public void testUpdateEmployee() {
        System.out.println("updateEmployee");
        DrMaEmployee employee = null;
        EmployeeDAO instance = new EmployeeDAO();
        instance.updateEmployee(employee);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveOrUpdateEmployee method, of class EmployeeDAO.
     */
    @Test
    public void testSaveOrUpdateEmployee() {
        System.out.println("saveOrUpdateEmployee");
        DrMaEmployee employee = null;
        EmployeeDAO instance = new EmployeeDAO();
        instance.saveOrUpdateEmployee(employee);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveEmployee method, of class EmployeeDAO.
     */
    @Test
    public void testSaveEmployee() {
        System.out.println("saveEmployee");
        DrMaEmployee employee = null;
        EmployeeDAO instance = new EmployeeDAO();
        instance.saveEmployee(employee);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of persistEmployee method, of class EmployeeDAO.
     */
    @Test
    public void testPersistEmployee() {
        System.out.println("persistEmployee");
        DrMaEmployee employee = null;
        EmployeeDAO instance = new EmployeeDAO();
        instance.persistEmployee(employee);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
