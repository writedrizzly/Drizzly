/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.service;

import com.drizzly.springmvc.model.DrMaEmployee;
import com.drizzly.springmvc.model.IEmployee;
import java.util.List;

/**
 *
 * @author rajaguru
 */
public interface IEmployeeManager {
    
    List<IEmployee> getAllEmployees() ;
    
    IEmployee findByEmId(Long emId);
    
    IEmployee findByEmName(String empNme);
    
    void saveEmployee(DrMaEmployee emp);
    
    void removeEmployee(Long emId);
    
    void UpdateEmployee(DrMaEmployee emp);
}
