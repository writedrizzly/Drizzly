/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drizzly.springmvc.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rajaguru
 */
public class DateUtil {
    
    private static DateUtil instance;
    
    private DateUtil(){}
    
    public static DateUtil getInstance(){
        if(instance == null){
            synchronized(DateUtil.class){
                if(instance == null){
                    instance = new DateUtil();
                }
            }
        }
        return instance;
    }
    
    public Date StringToDate(final String dateInString){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	Date date = null;
        try {
            date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));

	} catch (ParseException ex) {
             Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null, ex);
	}
        return date;
    }
    
    public Date parseToDate(final String dateStr){
        DateFormat formatter = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss Z");
        Date date = null;
        try {
            date = (Date)formatter.parse(dateStr);
        } catch (ParseException ex) {
            Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
}
