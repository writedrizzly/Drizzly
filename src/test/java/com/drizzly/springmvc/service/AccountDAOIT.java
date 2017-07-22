/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.service;

import com.drizzly.springmvc.model.DrMaCategory;
import com.drizzly.springmvc.model.DrMaStudent;
import com.drizzly.springmvc.model.DrTrAccounts;
import com.drizzly.springmvc.model.DrTrFeesDue;
import com.drizzly.springmvc.model.IAccounts;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
public class AccountDAOIT {
    
    AccountDAO accountDAO;
    public AccountDAOIT() {
        accountDAO = new AccountDAO();
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

    @Test
    public void testSaveoOrUpdateAccount() {
        System.out.println("testSaveoOrUpdateAccount");
        DrTrAccounts acoAccounts = new DrTrAccounts();
        acoAccounts.setAcCategory("1");
        acoAccounts.setAcCredit(BigDecimal.valueOf(5000));
        acoAccounts.setAcDebit(BigDecimal.valueOf(5000));
        acoAccounts.setAcDate(new Date());
        acoAccounts.setAcNote("testing");
        accountDAO.saveOrUpdate(acoAccounts);
    }
    
    @Test
    public void testFindAccounts() {
        System.out.println("testFindAccounts");
        List<IAccounts> list = accountDAO.findByDateRange(new Date(), new Date());
        System.out.println("list  "+list);
    }
}
