/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.model;

import java.math.BigInteger;
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
public class DrMaFeesIT {
    
    public DrMaFeesIT() {
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
     * Test of getFeId method, of class DrMaFees.
     */
    @org.junit.Test
    public void testGetFeId() {
        System.out.println("getFeId");
        DrMaFees instance = new DrMaFees();
        Long expResult = null;
        Long result = instance.getFeId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFeId method, of class DrMaFees.
     */
    @org.junit.Test
    public void testSetFeId() {
        System.out.println("setFeId");
        Long feId = null;
        DrMaFees instance = new DrMaFees();
        instance.setFeId(feId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDrMaCategory method, of class DrMaFees.
     */
    @org.junit.Test
    public void testGetDrMaCategory() {
        System.out.println("getDrMaCategory");
        DrMaFees instance = new DrMaFees();
        DrMaCategory expResult = null;
        DrMaCategory result = instance.getDrMaCategory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDrMaCategory method, of class DrMaFees.
     */
    @org.junit.Test
    public void testSetDrMaCategory() {
        System.out.println("setDrMaCategory");
        DrMaCategory drMaCategory = null;
        DrMaFees instance = new DrMaFees();
        instance.setDrMaCategory(drMaCategory);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFeAmount method, of class DrMaFees.
     */
    @org.junit.Test
    public void testGetFeAmount() {
        System.out.println("getFeAmount");
        DrMaFees instance = new DrMaFees();
        BigInteger expResult = null;
        BigInteger result = instance.getFeAmountMonth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFeAmount method, of class DrMaFees.
     */
    @org.junit.Test
    public void testSetFeAmount() {
        System.out.println("setFeAmount");
        BigInteger feAmount = null;
        DrMaFees instance = new DrMaFees();
        instance.setFeAmountMonth(feAmount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
