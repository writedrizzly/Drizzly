/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.service;

import com.drizzly.springmvc.model.DrMaFees;
import com.drizzly.springmvc.model.IFees;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 *
 * @author rajaguru
 */
@Configuration
public class FeesDAO extends AbstractDao implements IFeesDAO {
    
    @Override
    public void saveoOrUpdateEmployee(IFees fees) {
        saveOrUpdate(fees);
    }
    
    @Override
    public List<IFees> findFeesByYear(Long year){
        System.out.print("inside by findFeesByYear ");
        getSession().beginTransaction();
        final Criteria criteria = getSession().createCriteria(DrMaFees.class);
        criteria.add(Restrictions.eq("year",year.intValue()));
        final List<IFees> iFees = criteria.list();
        getSession().close();
        return iFees;
    }
    
    @Override
    public void saveOrUpdateFee(IFees fee){
        saveOrUpdate(fee);
    }
    
    @Override
    public void saveFee(IFees fee){
        save(fee);
    }
    
    @Override
    public void persistFee(IFees fee){
        persist(fee);
    }
}
