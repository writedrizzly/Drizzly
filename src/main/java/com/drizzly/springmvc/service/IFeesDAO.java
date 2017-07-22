/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.service;

import com.drizzly.springmvc.model.IFees;
import java.util.List;

/**
 *
 * @author rajaguru
 */
public interface IFeesDAO {

    List<IFees> findFeesByYear(Long year);

    void persistFee(IFees fee);

    void saveFee(IFees fee);

    void saveOrUpdateFee(IFees fee);

    void saveoOrUpdateEmployee(IFees fees);
    
}
