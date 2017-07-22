/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.model;

import java.math.BigInteger;
import java.util.Date;
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
public class DrTrLoanIT {
    
    public DrTrLoanIT() {
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
     * Test of getLnId method, of class DrTrLoan.
     */
    @Test
    public void testGetLnId() {
        System.out.println("getLnId");
        DrTrLoan instance = new DrTrLoan();
        Long expResult = null;
        Long result = instance.getLnId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLnId method, of class DrTrLoan.
     */
    @Test
    public void testSetLnId() {
        System.out.println("setLnId");
        Long lnId = null;
        DrTrLoan instance = new DrTrLoan();
        instance.setLnId(lnId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDrMaEmployee method, of class DrTrLoan.
     */
    @Test
    public void testGetDrMaEmployee() {
        System.out.println("getDrMaEmployee");
        DrTrLoan instance = new DrTrLoan();
        DrMaEmployee expResult = null;
        DrMaEmployee result = instance.getDrMaEmployee();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDrMaEmployee method, of class DrTrLoan.
     */
    @Test
    public void testSetDrMaEmployee() {
        System.out.println("setDrMaEmployee");
        DrMaEmployee drMaEmployee = null;
        DrTrLoan instance = new DrTrLoan();
        instance.setDrMaEmployee(drMaEmployee);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLnAmount method, of class DrTrLoan.
     */
    @Test
    public void testGetLnAmount() {
        System.out.println("getLnAmount");
        DrTrLoan instance = new DrTrLoan();
        BigInteger expResult = null;
        BigInteger result = instance.getLnAmount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLnAmount method, of class DrTrLoan.
     */
    @Test
    public void testSetLnAmount() {
        System.out.println("setLnAmount");
        BigInteger lnAmount = null;
        DrTrLoan instance = new DrTrLoan();
        instance.setLnAmount(lnAmount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLnReceivedDate method, of class DrTrLoan.
     */
    @Test
    public void testGetLnReceivedDate() {
        System.out.println("getLnReceivedDate");
        DrTrLoan instance = new DrTrLoan();
        Date expResult = null;
        Date result = instance.getLnReceivedDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLnReceivedDate method, of class DrTrLoan.
     */
    @Test
    public void testSetLnReceivedDate() {
        System.out.println("setLnReceivedDate");
        Date lnReceivedDate = null;
        DrTrLoan instance = new DrTrLoan();
        instance.setLnReceivedDate(lnReceivedDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLnClosedDate method, of class DrTrLoan.
     */
    @Test
    public void testGetLnClosedDate() {
        System.out.println("getLnClosedDate");
        DrTrLoan instance = new DrTrLoan();
        Date expResult = null;
        Date result = instance.getLnClosedDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLnClosedDate method, of class DrTrLoan.
     */
    @Test
    public void testSetLnClosedDate() {
        System.out.println("setLnClosedDate");
        Date lnClosedDate = null;
        DrTrLoan instance = new DrTrLoan();
        instance.setLnClosedDate(lnClosedDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
