/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamexception.reseravationmaven.controller;

import com.teamexception.reseravationmaven.dao.VehicleTypeDAO;
import com.teamexception.reseravationmaven.importedClasses.IdGenarator;
import com.teamexception.reseravationmaven.model.VehicleType;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Tharindu Jayathilake
 */
@Controller
@RequestMapping("/view/facilitator/predefinedServices/vehicleTypeController")
public class VehicleTypeController {

    @Autowired
    VehicleType type;
    @Autowired
    VehicleTypeDAO typeDAO;

    @RequestMapping(value = "addType", method = RequestMethod.POST)
    public String addVehilceType(
            @RequestParam(value = "vehicleType", required = false, defaultValue = "No Type") String vehicleType,
            HttpServletRequest request)
            throws SQLException, ClassNotFoundException {
        String id = IdGenarator.idGenarator("T", typeDAO.getLastId());
        type = new VehicleType(id, vehicleType);

        boolean isAdded = false;
        boolean isNameExists = typeDAO.isNameExists(type.getVehicleName());
        if (!isNameExists) {
            isAdded = typeDAO.addVehilceType(type);
        }

        if (isAdded) {
            String msg = "Added Sucessfully";
            request.setAttribute("msg", msg);
        } else if (isNameExists) {
            String msg = "That Vehicle Type already exists";
            request.setAttribute("msg", msg);
        } else {
            String msg = "Failed To add";
            request.setAttribute("msg", msg);
        }
        return "success";
    }

    @RequestMapping(value = "allVehicleTypes", method = RequestMethod.GET)
    public void getAllVehilceTypes(HttpServletResponse resp) throws ClassNotFoundException, SQLException, IOException {
        ArrayList<VehicleType> types = typeDAO.getAllVehilcesTypes();
        String txt = "<select id=\"type\" class=\"form-control\" name=\"vehicleType\">";
        for (VehicleType type : types) {
            txt+="<option>"+type.getVehicleName()+"</option>";
        }
        txt+="</select>";
        txt+="<a href=\"addNewVehicleType.jsp\">Add New Vehicle Type</a>";
        PrintWriter out =resp.getWriter();
        out.print(txt);
        out.close();
    }
    
}
