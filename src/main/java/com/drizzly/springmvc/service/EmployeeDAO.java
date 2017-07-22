/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.service;

import com.drizzly.springmvc.LocalHibernateUtil;
import com.drizzly.springmvc.model.DrMaEmployee;
import com.drizzly.springmvc.model.IEmployee;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author rajaguru
 */
@Configuration
public class EmployeeDAO extends AbstractDao implements IEmployeeDAO{
   final SessionFactory sessionFactory=LocalHibernateUtil.getSessionFactory();
   
    public void saveoOrUpdateEmployee(DrMaEmployee employee) {
        saveOrUpdate(employee);
    }
 
    @SuppressWarnings("unchecked")
    public List<IEmployee> findAllEmployees() {
        getSession().beginTransaction();
        Criteria criteria = getSession().createCriteria(DrMaEmployee.class);
        List<IEmployee> lst= criteria.list();
        getSession().close();
        return lst;
    }
 
    public void deleteEmployeeByEmId(Long emId) {
        if(findByEmId(emId) != null){
            System.out.print("inside delete ");
            getSession().beginTransaction();
            Query query = getSession().createSQLQuery("delete from DR_MA_EMPLOYEE where em_Id = :emId");
            query.setLong("emId",emId);
            query.executeUpdate();
            getSession().getTransaction().commit();
            getSession().close();
        }
    }
 
     
    public IEmployee findByEmId(Long emId){
        System.out.print("inside by findby ");
        getSession().beginTransaction();
        final Criteria criteria = getSession().createCriteria(DrMaEmployee.class);
        criteria.add(Restrictions.eq("emId",emId));
        System.out.print("inside by findby "+criteria.toString());
        DrMaEmployee emp=null;
        if(criteria.uniqueResult() != null){
            emp= (DrMaEmployee) criteria.uniqueResult();
        }
        getSession().close();
        return emp;
    }
    
    public IEmployee findByEmName(final String emName){
        System.out.print("inside by findby ");
        getSession().beginTransaction();
        final Criteria criteria = getSession().createCriteria(DrMaEmployee.class);
        criteria.add(Restrictions.eq("emName",emName));
        System.out.print("inside by findby "+criteria.toString());
        DrMaEmployee emp=null;
        if(criteria.uniqueResult() != null){
            emp= (DrMaEmployee) criteria.uniqueResult();
        }
        getSession().close();
        return emp;
    }
     
    public void updateEmployee(DrMaEmployee employee){
        update(employee);
//        getSession().beginTransaction();
//        Query query = getSession().createSQLQuery("update DR_MA_EMPLOYEE set EM_NAME=:emName, "
//                + "EM_ADDRESS=:emAddress, EM_PINCODE=:emPincode, EM_MOBILE1=:emMobile1, EM_MOBILE2=:emMobile2, EM_EMAIL1=:emEmail1 "
//                + "where EM_ID=:emId");
//        query.setString("emName", employee.getEmName());
//        query.setString("emAddress", employee.getEmAddress());
//        query.setString("emPincode", employee.getEmPincode());
//        query.setString("emMobile1", employee.getEmMobile1());
//        query.setString("emMobile2", employee.getEmMobile2());
//        query.setString("emEmail1", employee.getEmEmail1());
//        query.setLong("emId", employee.getEmId());
//        int result = query.executeUpdate();
//        getSession().getTransaction().commit();
//        System.out.println("result  "+result);
//        getSession().close();
    }
    
    public void saveOrUpdateEmployee(DrMaEmployee employee){
        saveOrUpdate(employee);
    }
    
    public void saveEmployee(DrMaEmployee employee){
        save(employee);
    }
    
    public void persistEmployee(DrMaEmployee employee){
        persist(employee);
    }
}
