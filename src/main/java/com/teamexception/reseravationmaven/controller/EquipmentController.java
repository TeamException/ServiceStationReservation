/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamexception.reseravationmaven.controller;

import com.teamexception.reseravationmaven.dao.EquipmentDAO;
import com.teamexception.reseravationmaven.importedClasses.IdGenarator;
import com.teamexception.reseravationmaven.model.Equipment;
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
@RequestMapping("/view/facilitator/predefinedServices/equipmentController")
public class EquipmentController {

    @Autowired
    Equipment equipment;
    @Autowired
    EquipmentDAO equipmentdao;

    @RequestMapping(value = "addEquipment", method = RequestMethod.POST)
    public String addEquipment(HttpServletRequest request) throws ClassNotFoundException, SQLException, ServletException, IOException {
        String oldId = equipmentdao.getLastId();
        String newId = IdGenarator.idGenarator("E", oldId);

        settingUpValues(request, newId);
        /*= new Equipment(IdGenarator.idGenarator("E", oldId),"FOOOOOOOOO1" ,request.getParameter("equipmentName"), request.getParameter("description"), request.getParameter("manufacturer"), Integer.parseInt(request.getParameter("qty")), request.getParameter("purchasedDate"));*/
        if (equipmentdao.addEquipment(equipment)) {
            String msg = "Added Sucessfully";
            request.setAttribute("msg", msg);
        } else {
            String msg = "Failed To add";
            request.setAttribute("msg", msg);
        }
        return "success";
    }

    @RequestMapping(value = "editEquipment", method = RequestMethod.GET)
    public String getAllEquipments(HttpServletRequest request) throws ClassNotFoundException, SQLException {
        ArrayList<Equipment> equipmentList = equipmentdao.getAllEquipments("F0000000001");
        request.setAttribute("equipmentList", equipmentList);
        return "facilitator/predefinedServices/editEquipment";
    }

    @RequestMapping(value = "updateEquipment", method = RequestMethod.POST)
    public String updateEquipment(HttpServletRequest request) throws ClassNotFoundException, SQLException {
        settingUpValues(request, request.getParameter("equipmentId"));
        String msg = "";
        if (equipmentdao.updateEquipment(equipment)) {
            msg = "Updated Sucessfully";
            request.setAttribute("msg", msg);

        } else {
            msg = "Failed To update";
            request.setAttribute("msg", msg);
        }
        return "success";
    }

    @RequestMapping(value = "searchEquipment", method = RequestMethod.GET)
    public String searchEquipment(HttpServletRequest request) throws ClassNotFoundException, SQLException {
        System.out.println("hehe");
        Equipment equipment = equipmentdao.searchEquipmentById(request.getParameter("equipmentId"));
        System.out.println(equipment.getEquipmentId());
        if (equipment != null) {
            request.setAttribute("equipment", equipment);
        }
        return "facilitator/predefinedServices/updateEquipment";
    }

    @RequestMapping(value = "deleteEquipment", method = RequestMethod.GET)
    public String deleteEquipment(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String msg = "";
        if (equipmentdao.deleteEquipment(request.getParameter("equipmentId"))) {
            msg = "Deleted Sucessfully";
            request.setAttribute("msg", msg);

        } else {
            msg = "Failed To Delete";
            request.setAttribute("msg", msg);
        }
        return "success";
    }

    public void settingUpValues(HttpServletRequest request, String id) {
        equipment.setEquipmentId(id);
        equipment.setEquipmentName(request.getParameter("equipmentName"));
        equipment.setEquipmentDescription(request.getParameter("description"));
        equipment.setManufacturer(request.getParameter("manufacturer"));
        equipment.setPurchasedDate(request.getParameter("purchasedDate"));
        equipment.setQoh(Integer.parseInt(request.getParameter("qty")));
        equipment.setFacilitatorId("F0000000001");
    }

}
