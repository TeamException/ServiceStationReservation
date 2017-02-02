/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamexception.reseravationmaven.mapper;

import com.teamexception.reseravationmaven.model.Equipment;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Tharindu Jayathilake
 */
public class EquipmentMapper implements RowMapper<Equipment> {

    @Override
    public Equipment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Equipment equipment = new Equipment();
        equipment.setEquipmentId(rs.getString("equipmentId"));
        equipment.setFacilitatorId(rs.getString("facilitatorId"));
        equipment.setEquipmentName(rs.getString("equipmentName"));
        equipment.setEquipmentDescription(rs.getString("equipmentDescription"));
        equipment.setManufacturer(rs.getString("manufacturer"));
        equipment.setQoh(rs.getInt("qoh"));
        equipment.setPurchasedDate(rs.getString("purchasedDate"));
        return equipment;
    }

}
