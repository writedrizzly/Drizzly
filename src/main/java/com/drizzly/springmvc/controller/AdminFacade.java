/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.controller;

import com.drizzly.springmvc.model.IFees;
import com.drizzly.springmvc.service.AdminManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rajaguru
 */
@Service("adminService")
@Transactional
public class AdminFacade {
    @Autowired
    AdminManager manager;
    
    public List<IFees> getAllFeesOnYear(final Long year){
        return manager.getAllFeesOnYear(year);
    }
}
