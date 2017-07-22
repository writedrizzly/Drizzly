/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.service;

import com.drizzly.springmvc.model.DrMaCategory;
import com.drizzly.springmvc.model.DrMaFees;
import com.drizzly.springmvc.model.DrMaStudent;
import com.drizzly.springmvc.model.DrTrFeesDue;
import com.drizzly.springmvc.model.IFees;
import com.drizzly.springmvc.model.IStudent;
import com.drizzly.springmvc.model.IStudentCategory;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

/**
 *
 * @author rajaguru
 */
@Component
public class StudentDAO extends AbstractDao{
   // final SessionFactory sessionFactory=LocalHibernateUtil.getSessionFactory();
   
    public void saveoOrUpdateStudent(DrMaStudent student) {
        saveOrUpdate(student);
    }
    
    public void saveoOrUpdateFees(DrTrFeesDue drTrFeesDue) {
        saveOrUpdate(drTrFeesDue);
    }
    
    public void updateStudent(DrMaStudent student) {
        update(student);
    }
    
    public IStudent findByStName(final String stName){
        System.out.print("inside by findby stName");
        getSession().beginTransaction();
        final Criteria criteria = getSession().createCriteria(DrMaStudent.class);
        criteria.add(Restrictions.eq("stName",stName));
        System.out.print("inside by findby "+criteria.toString());
        DrMaStudent student=null;
        if(criteria.uniqueResult() != null){
            student= (DrMaStudent) criteria.uniqueResult();
        }
        getSession().close();
        return student;
    }
    
    public IStudent getStudentInfo(Long studentId){
        System.out.print("inside by findby ");
        getSession().beginTransaction();
        final Criteria criteria = getSession().createCriteria(DrMaStudent.class);
        criteria.add(Restrictions.eq("stId",studentId));
        System.out.print("inside by findby "+criteria.toString());
        DrMaStudent student=null;
        if(criteria.uniqueResult() != null){
            student= (DrMaStudent) criteria.uniqueResult();
        }
        getSession().close();
        System.out.print("inside by findby stId "+student);
        return student;
    }
    
//    public List<IStudentFees> getStudentInfo(final Long rollNumber, final String name, final String mobile, final String email, final String category){
//        System.out.print("inside by findby ");
//        getSession().beginTransaction();
//        final Criteria criteria = getSession().createCriteria(StudentFees.class);
//        //criteria.add(Restrictions.eq("stId",studentId));
//        System.out.print("inside by findby "+criteria.toString());
////        DrMaStudent student=null;
////        if(criteria.uniqueResult() != null){
////            student= (DrMaStudent) criteria.uniqueResult();
////        }
//        List<IStudentFees> studentFeeses = criteria.list();
//        getSession().close();
//        return studentFeeses;
//    }
    
    public List<IStudent> getStudentInfo(final Long rollNumber, final String name, final String mobile, final String email, final String category){
        System.out.print("inside by find student ");
        getSession().beginTransaction();
        final Criteria criteria = getSession().createCriteria(DrMaStudent.class);
        if(rollNumber != null){
            criteria.add(Restrictions.eq("stId",rollNumber));
        }
        if(name != null && !"null".equalsIgnoreCase(name)){
            criteria.add(Restrictions.eq("stName",name));
        }
        if(mobile != null && !"null".equalsIgnoreCase(mobile)){
            criteria.add(Restrictions.eq("stMobile1",mobile));
        }
        if(email != null && !"null".equalsIgnoreCase(email)){
            criteria.add(Restrictions.eq("stEmail1",email));
        }
//        if(category != null&& !"null".equalsIgnoreCase(category)){
//            criteria.add(Restrictions.eq("stEmail1",category));
//        }
//        Criterion rollNumberCri = Restrictions.eq("stId",rollNumber);
//        Criterion nameCri = Restrictions.eq("stName",name);
//        Criterion mobile1Cri = Restrictions.eq("stMobile1",mobile);
//        Criterion mobile2Cri = Restrictions.eq("stMobile2",mobile);
//        Criterion emailCri = Restrictions.eq("stEmail1",email);
//        
//        Disjunction orExp = Restrictions.or(rollNumberCri,nameCri,mobile1Cri,mobile2Cri, emailCri);
//        criteria.add(orExp);
        //criteria.add(Restrictions.eq("stId",category));
        System.out.print("inside by find student "+criteria.toString());
        //DrMaStudent student=null;
        //if(criteria.uniqueResult() != null){
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<IStudent> student=  criteria.list();
        System.out.print("student list size :: "+student.size());
        System.out.print("students :: "+student);
        getSession().close();
        return student;
    }
    
    
    
    public List<IStudent> findStudentsByCategory(final String category){
        System.out.print("inside by find student category  ::  "+category);
        getSession().beginTransaction();
        final Criteria criteria = getSession().createCriteria(DrMaStudent.class);
        if(category != null && !"null".equalsIgnoreCase(category)){
            criteria.add(Restrictions.eq("drMaCategory.ctId",Long.valueOf(category)));
        }
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<IStudent> student=  criteria.list();
        System.out.print("student list size :: "+student.size());
        getSession().close();
        return student;
    }
    
    public IStudent findStudentsByCategory(final String category,final IStudent istudent){
        System.out.print("inside by find student category  ::  "+category);
        getSession().beginTransaction();
        final Criteria criteria = getSession().createCriteria(DrMaStudent.class);
        if(category != null && !"null".equalsIgnoreCase(category)){
            criteria.add(Restrictions.eq("drMaCategory.ctId",Long.valueOf(category)));
            criteria.add(Restrictions.eq("stId", istudent.getStId()));
        }
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<IStudent> student=  criteria.list();
        System.out.print("student list size :: "+student.size());
        getSession().close();
        return student.size() > 0 ? student.get(0) :istudent;
    }
            
    @SuppressWarnings("unchecked")
    public List<IStudent> findAllStudents() {
        getSession().beginTransaction();
        Criteria criteria = getSession().createCriteria(DrMaStudent.class);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        System.out.println("student criteria  "+criteria);
        List<IStudent> lst= criteria.list();
        getSession().close();
        return lst;
    }
    
    public void deleteStudent(Long studentId) {
        getSession().beginTransaction();
        Query query = getSession().createSQLQuery("update DR_MA_STUDENT set ST_RELIEVED_DATE=curdate() "
                       + "where ST_ID=:studentId");
      
        query.setLong("studentId",studentId );
        int result = query.executeUpdate();
        getSession().getTransaction().commit();
        System.out.println("result  "+result);
        getSession().close();
    }
    
    public List<IStudentCategory> getAllCategory(){
        getSession().beginTransaction();
        Criteria criteria = getSession().createCriteria(DrMaCategory.class);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        System.out.println("criteria "+criteria);
        List<IStudentCategory> studentCategorys = criteria.list();
        getSession().close();
        return studentCategorys;
    }
    public IStudent getStudentPaymentDetails(Long studentId){
        System.out.print("inside by findby ");
        getSession().beginTransaction();
        final Criteria criteria = getSession().createCriteria(DrMaStudent.class);
        criteria.add(Restrictions.eq("stId",studentId));
        System.out.print("inside by findby "+criteria.toString());
        DrMaStudent student=null;
        if(criteria.uniqueResult() != null){
            student= (DrMaStudent) criteria.uniqueResult();
        }
        getSession().close();
        return student;
    }

    public List<IFees> getAllFees(Integer year) {
        System.out.println("getAllFees  for the year :: "+year);
        getSession().beginTransaction();
        Criteria criteria = getSession().createCriteria(DrMaFees.class);
        criteria.add(Restrictions.eq("year",year));
       // criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        System.out.println("getAllFees ::  criteria "+criteria);
        List<IFees> allFees = criteria.list();
        getSession().close();
        System.out.println("allFees  :: "+allFees);
        return allFees;
    }

}
