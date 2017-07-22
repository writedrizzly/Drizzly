package com.drizzly.springmvc.controller;

import com.drizzly.springmvc.model.DrMaEmployee;
import com.drizzly.springmvc.model.IEmployee;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class EmployeeRestController {

    @Autowired
    EmployeeFacade employeeFacade;

    //-------------------Retrieve All Employees--------------------------------------------------------
    @RequestMapping(value = "/employees/", method = RequestMethod.GET)
    public ResponseEntity<List<IEmployee>> listAllEmployees() {
        List<IEmployee> employees = employeeFacade.findAllEmployee();
        System.out.println("listAllEmployeess  " + employees);
        if (employees.isEmpty()) {
            return new ResponseEntity<List<IEmployee>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        ResponseEntity responseEntity = new ResponseEntity<List<IEmployee>>(employees, HttpStatus.OK);
        System.out.println("responseEntity  " + responseEntity.toString());
        return responseEntity;
    }

    //-------------------Create a Employee--------------------------------------------------------
    @RequestMapping(value = "/employees/", method = RequestMethod.POST)
    public ResponseEntity<Void> createEmployee(@RequestBody DrMaEmployee employee, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Employee " + employee);

        if (employeeFacade.isEmployeeExist(employee)) {
            System.out.println("A Employee with name " + employee.getEmName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        employeeFacade.saveEmployee(employee);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/employees/{id}").buildAndExpand(employee.getEmId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    //------------------- Delete a Employee --------------------------------------------------------

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<IEmployee> deleteEmployee(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Employee with id " + id);
        employeeFacade.removeEmployee(id);
        return new ResponseEntity<IEmployee>(HttpStatus.NO_CONTENT);
    }

    //------------------- Update a Employee --------------------------------------------------------
    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    public ResponseEntity<DrMaEmployee> updateUser(@PathVariable("id") long id, @RequestBody DrMaEmployee employee) {
        System.out.println("Updating User " + employee);

        DrMaEmployee iEmployee = employeeFacade.updateEmployee(employee);

        if (iEmployee == null) {
            System.out.println("Employee with id " + id + " not found");
            return new ResponseEntity<DrMaEmployee>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<DrMaEmployee>(iEmployee, HttpStatus.OK);
    }
}
