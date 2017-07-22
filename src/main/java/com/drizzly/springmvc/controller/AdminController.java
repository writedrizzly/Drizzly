/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.controller;

import com.drizzly.springmvc.common.DateUtil;
import com.drizzly.springmvc.model.IAccounts;
import com.drizzly.springmvc.model.IFees;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rajaguru
 */
@RestController
public class AdminController {
    
    @Autowired
    private AdminFacade adminFacade;
    
     //-------------------Retrieve list fees--------------------------------------------------------
    @RequestMapping(value = "/admin/search/{year}", method = RequestMethod.GET)
    public ResponseEntity<List<IFees>> listIAccounts(@PathVariable("year") String year ) {
        List<IFees> fees = adminFacade.getAllFeesOnYear(Long.valueOf(year));
        System.out.println("list fees  " + fees);
        if (fees.isEmpty()) {
            return new ResponseEntity<List<IFees>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        ResponseEntity responseEntity = new ResponseEntity<List<IFees>>(fees, HttpStatus.OK);
        System.out.println("responseEntity  " + responseEntity.toString());
        return responseEntity;
    }
}
