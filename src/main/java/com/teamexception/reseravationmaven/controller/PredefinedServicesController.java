/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamexception.reseravationmaven.controller;

import com.teamexception.reseravationmaven.dao.PredefinedServicesDAO;
import com.teamexception.reseravationmaven.dao.VehicleTypeDAO;
import com.teamexception.reseravationmaven.dao.VehicleTypeServiceDAO;
import com.teamexception.reseravationmaven.importedClasses.IdGenarator;
import com.teamexception.reseravationmaven.model.PredefinedServices;
import com.teamexception.reseravationmaven.model.VehicleServiceType;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Tharindu Jayathilake
 */
@Controller
@RequestMapping("/view/facilitator/predefinedServices/serviceController")
public class PredefinedServicesController {

    @Autowired
    PredefinedServices services;
    @Autowired
    PredefinedServicesDAO servicesDAO;
    @Autowired
    VehicleTypeDAO typeDAO;
    @Autowired
    VehicleTypeServiceDAO serviceVehicleTypeDAO;
    @Autowired
    VehicleServiceType serviceType;

    @RequestMapping(value = "add/{q}", method = RequestMethod.GET)
    public String addService(HttpServletRequest request, @PathVariable("q") String data) throws ClassNotFoundException, SQLException, ServletException, IOException {
        String oldId = servicesDAO.getLastId();
        String newId = IdGenarator.idGenarator("S", oldId);

        String arr[] = data.split(",");
        String serviceName = arr[0];// first two elements servicename and description then sets of 3 elements
        String description = arr[1];

        settingUpValues(newId, serviceName, description);
        /*= new Equipment(IdGenarator.idGenarator("E", oldId),"FOOOOOOOOO1" ,request.getParameter("equipmentName"), request.getParameter("description"), request.getParameter("manufacturer"), Integer.parseInt(request.getParameter("qty")), request.getParameter("purchasedDate"));*/
        boolean isServiceAdded = false;
        boolean isTypeAdded = false;

        if (servicesDAO.addService(services)) {
            isServiceAdded = true;
            /*String msg = "Added Sucessfully";
            request.setAttribute("msg", msg);*/
        } else {
            /*String msg = "Failed To add";
            request.setAttribute("msg", msg);*/
            isServiceAdded = false;
        }

        for (int i = 2; i < arr.length - 2;) {
            isTypeAdded = false;
            settingUpVehicleTypeValues(arr[i++], newId, arr[i++], arr[i++]);
            isTypeAdded = serviceVehicleTypeDAO.addServiceVehilceType(serviceType);
        }

        if (isTypeAdded && isServiceAdded) {
            String msg = "Added Sucessfully";
            request.setAttribute("msg", msg);
        } else {
            String msg = "Failed To add";
            request.setAttribute("msg", msg);
        }
        return "success";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String getAllServices(HttpServletRequest request) throws ClassNotFoundException, SQLException {
        ArrayList<PredefinedServices> servicesList = servicesDAO.getAllServices("F0000000001");
        request.setAttribute("serviceList", servicesList);
        return "facilitator/predefinedServices/editServices";
    }
    
    @RequestMapping(value = "updateService", method = RequestMethod.POST)
    public String updateServices(HttpServletRequest request) throws ClassNotFoundException, SQLException {
        settingUpValues(request.getParameter("serviceId"),request.getParameter("serviceName"),request.getParameter("description"));
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
    
    @RequestMapping(value = "updateService", method = RequestMethod.POST)
    public String updateVehicleType(HttpServletRequest request) throws ClassNotFoundException, SQLException {
        request.setAttribute("serviceId", request.getParameter("serviceId"));
        return "/view/facilitator/predefinedServices/updateVehicleType";
    }
    
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String searchServices(HttpServletRequest request) throws ClassNotFoundException, SQLException {
        PredefinedServices services = servicesDAO.searchByServiceTypeId(request.getParameter("serviceId"));
        ArrayList<VehicleServiceType> serviceTypes = serviceVehicleTypeDAO.getAllVehicleTypeId(request.getParameter("serviceId"));
        if (services != null) {
            request.setAttribute("service", services);
        } 
        if (serviceTypes !=null) {
            request.setAttribute("serviceTypes", serviceTypes);
        }
        
        return "facilitator/predefinedServices/searchService";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
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

    public void settingUpValues(String id, String name, String description) {
        services.setServiceId(id);
        services.setServiceName(name);
        services.setDescription(description);
        services.setFacilitatorId("F0000000001");
    }

    public VehicleServiceType settingUpVehicleTypeValues(String type, String serviceId, String duration, String cost) {
        String typeId = typeDAO.getVehilceTypebyId(type);
        //System.out.println(typeId);
        serviceType.setServiceId(serviceId);
        serviceType.setTypeId(typeId);
        serviceType.setCost(Double.parseDouble(cost));
        serviceType.setDuration(Integer.parseInt(duration));
        return serviceType;
    }

}
