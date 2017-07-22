/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.service;

import com.drizzly.springmvc.model.DrMaEmployee;
import com.drizzly.springmvc.model.IEmployee;
import java.util.List;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author rajaguru
 */
public interface IEmployeeDAO {
     
    List<IEmployee> findAllEmployees();
    
    void saveEmployee(DrMaEmployee employee);
     
    void deleteEmployeeByEmId(Long emId);
     
    IEmployee findByEmId(Long emId);
    
    IEmployee findByEmName(final String emName);
     
    void updateEmployee(DrMaEmployee employee);
}
