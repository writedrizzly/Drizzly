package com.drizzly.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getIndexPage() {
        System.out.println(" IndexController ");
        return "DrizzlyHome";
    }

    @RequestMapping(value = "/employees" ,method = RequestMethod.GET)
    public String getEmployeesIndexPage() {
        System.out.println(" IndexController  : Employee Management ");
        return "Employee";
    }
    
    @RequestMapping(value = "/accounts" ,method = RequestMethod.GET)
    public String getAccountsIndexPage() {
        System.out.println(" IndexController  : Account Management ");
        return "Accounts";
    }
    
    @RequestMapping(value = "/accounts/search" ,method = RequestMethod.GET)
    public String getAccountsSearchIndexPage() {
        System.out.println(" IndexController  : Account Management ");
        return "accountssearch";
    }
    
    @RequestMapping(value = "/students" ,method = RequestMethod.GET)
    public String getStudentssIndexPage() {
        System.out.println(" IndexController  : Student Management ");
        return "Student";
    }
    
    @RequestMapping(value = "/studentsfees" ,method = RequestMethod.GET)
    public String getStudentsFeesIndexPage() {
        System.out.println(" IndexController  : Student Management ");
        return "Fees";
    }
    
    @RequestMapping(value = "/studentSearch" ,method = RequestMethod.GET)
    public String getStudentSearchIndexPage() {
        System.out.println(" IndexController  : Student Management ");
        return "StudentSearch";
    }
    
    @RequestMapping(value = "/admin/fee" ,method = RequestMethod.GET)
    public String getFeeAdminIndexPage() {
        System.out.println(" IndexController  : Student Management ");
        return "FeesAdmin";
    }
}