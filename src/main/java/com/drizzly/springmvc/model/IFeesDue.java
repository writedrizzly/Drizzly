/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.model;

import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author rajaguru
 */
public interface IFeesDue {

    DrMaStudent getDrMaStudent();

    Long getFpId();

    BigInteger getFpPaidAmount();

    Date getFpPaidDate();

    String getFpPaidMode();
    
    Long getFpPaidToStaff();
}
