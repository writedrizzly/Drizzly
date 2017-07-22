/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.fees;

import com.drizzly.springmvc.model.IStudent;
import java.math.BigInteger;
import java.util.Calendar;
import org.springframework.stereotype.Component;

/**
 *
 * @author rajaguru
 */
@Component
public class TermFees extends StudentFees{
    
    public TermFees(String category){
        super.calculateFeesHastoBePaid(category);
    }

    public TermFees(String category,IStudent student){
        super.calculateFeesHastoBePaid(category,student);
    }
    public TermFees() {
    }
    
    @Override 
    protected IStudent feesPending(IStudent student){
        Calendar cal = Calendar.getInstance();
        cal.setTime(student.getStJoinedDate());
        int joinedMonth = student.getStJoinedDate().getMonth() + 1;//cal.get(Calendar.MONTH  + 1);
        BigInteger feesHasToBePaid = BigInteger.ZERO;
        BigInteger pendingFeesToPay = BigInteger.ZERO;
        System.out.println("student.getStThisTearmFees()"+student.getStThisTearmFees());
        BigInteger halfTermFees = student.getStThisTearmFees().divide(BigInteger.valueOf(2));
        System.out.println("halfTermFees  "+halfTermFees);
        /*
        First term fees caluculation
        */
        feesHasToBePaid.add(student.getStThisYearRegistration());
        if(curMonth > 4 && curMonth < 10){ 
            if( (joinedMonth > 7 && joinedMonth < 10)  ){  // Late joinee in First term
                feesHasToBePaid = halfTermFees;
            }else{
                feesHasToBePaid = student.getStThisTearmFees();
            }
            pendingFeesToPay = feesHasToBePaid.subtract(student.getStPaidTotal());
        }else
        /*
        Second term fees caluculation
        */
        if(curMonth > 9 && curMonth < 2){ 
            if( (joinedMonth > 7 && joinedMonth < 10)  ){   // Late joinee in First term
                feesHasToBePaid = halfTermFees.add(student.getStThisTearmFees());
            }else if (joinedMonth > 9 && joinedMonth < 12){ // second term joinees 
                feesHasToBePaid = student.getStThisTearmFees();
            }else if (joinedMonth > 11 && joinedMonth < 2){ // Late joinee in second term 
                feesHasToBePaid = halfTermFees;
            }else{
                feesHasToBePaid = student.getStThisTearmFees().multiply(BigInteger.valueOf(2));
            }
            pendingFeesToPay = feesHasToBePaid.subtract(student.getStPaidTotal());
        }else
        /* 
            Third Term Fees calculation
        */
        if(curMonth > 1 && curMonth < 4){
            System.out.println("joinedMonth  :: "+joinedMonth);
            if (joinedMonth > 7 && joinedMonth < 10){   // Late joinee in First term
                System.out.println("student.getStThisTearmFees() ...."+student.getStThisTearmFees());
                feesHasToBePaid = halfTermFees.add(student.getStThisTearmFees().multiply(BigInteger.valueOf(2)));
                System.out.println("month 1- 4  >> "+feesHasToBePaid);
            }else if (joinedMonth > 9 && joinedMonth < 12){ // second term joinees 
                feesHasToBePaid = student.getStThisTearmFees().multiply(BigInteger.valueOf(2));
            }else if (joinedMonth > 11 && joinedMonth < 2){ // Late joinee in second term 
                feesHasToBePaid = halfTermFees.add(student.getStThisTearmFees());
            }else if (joinedMonth > 1 && joinedMonth < 4){ //  Third term 
                feesHasToBePaid = student.getStThisTearmFees();
            }else if (joinedMonth > 3 && joinedMonth < 5){ // Late joinee in Third term 
                feesHasToBePaid = halfTermFees;
            }else{
                feesHasToBePaid = student.getStThisTearmFees().multiply(BigInteger.valueOf(3));
            }
            System.out.println("feesHasToBePaid  ::  "+feesHasToBePaid);
            pendingFeesToPay = feesHasToBePaid.subtract(student.getStPaidTotal());
            System.out.println("pendingFeesToPay  ::  "+pendingFeesToPay);
        }
        student.setStYetToPayTotal(pendingFeesToPay);
        return student;
    }

    @Override
    public IStudent findStudentsFeesDetail(IStudent student, String category) {
         System.out.println(" student "+student);
        IStudent istudent = feesPending(student);
        System.out.println(" student  termfees detail "+istudent);
        return istudent;
    }
}
