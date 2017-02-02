/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamexception.reseravationmaven.mapper;

import com.teamexception.reseravationmaven.model.PredefinedServices;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Tharindu Jayathilake
 */
public class PredefinedServiceTypeMapper implements RowMapper <PredefinedServices> {
    
    @Override
    public PredefinedServices mapRow(ResultSet rs, int rowNum) throws SQLException {
        PredefinedServices services = new PredefinedServices(rs.getString("serviceId"), rs.getString("vehicleName") ,rs.getString("serviceName"),rs.getString("description"));
        return services;
    }
}
