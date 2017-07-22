/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.controller;

import com.drizzly.springmvc.model.DrMaEmployee;
import com.drizzly.springmvc.model.IEmployee;
import com.drizzly.springmvc.service.EmployeeManager;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rajaguru
 */
@Service("employeeService")
@Transactional
public class EmployeeFacade {

    @Autowired
    EmployeeManager manager;

    protected List<IEmployee> findAllEmployee() {
        List<IEmployee> iEmployee = manager.getAllEmployees();
        return iEmployee;
    }

    protected IEmployee findByEmId(final Long empId) {
        IEmployee iEmployee = manager.findByEmId(empId);
        return iEmployee;
    }
    
    protected void removeEmployee(final long id) {
        manager.removeEmployee(id);
    }
    
    protected void saveEmployee(final DrMaEmployee employee) {
        manager.saveEmployee(employee);
    }

    protected DrMaEmployee updateEmployee(final DrMaEmployee employee) {
        final IEmployee iEmployee = findByEmId(employee.getEmId());
        System.out.println("existiEmployee  brfore update "+iEmployee);
        DrMaEmployee existiEmployee = null;
        if (iEmployee != null) {
            existiEmployee = (DrMaEmployee) iEmployee;
            existiEmployee.setEmAddress(employee.getEmAddress());
            existiEmployee.setEmName(employee.getEmName());
            existiEmployee.setEmMobile1(employee.getEmMobile1());
            existiEmployee.setEmCity(employee.getEmCity());
            existiEmployee.setEmPincode(employee.getEmPincode());
            existiEmployee.setEmJoinDate(employee.getEmJoinDate());
            existiEmployee.setEmEmail1(employee.getEmEmail1());
            System.out.println("existiEmployee  "+existiEmployee);
            manager.UpdateEmployee(existiEmployee);
        } 
        return existiEmployee;
    }
    
    protected boolean isEmployeeExist(final IEmployee employee) {
        return manager.findByEmName(employee.getEmName()) != null;
    }
    
    
}
