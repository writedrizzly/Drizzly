/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.service;

import com.drizzly.springmvc.model.DrTrAccounts;
import com.drizzly.springmvc.model.IAccounts;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author rajaguru
 */
@Configuration
public class AccountManager {
    
    @Autowired
    private AccountDAO accountDAO;
    
    public void saveAccount(DrTrAccounts accounts) {
        accountDAO.saveoOrUpdateAccount(accounts);
    }
            
    public Map<String,List<IAccounts>> fetchAccounts(DrTrAccounts accounts) {
        return accountDAO.findByDateRange(accounts);
    }
    
    public List<IAccounts> fetchAccounts(Date fromDate, Date toDate) {
        return accountDAO.findByDateRange(fromDate, toDate);
    }
}
