/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamexception.reseravationmaven.mapper;

import com.teamexception.reseravationmaven.model.VehicleServiceType;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Tharindu Jayathilake
 */
public class ServiceVehicleTypeMapper implements RowMapper <VehicleServiceType>{
    public VehicleServiceType mapRow(ResultSet rs, int rowNum) throws SQLException {
        VehicleServiceType vehicleType = new VehicleServiceType(rs.getString("vehicleName"), rs.getString("serviceId") ,rs.getInt("duration"),rs.getDouble("cost"));
        System.out.println("ssssssssssssssssssssssssss");
        return vehicleType;
    }
}
