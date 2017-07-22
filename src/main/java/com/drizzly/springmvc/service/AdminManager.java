/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.service;

import com.drizzly.springmvc.model.IFees;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author rajaguru
 */
@Configuration
public class AdminManager {
    
    @Autowired
    private IFeesDAO feesDAO;
    
    public List<IFees> getAllFeesOnYear(final Long year){
        return feesDAO.findFeesByYear(year);
    }
    
    public void insertNewFees(final IFees fees){
        feesDAO.saveFee(fees);
    }
}
