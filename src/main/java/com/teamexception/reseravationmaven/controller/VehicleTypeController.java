/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamexception.reseravationmaven.controller;

import com.teamexception.reseravationmaven.dao.VehicleTypeDAO;
import com.teamexception.reseravationmaven.importedClasses.IdGenarator;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Tharindu Jayathilake
 */
@Controller
public class VehicleTypeController {
       
    @RequestMapping(value = "/view/facilitator/predefinedServices/VehicleTypeController", method = RequestMethod.POST)
    @ResponseBody 
    public boolean addVehilceType(
            @RequestParam(value="vehicleType", required = false, defaultValue = "No Type") String vehicleType) 
            throws SQLException, ClassNotFoundException{
        String id = IdGenarator.idGenarator("T",VehicleTypeDAO.getLastId());
        return VehicleTypeDAO.addVehilceType(id, vehicleType);
    }
}
