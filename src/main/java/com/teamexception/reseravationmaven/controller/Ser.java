/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamexception.reseravationmaven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Tharindu Jayathilake
 */
@Controller
@RequestMapping("/view/facilitator/predefinedServices")
public class Ser {
    
    @RequestMapping(value="add/{q}",method= RequestMethod.GET)
    public void addServices(@PathVariable("q") String data){
        String arr[]=data.split(",");
        String serviceName=arr[0];// first two elements servicename and description then sets of 3 elements
        String description=arr[1];
        for (int i=2;i<arr.length-2;) {
            System.out.print(arr[i++]+" "+arr[i++]+" "+arr[i++]);//printing sets
            System.out.println();
        }

    }
    
}
