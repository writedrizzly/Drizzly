/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.fees;

import com.drizzly.springmvc.model.IStudent;
import org.springframework.stereotype.Component;

/**
 *
 * @author rajaguru
 */
@Component
public class YearlyFees extends StudentFees {

    YearlyFees(){}
    YearlyFees(final String category) {
        super.calculateFeesHastoBePaid(category);
    }
    
    @Override
    public IStudent findStudentsFeesDetail(IStudent student, String category) {
        return feesPending(student);
    }

    @Override
    IStudent feesPending(IStudent student) {
        student.setStYetToPayTotal(student.getStThisYearFees().subtract(student.getStPaidTotal()).add(student.getStThisYearRegistration()));
        return student;
    }
    
}
