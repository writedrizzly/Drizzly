/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.service;

import com.drizzly.springmvc.LocalHibernateUtil;
import com.drizzly.springmvc.model.DrTrAccounts;
import com.drizzly.springmvc.model.IAccounts;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author rajaguru
 */
@Configuration
public class AccountDAO extends AbstractDao {
    final SessionFactory sessionFactory=LocalHibernateUtil.getSessionFactory();
   
    public void saveoOrUpdateAccount(DrTrAccounts accounts) {
        saveOrUpdate(accounts);
    }
    
    public  Map<String,List<IAccounts>> findByDateRange(DrTrAccounts account){
        System.out.print("inside by findByDateRange ");
        System.out.print("inside by findByDateRange account.getAcStaff()  "+account.getAcStaff());
        Map<String,List<IAccounts>> accounts = new HashMap<String, List<IAccounts>>();
        Collection<String> managmentCat = new ArrayList<String>();
        managmentCat.add("7");
        managmentCat.add("12");
        getSession().beginTransaction();
        final Criteria criteria = getSession().createCriteria(DrTrAccounts.class);
        criteria.add(Restrictions.between("acDate", account.getAcFromDate(), account.getAcToDate()));
        if(account.getAcStaff() > -1 ){
            criteria.add(Restrictions.eq("acStaff", account.getAcStaff()));
        }
        if(!account.getAcCategory().isEmpty()){
            criteria.add(Restrictions.eq("acCategory", account.getAcCategory()));
        }
//        Criterion mgmntCrit = Restrictions.in("acCategory", managmentCat);
//        criteria.add(Restrictions.not(mgmntCrit));
        criteria.addOrder(Order.desc("acDate"));
        System.out.print("inside by findByDateRange "+criteria.toString());
        List<IAccounts> accountList =null;
        if(criteria.list() != null){
            accountList = criteria.list();
       }
        
        if(!accountList.isEmpty()){
            List<IAccounts> mangmentAcc = new ArrayList<IAccounts>();
            List<IAccounts> normalAcc = new ArrayList<IAccounts>();
            for (IAccounts acc : accountList) {
                if(managmentCat.contains(acc.getAcCategory())){
                    mangmentAcc.add(acc);
                }else{
                    normalAcc.add(acc);
                }
            }
            accounts.put("normalAcc", normalAcc);
            accounts.put("mangmentAcc", mangmentAcc);
            //accounts.s
        }
        getSession().close();
        return accounts;
    }
    
    public  List<IAccounts> findByDateRange(final Date fromDate, final Date toDate){
        System.out.print("inside by findByDateRange ");
        getSession().beginTransaction();
        final Criteria criteria = getSession().createCriteria(DrTrAccounts.class);
        criteria.add(Restrictions.between("acDate", fromDate, toDate));
        criteria.addOrder(Order.desc("acDate"));
        System.out.print("inside by findByDateRange "+criteria.toString());
        List<IAccounts> accounts =null;
        if(criteria.list() != null){
            accounts = criteria.list();
        }
        getSession().close();
        return accounts;
    }
}
