/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.service;

import com.drizzly.springmvc.model.DrMaEmployee;
import com.drizzly.springmvc.model.IEmployee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author rajaguru
 */
@Configuration
public class EmployeeManager implements IEmployeeManager{

    @Autowired
    private IEmployeeDAO employeeDao;
    
    @Override
    public IEmployee findByEmId(Long emId) {
        return (IEmployee) employeeDao.findByEmId(emId); 
    }
    
    @Override
    public IEmployee findByEmName(String empNme) {
        return (IEmployee) employeeDao.findByEmName(empNme); 
    }
    
    @Override
    public void UpdateEmployee(DrMaEmployee emp) {
        employeeDao.updateEmployee(emp); 
    }

    @Override
    public void saveEmployee(DrMaEmployee emp) {
        employeeDao.saveEmployee(emp);
    }

    @Override
    public void removeEmployee(Long emId) {
        employeeDao.deleteEmployeeByEmId(emId);
    }

    @Override
    public List<IEmployee> getAllEmployees() {
        return employeeDao.findAllEmployees();
    }

}
