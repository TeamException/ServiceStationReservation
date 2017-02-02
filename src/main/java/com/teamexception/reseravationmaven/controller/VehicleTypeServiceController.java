/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamexception.reseravationmaven.controller;

import com.teamexception.reseravationmaven.dao.PredefinedServicesDAO;
import com.teamexception.reseravationmaven.dao.VehicleTypeDAO;
import com.teamexception.reseravationmaven.dao.VehicleTypeServiceDAO;
import com.teamexception.reseravationmaven.model.PredefinedServices;
import com.teamexception.reseravationmaven.model.VehicleServiceType;
import com.teamexception.reseravationmaven.model.VehicleType;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Tharindu Jayathilake
 */
@Controller
@RequestMapping("/view/facilitator/predefinedServices/serviceTypeController")
public class VehicleTypeServiceController {
    @Autowired
    VehicleServiceType type;
    @Autowired
    VehicleTypeServiceDAO serviceTypeDAO;
    @Autowired
    PredefinedServicesDAO servicesDAO;
    @Autowired
    PredefinedServices services;
    @Autowired
    VehicleTypeDAO vehicleTypeDAO;
    
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addVehicleType(HttpServletRequest request)throws ClassNotFoundException, SQLException{
        settingUpValues(request);
        if (serviceTypeDAO.addServiceVehilceType(type)) {
            String msg = "Type added sucessfully";
            request.setAttribute("msg", msg);
        }else {
            String msg = "Failed To add";
            request.setAttribute("msg", msg);
        }
        return "success";
    }
    
    public String updateServiceVehilceType(HttpServletRequest request) throws ClassNotFoundException, SQLException{
        settingUpValues(request);
        if (serviceTypeDAO.updateService(type)) {
            String msg = "Updated Sucessfully";
            request.setAttribute("msg", msg);
        } else {
            String msg = "Failed To Update";
            request.setAttribute("msg", msg);
        }
        return "success";
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String searchVehilceType(HttpServletRequest request) throws ClassNotFoundException, SQLException {
        String msg = "";
        VehicleServiceType serviceVehicleType = serviceTypeDAO.searchByVehicleTypeId(request.getParameter("serviceId"), request.getParameter("typeId"));
        request.setAttribute("type", serviceVehicleType);
        services = servicesDAO.searchByServiceTypeId(request.getParameter("serviceId"));
        request.setAttribute("service", services);
        return "success";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteEquipment(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String msg = "";
        if (serviceTypeDAO.deleteVehicleTypeId(request.getParameter("serviceId"),request.getParameter("typeId"))) {
            msg = "Deleted Sucessfully";
            request.setAttribute("msg", msg);

        } else {
            msg = "Failed To Delete";
            request.setAttribute("msg", msg);
        }
        return "success";
    }

    private void settingUpValues(HttpServletRequest request) {
        type.setTypeId(getVilceTypeId(request.getParameter("typeName")));
        type.setServiceId(request.getParameter("serviceId"));
        type.setDuration(Integer.parseInt(request.getParameter("duration")));
        type.setCost(Double.parseDouble(request.getParameter("cost")));
    }
    
    private String getVilceTypeId(String vehicleName){
        return vehicleTypeDAO.getVehilceTypebyId(vehicleName);
    }
}
