/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamexception.reseravationmaven.dao;

import com.teamexception.reseravationmaven.model.VehicleServiceType;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tharindu Jayathilake
 */
@Service
public interface VehicleTypeServiceDAO {
    
    public boolean addServiceVehilceType(VehicleServiceType svt) throws SQLException, ClassNotFoundException;
        
    public boolean updateService(VehicleServiceType svt) throws ClassNotFoundException, SQLException;

    public ArrayList<VehicleServiceType> getAllVehicleTypeId(String serviceId) throws ClassNotFoundException, SQLException;;

    public VehicleServiceType searchByVehicleTypeId(String serviceId , String typeId) throws ClassNotFoundException, SQLException;;

    public boolean deleteVehicleTypeId(String serviceId,String typeId) throws ClassNotFoundException, SQLException;
}
