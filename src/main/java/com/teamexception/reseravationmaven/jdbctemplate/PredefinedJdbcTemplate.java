/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamexception.reseravationmaven.jdbctemplate;

import com.teamexception.reseravationmaven.dao.PredefinedServicesDAO;
import com.teamexception.reseravationmaven.mapper.PredefinedServicesMapper;
import com.teamexception.reseravationmaven.model.PredefinedServices;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Tharindu Jayathilake
 */
public class PredefinedJdbcTemplate implements PredefinedServicesDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean addService(PredefinedServices services) throws SQLException, ClassNotFoundException {
        String sql = "Insert into PredefinedServices values ( ? , ? , ? , ?)";
        return (jdbcTemplateObject.update(sql, services.getServiceId(), services.getFacilitatorId(), services.getServiceName(), services.getDescription())) > 0;
    }
    

    @Override
    public String getLastId() throws SQLException, ClassNotFoundException {
        String sql = "select * from PredefinedServices order by 1 desc limit 1";
        PredefinedServices services;
        try {
            services = jdbcTemplateObject.queryForObject(sql, new PredefinedServicesMapper());
            return services.getServiceId();
        } catch (EmptyResultDataAccessException ex) {
            return "S000000000";
        }
    }

    @Override
    public boolean updateService(PredefinedServices services) throws ClassNotFoundException, SQLException {
        String sql1 = "update PredefinedServices SET serviceName= ? ,description= ? WHERE serviceId = ?";
        return (jdbcTemplateObject.update(sql1, services.getServiceName(), services.getDescription(), services.getServiceId())) > 0;
    }

    @Override
    public ArrayList<PredefinedServices> getAllServices(String facilitatorId) throws ClassNotFoundException, SQLException {
        String sql = "select * from PredefinedServices where (facilitatorId='" + facilitatorId + "')";
        return (ArrayList<PredefinedServices>) jdbcTemplateObject.query(sql, new PredefinedServicesMapper());
    }

    @Override
    public PredefinedServices searchByServiceTypeId(String serviceId , String typeId) throws ClassNotFoundException, SQLException {
        String sql = "select * from PredefinedServices where ((serviceId = '" + serviceId + ") && (typeId='"+typeId+"'))'";
        return jdbcTemplateObject.queryForObject(sql, new PredefinedServicesMapper());
    }

    @Override
    public boolean deleteService(String serviceId) throws ClassNotFoundException, SQLException {
        String sql = "Delete from PredefinedServices Where serviceId='" + serviceId + "'";
        return (jdbcTemplateObject.update(sql) > 0);
    }

    @Override
    public boolean isServicesExists(String serviceName,String facilitatorId) throws ClassNotFoundException, SQLException {
        String sql = "select * from PredefinedServices where (serviceName = '" + serviceName + "')&& (facilitatorId='"+facilitatorId+"')";
        PredefinedServices services;
        try {
            services = jdbcTemplateObject.queryForObject(sql, new PredefinedServicesMapper());
            return true;
        } catch (EmptyResultDataAccessException ex) {
            return false;
        }
    }

    @Override
    public PredefinedServices searchByServiceTypeId(String serviceId) throws ClassNotFoundException, SQLException {
        String sql = "select * from PredefinedServices where (serviceId = '" + serviceId + "')";
        return jdbcTemplateObject.queryForObject(sql, new PredefinedServicesMapper());
    }

}
