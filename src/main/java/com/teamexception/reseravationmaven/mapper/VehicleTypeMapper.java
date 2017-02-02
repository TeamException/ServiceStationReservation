/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamexception.reseravationmaven.mapper;

import com.teamexception.reseravationmaven.model.VehicleType;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Tharindu Jayathilake
 */
public class VehicleTypeMapper implements RowMapper <VehicleType> {

    @Override
    public VehicleType mapRow(ResultSet rs, int row) throws SQLException {
        VehicleType type = new VehicleType(rs.getString("typeId"), rs.getString("vehicleName"));
        return type;
    }
}
