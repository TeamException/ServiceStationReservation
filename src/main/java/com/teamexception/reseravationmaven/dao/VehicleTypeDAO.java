/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamexception.reseravationmaven.dao;

import com.teamexception.reseravationmaven.model.VehicleType;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tharindu Jayathilake
 */
@Service
public interface VehicleTypeDAO {
    
    public boolean addVehilceType(VehicleType type) throws ClassNotFoundException, SQLException;
    
    public String getLastId() throws SQLException, ClassNotFoundException;
    
    public ArrayList<VehicleType> getAllVehilcesTypes() throws ClassNotFoundException,SQLException;
    
    public boolean isNameExists(String vehicleType);
    
    public String getVehilceTypebyId(String vehicleName);
        
}