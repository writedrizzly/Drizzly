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
public class MonthlyFees extends StudentFees{

    public MonthlyFees(){}
    public MonthlyFees(final String category) {
        super.calculateFeesHastoBePaid(category);
    }
    
    public MonthlyFees(String category,IStudent student){
        super.calculateFeesHastoBePaid(category,student);
    }
    @Override
    public IStudent findStudentsFeesDetail(IStudent student, String category) {
        return feesPending(student);
    }

    @Override
    IStudent feesPending(IStudent student) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(student.getStJoinedDate());
        System.out.println("student.getStJoinedDate()  :: "+student.getStJoinedDate());
        //int joinedMonth = cal.get(Calendar.MONTH  + 1);
        int joinedMonth = student.getStJoinedDate().getMonth() + 1;
        int noOfMonth = curMonth - joinedMonth;
        System.out.println("joinedMonth  :: "+joinedMonth);
        System.out.println("curMonth  :: "+curMonth);
        if(noOfMonth < 0){
            noOfMonth = (12-joinedMonth)+curMonth;
        }else if(noOfMonth == 0){
            noOfMonth = 1;
        }
        System.out.println("noOfMonth  ::  "+noOfMonth);
        System.out.println("student.getStThisMonthFees()  :: "+student.getStThisMonthFees());
        BigInteger feesHasToBePaid = student.getStThisMonthFees().multiply(BigInteger.valueOf(noOfMonth)).add(student.getStThisYearRegistration());
        BigInteger pendingFeesToPay = feesHasToBePaid.subtract(student.getStPaidTotal());
        student.setStYetToPayTotal(pendingFeesToPay);
        return student;
    }

}
