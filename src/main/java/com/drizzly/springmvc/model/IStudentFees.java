/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author rajaguru
 */
public interface IStudentFees extends Serializable {

    String getStAddress();

    String getStCity();

    String getStCountry();

    Long getStCtId();

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
    
    //Set getDrTrFeesDues();
    
}
