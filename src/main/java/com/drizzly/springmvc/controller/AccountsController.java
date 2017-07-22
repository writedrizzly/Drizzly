/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.controller;

import com.drizzly.springmvc.common.DateUtil;
import com.drizzly.springmvc.model.DrTrAccounts;
import com.drizzly.springmvc.model.IAccounts;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author rajaguru
 */
@RestController
public class AccountsController {
    
    @Autowired
    AccountsFacade accountsFacade;

    List<IAccounts> mangmentAcc = null;
    
    //-------------------Retrieve listIAccounts--------------------------------------------------------
    @RequestMapping(value = "/accounts/search/{fromDate}/{toDate}", method = RequestMethod.GET)
    public ResponseEntity<List<IAccounts>> listIAccounts(@PathVariable("fromDate") String fromDate,
            @PathVariable("toDate") String toDate ) {
        Date parsedFromDate = DateUtil.getInstance().parseToDate(fromDate);
        Date parsedToDate = DateUtil.getInstance().parseToDate(toDate);
        System.out.println("fromDate  " + parsedFromDate+ " Todate  :  "+parsedToDate);
        List<IAccounts> accountses = accountsFacade.fetchAccounts(parsedFromDate, parsedToDate);
        System.out.println("list IAccounts  " + accountses);
        if (accountses.isEmpty()) {
            return new ResponseEntity<List<IAccounts>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        ResponseEntity responseEntity = new ResponseEntity<List<IAccounts>>(accountses, HttpStatus.OK);
        System.out.println("responseEntity  " + responseEntity.toString());
        return responseEntity;
    }

    //-------------------Retrieve listIAccounts--------------------------------------------------------
    @RequestMapping(value = "/accounts/search/", method = RequestMethod.POST)
    public ResponseEntity<List<IAccounts>> listIAccounts(@RequestBody DrTrAccounts accounts, UriComponentsBuilder ucBuilder) {
        System.out.println("ftech listIAccounts");
        Map<String,List<IAccounts>> accountMap = accountsFacade.fetchAccounts(accounts);
        List<IAccounts> normalAcc = accountMap.get("normalAcc");
        mangmentAcc = accountMap.get("mangmentAcc");
        System.out.println("list IAccounts  " + normalAcc);
        if (normalAcc.isEmpty()) {
            return new ResponseEntity<List<IAccounts>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        ResponseEntity responseEntity = new ResponseEntity<Map<String,List<IAccounts>>>(accountMap, HttpStatus.OK);
        System.out.println("responseEntity for accounts/search ::  " + responseEntity.toString());
        return responseEntity;
    }
    
    //-------------------Create a accounts--------------------------------------------------------
    @RequestMapping(value = "/accounts/", method = RequestMethod.POST)
    public ResponseEntity<Void> addToAccounts(@RequestBody DrTrAccounts accounts, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating accounts  ::::  " + accounts);

        accountsFacade.saveAccount(accounts);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/accounts/{id}").buildAndExpand(accounts).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    
}
