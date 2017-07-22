/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.service;

import com.drizzly.springmvc.model.DrMaFees;
import com.drizzly.springmvc.model.IFees;
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
public class FeesDAOIT {
    
    public FeesDAOIT() {
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
     * Test of saveoOrUpdateEmployee method, of class FeesDAO.
     */
    @Test
    public void testSaveoOrUpdateEmployee() {
        System.out.println("saveoOrUpdateEmployee");
        DrMaFees fees = null;
        FeesDAO instance = new FeesDAO();
        instance.saveoOrUpdateEmployee(fees);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findFeesByYear method, of class FeesDAO.
     */
    @Test
    public void testFindFeesByYear() {
        System.out.println("findFeesByYear");
        Long year = 2016L;
        FeesDAO instance = new FeesDAO();
        List<IFees> expResult = null;
        List<IFees> result = instance.findFeesByYear(year);
        //assertEquals(expResult, result);
        System.out.println("result  "+result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
