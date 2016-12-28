/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamexception.reseravationmaven.dao;

import com.teamexception.reseravationmaven.model.Equipment;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tharindu Jayathilake
 */
@Service
public interface EquipmentDAO {

    public boolean addEquipment(Equipment equipment) throws ClassNotFoundException, SQLException;

    public String getLastId() throws ClassNotFoundException, SQLException;

    public boolean updateEquipment(Equipment equipment) throws ClassNotFoundException, SQLException;

    public ArrayList<Equipment> getAllEquipments(String facilitatorId) throws ClassNotFoundException, SQLException;;

    public Equipment searchEquipmentById(String equipmentId)throws ClassNotFoundException, SQLException;;

    public boolean deleteEquipment(String equipmentId) throws ClassNotFoundException, SQLException;

}
