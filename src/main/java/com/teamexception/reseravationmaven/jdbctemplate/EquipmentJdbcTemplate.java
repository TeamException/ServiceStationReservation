/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamexception.reseravationmaven.jdbctemplate;

import com.teamexception.reseravationmaven.dao.EquipmentDAO;
import com.teamexception.reseravationmaven.mapper.EquipmentMapper;
import com.teamexception.reseravationmaven.model.Equipment;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Tharindu Jayathilake
 */
public class EquipmentJdbcTemplate implements EquipmentDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean addEquipment(Equipment equipment) throws ClassNotFoundException, SQLException {
        String sql = "Insert into Equipment values ( ? , ? , ? , ? , ? ,? ,?)";
        return (jdbcTemplateObject.update(sql, equipment.getEquipmentId(), equipment.getFacilitatorId(), equipment.getEquipmentName(), equipment.getEquipmentDescription(), equipment.getManufacturer(), equipment.getQoh(), equipment.getPurchasedDate())) > 0;
    }

    @Override
    public String getLastId() throws ClassNotFoundException, SQLException {
        String sql = "select * from Equipment order by 1 desc limit 1";
        Equipment e ;
        try {
            e = jdbcTemplateObject.queryForObject(sql, new EquipmentMapper());
            return e.getEquipmentId();
        } catch (EmptyResultDataAccessException ex) {
            return "E0000000000";
        }
    }

    @Override
    public boolean updateEquipment(Equipment equipment) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE Equipment SET equipmentName= ? ,equipmentDescription= ? ,manufacturer= ?,qoh= ? ,purchasedDate= ? WHERE equipmentId = ?";
        return (jdbcTemplateObject.update(sql, equipment.getEquipmentName(), equipment.getEquipmentDescription(), equipment.getManufacturer(), equipment.getQoh(), equipment.getPurchasedDate(), equipment.getEquipmentId())) > 0;
    }

    @Override
    public ArrayList<Equipment> getAllEquipments(String facilitatorId) throws ClassNotFoundException, SQLException {
        String sql = "select * from Equipment where facilitatorId='" + facilitatorId + "'";
        return (ArrayList<Equipment>) jdbcTemplateObject.query(sql, new EquipmentMapper());
    }

    @Override
    public Equipment searchEquipmentById(String equipmentId) throws ClassNotFoundException, SQLException {
        String sql = "select * from Equipment where equipmentId = '" + equipmentId + "'";
        return jdbcTemplateObject.queryForObject(sql, new EquipmentMapper());
    }

    @Override
    public boolean deleteEquipment(String equipmentId) throws SQLException, ClassNotFoundException {
        String sql = "Delete from Equipment Where equipmentId='" + equipmentId + "'";
        return (jdbcTemplateObject.update(sql) > 0);
    }
}
