/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.fees;

import com.drizzly.springmvc.model.IFees;
import com.drizzly.springmvc.model.IFeesDue;
import com.drizzly.springmvc.model.IStudent;
import com.drizzly.springmvc.service.StudentDAO;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author rajaguru
 */
public abstract class StudentFees {
    
    //@Autowired
    StudentDAO studentDAO=new StudentDAO();
    
    final Calendar now = Calendar.getInstance();
    final int curMonth = now.get(now.MONTH) +1;
    final int curYear = now.get(Calendar.YEAR);
    int finanzialYear = curYear;
    List<IFees> feeses;
    List<IStudent> students;
    
    
   // abstract List<IStudent> findStudentsFeesDetail();
    public abstract IStudent findStudentsFeesDetail(final IStudent student, final String category);
    abstract IStudent feesPending(IStudent student);
    
    protected List<IStudent> calculateFeesHastoBePaid(final String category) {
        System.out.println("curMonth  "+curMonth);
        if(curMonth < 5){
            finanzialYear = curYear - 1;
        }
        System.out.println("finanzialYear  "+finanzialYear);
        feeses = studentDAO.getAllFees(finanzialYear);
        students = studentDAO.findStudentsByCategory(category);
        for(IStudent student : students){
            BigInteger totalFeesPaid = BigInteger.ZERO;
            for(IFeesDue feesDue : student.getDrTrFeesDues()){
                System.out.print("feesDue.getFpPaidAmount()"+feesDue.getFpPaidAmount());
                totalFeesPaid = totalFeesPaid.add(feesDue.getFpPaidAmount());
            }
            for(IFees fees : feeses){
                if (Long.parseLong(category) == fees.getDrMaCategory().getCtId()){
                    System.out.println("category      : "+category);
                    student.setStThisMonthFees(fees.getFeAmountMonth());
                    student.setStThisYearFees(fees.getFeAmountYear());
                    student.setStThisTearmFees(fees.getFeAmountTerm());
                    student.setStThisYearRegistration(fees.getFeRegistration());
                    break;
                }
            }
            student.setStPaidTotal(totalFeesPaid);
        }
        
        return students;
    }
    
    protected IStudent calculateFeesHastoBePaid(final String category,final IStudent iStudent) {
//        final String[] playPreKgCat = new String[] {"1","2","5","6"};
//        List<String> list = Arrays.asList(playPreKgCat);
//        if(list.contains(category)){
            System.out.println("curMonth  "+curMonth);
            if(curMonth < 5){
                finanzialYear = curYear - 1;
            }
            System.out.println("finanzialYear  "+finanzialYear);
            feeses = studentDAO.getAllFees(finanzialYear);
            final IStudent student = studentDAO.findStudentsByCategory(category,iStudent);
                BigInteger totalFeesPaid = BigInteger.ZERO;
               // BigInteger feesPaidAmount = BigInteger.ZERO;
                for(IFeesDue feesDue : student.getDrTrFeesDues()){
                    System.out.print(feesDue);
                    System.out.print("feesDue.getFpPaidAmount()"+feesDue.getFpPaidAmount());
                    //feesPaidAmount = feesDue.getFpPaidAmount() == null ? BigInteger.ZERO :feesDue.getFpPaidAmount();
                    totalFeesPaid = totalFeesPaid.add(feesDue.getFpPaidAmount() == null ? BigInteger.ZERO :feesDue.getFpPaidAmount());
                    //totalFeesPaid = totalFeesPaid.add(feesPaidAmount);
                }
                for(IFees fees : feeses){
                    if(Long.parseLong(category) == fees.getDrMaCategory().getCtId()){
                        iStudent.setStThisMonthFees(fees.getFeAmountMonth());
                        iStudent.setStThisYearFees(fees.getFeAmountYear());
                        iStudent.setStThisTearmFees(fees.getFeAmountTerm());
                        iStudent.setStThisYearRegistration(fees.getFeRegistration());
                        break;
                    }
                }
                iStudent.setStPaidTotal(totalFeesPaid);
       // }
        return iStudent;
    }
    
    public List<IStudent> findStudentsFees() {
        
        for(IStudent student : students){
            feesPending(student);
        }
        
        return students;
    }
    
}
