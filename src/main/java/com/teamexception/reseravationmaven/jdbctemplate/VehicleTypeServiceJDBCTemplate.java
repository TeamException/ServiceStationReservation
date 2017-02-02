/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamexception.reseravationmaven.jdbctemplate;

import com.teamexception.reseravationmaven.dao.VehicleTypeServiceDAO;
import com.teamexception.reseravationmaven.mapper.ServiceVehicleTypeMapper;
import com.teamexception.reseravationmaven.model.VehicleServiceType;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Tharindu Jayathilake
 */
public class VehicleTypeServiceJDBCTemplate implements VehicleTypeServiceDAO{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    
    @Override
    public boolean addServiceVehilceType(VehicleServiceType svt) throws SQLException, ClassNotFoundException {
        String sql = "Insert into ServiceVehicleType values ( ? , ? , ? , ?)";
        System.out.println(svt.getTypeId());
        System.out.println(svt.getServiceId());
        return (jdbcTemplateObject.update(sql, svt.getTypeId(), svt.getServiceId(), svt.getDuration(), svt.getCost())) > 0;
    }

    @Override
    public boolean updateService(VehicleServiceType svt) throws ClassNotFoundException, SQLException {
        String sql1 = "update ServiceVehicleType set typeId= ? ,duration= ?,cost=? WHERE serviceId = ?";
        return (jdbcTemplateObject.update(sql1, svt.getTypeId(),svt.getDuration(),svt.getCost(),svt.getServiceId())) > 0;
    }

    @Override
    public ArrayList<VehicleServiceType> getAllVehicleTypeId(String serviceId) throws ClassNotFoundException, SQLException {
        String sql = "select * from ServiceVehicleType s, VehicleType v where (s.serviceId='" + serviceId + "') && (v.typeId=s.typeId)";
        return (ArrayList<VehicleServiceType>) jdbcTemplateObject.query(sql, new ServiceVehicleTypeMapper());
    }

    @Override
    public VehicleServiceType searchByVehicleTypeId(String serviceId, String typeId) throws ClassNotFoundException, SQLException {
        String sql = "select * from ServiceVehicleType where (typeId = '" + typeId + "')&&(serviceId='"+serviceId+"')";
        VehicleServiceType type;
        try {
            type = jdbcTemplateObject.queryForObject(sql, new ServiceVehicleTypeMapper());
            return type;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public boolean deleteVehicleTypeId(String serviceId,String typeId) throws ClassNotFoundException, SQLException {
        String sql = "Delete from ServiceVehicleType Where (typeId = '" + typeId + "')&&(serviceId='"+serviceId+"')";
        return (jdbcTemplateObject.update(sql) > 0);
    }
}
