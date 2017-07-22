/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rajaguru
 */
public interface IAccounts {

    String getAcCategory();

    BigDecimal getAcCredit();

    Date getAcDate();

    BigDecimal getAcDebit();

    Integer getAcId();

    String getAcNote();
    
}
