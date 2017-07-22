/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.controller;

import com.drizzly.springmvc.model.DrTrAccounts;
import com.drizzly.springmvc.model.IAccounts;
import com.drizzly.springmvc.service.AccountManager;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rajaguru
 */
@Service("accountService")
@Transactional
public class AccountsFacade {
    
    @Autowired
    AccountManager manager;
    
    public void saveAccount(DrTrAccounts accounts) {
        manager.saveAccount(accounts);
    }
    
    public Map<String,List<IAccounts>> fetchAccounts(DrTrAccounts accounts) {
        return manager.fetchAccounts(accounts);
    }
    
    public List<IAccounts> fetchAccounts(Date fromDate, Date toDate) {
        return manager.fetchAccounts(fromDate, toDate);
    }
}
