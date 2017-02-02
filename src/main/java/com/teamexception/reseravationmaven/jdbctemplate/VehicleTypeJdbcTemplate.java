/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamexception.reseravationmaven.jdbctemplate;

import com.teamexception.reseravationmaven.dao.VehicleTypeDAO;
import com.teamexception.reseravationmaven.mapper.VehicleTypeMapper;
import com.teamexception.reseravationmaven.model.VehicleType;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Tharindu Jayathilake
 */
public class VehicleTypeJdbcTemplate implements VehicleTypeDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean addVehilceType(VehicleType type) throws ClassNotFoundException, SQLException {
        String sql = "Insert into VehicleType values ( ? , ?)";
        return (jdbcTemplateObject.update(sql, type.getTypeId(), type.getVehicleName())) > 0;
    }

    @Override
    public String getLastId() throws SQLException, ClassNotFoundException {
        String sql = "select * from VehicleType order by 1 desc limit 1";
        VehicleType type;
        try {
            type = jdbcTemplateObject.queryForObject(sql, new VehicleTypeMapper());
            return type.getTypeId();
        } catch (EmptyResultDataAccessException ex) {
            return "T0000000000";
        }
    }

    @Override
    public ArrayList<VehicleType> getAllVehilcesTypes() throws ClassNotFoundException, SQLException {
        String sql = "select * from VehicleType";
        System.out.println(jdbcTemplateObject  + "  "+ new VehicleTypeMapper());
        return (ArrayList<VehicleType>) jdbcTemplateObject.query(sql, new VehicleTypeMapper());
    }

    @Override
    public boolean isNameExists(String vehicleType) {
        String sql = "select * from VehicleType where vehicleName = '" + vehicleType + "' limit 1";
        VehicleType type;
        try {
            type = jdbcTemplateObject.queryForObject(sql, new VehicleTypeMapper());
            return true;
        } catch (EmptyResultDataAccessException ex) {
            return false;
        }
    }

    @Override
    public String getVehilceTypebyId(String vehicleName ) {
        String sql = "select * from VehicleType where vehicleName = '" + vehicleName + "'";
        VehicleType type;
        try {
            type = jdbcTemplateObject.queryForObject(sql, new VehicleTypeMapper());
            return type.getTypeId();
        } catch (EmptyResultDataAccessException ex) {
            return "";
        }
    }
    
}
