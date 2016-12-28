/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamexception.reseravationmaven.controller;

import com.teamexception.reseravationmaven.dao.PredefinedServicesDAO;
import com.teamexception.reseravationmaven.importedClasses.IdGenarator;
import com.teamexception.reseravationmaven.model.PredefinedServices;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
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
@RequestMapping("/view/facilitator/predefinedServices/serviceController")
public class PredefinedController {
    
    @Autowired
    PredefinedServices services;
    @Autowired
    PredefinedServicesDAO servicesDAO;
    
    @RequestMapping(value = "addService", method = RequestMethod.POST)
    public String addService(HttpServletRequest request) throws ClassNotFoundException, SQLException, ServletException, IOException {
        String oldId = servicesDAO.getLastId();
        String newId = IdGenarator.idGenarator("S", oldId);

        settingUpValues(request, newId);
        /*= new Equipment(IdGenarator.idGenarator("E", oldId),"FOOOOOOOOO1" ,request.getParameter("equipmentName"), request.getParameter("description"), request.getParameter("manufacturer"), Integer.parseInt(request.getParameter("qty")), request.getParameter("purchasedDate"));*/
        if (servicesDAO.addService(services)) {
            String msg = "Added Sucessfully";
            request.setAttribute("msg", msg);
        } else {
            String msg = "Failed To add";
            request.setAttribute("msg", msg);
        }
        return "success";
    }

    @RequestMapping(value = "editServices", method = RequestMethod.GET)
    public String getAllServices(HttpServletRequest request) throws ClassNotFoundException, SQLException {
        ArrayList<PredefinedServices> servicesList = servicesDAO.getAllServices("F0000000001");
        request.setAttribute("servicesList", servicesList);
        return "facilitator/predefinedServices/editServices";
    }

    @RequestMapping(value = "updateServices", method = RequestMethod.POST)
    public String updateServices(HttpServletRequest request) throws ClassNotFoundException, SQLException {
        settingUpValues(request, request.getParameter("serviceId"));
        String msg = "";
        if (servicesDAO.updateService(services)) {
            msg = "Updated Sucessfully";
            request.setAttribute("msg", msg);

        } else {
            msg = "Failed To update";
            request.setAttribute("msg", msg);
        }
        return "success";
    }

    @RequestMapping(value = "searchServices", method = RequestMethod.GET)
    public String searchServices(HttpServletRequest request) throws ClassNotFoundException, SQLException {
        PredefinedServices services = servicesDAO.searchServiceById(request.getParameter("serviceId"));
        if (services != null) {
            request.setAttribute("services", services);
        }
        return "facilitator/predefinedServices/updateServices";
    }

    @RequestMapping(value = "deleteServices", method = RequestMethod.GET)
    public String deleteServices(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String msg = "";
        if (servicesDAO.deleteService(request.getParameter("serviceId"))) {
            msg = "Deleted Sucessfully";
            request.setAttribute("msg", msg);

        } else {
            msg = "Failed To Delete";
            request.setAttribute("msg", msg);
        }
        return "success";
    }

    public void settingUpValues(HttpServletRequest request, String id) {
        services.setServiceId(id);
        services.setServiceName(request.getParameter("serviceName"));
        services.setDescription(request.getParameter("description"));
        services.setFacilitatorId("F0000000001");
    }

    
}
