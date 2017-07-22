/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.model;

import java.math.BigInteger;

/**
 *
 * @author rajaguru
 */
public interface IFees {

    DrMaCategory getDrMaCategory();

    BigInteger getFeAmountMonth();

    BigInteger getFeAmountTerm();

    BigInteger getFeAmountYear();
    
    BigInteger getFeRegistration();

    Long getFeId();

    Integer getYear();
    
}
