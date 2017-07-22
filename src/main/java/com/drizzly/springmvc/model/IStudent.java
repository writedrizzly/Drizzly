/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author rajaguru
 */
public interface IStudent {

    Set<DrTrFeesDue> getDrTrFeesDues();
    
    DrMaCategory getDrMaCategory();

    String getStAddress();

    String getStCity();

    String getStCountry();

    String getStEmail1();

    String getStFatherName();

    String getStFeesMode();
    
    

    Long getStId();

    Date getStJoinedDate();

    String getStMobile1();

    String getStMobile2();

    String getStMotherName();

    String getStName();

    String getStPincode();

    Date getStRelievedDate();

    String getStState();
    
    void setStPaidTotal(BigInteger stPaidTotal);
    void setStYetToPayTotal(BigInteger stYetToPayTotal);
    void setStThisTearmFees(BigInteger stThisTearmFees);
    void setStThisMonthFees(BigInteger stThisMonthFees);
    void setStThisYearFees(BigInteger stThisYearFees);
    void setStThisYearRegistration(BigInteger stRegistration);
    
    BigInteger getStPaidTotal();
    BigInteger getStYetToPayTotal();
    BigInteger getStThisTearmFees();
    BigInteger getStThisMonthFees();
    BigInteger getStThisYearFees();
    BigInteger getStThisYearRegistration();
}
