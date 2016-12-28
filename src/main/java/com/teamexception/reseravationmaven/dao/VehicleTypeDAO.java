/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamexception.reseravationmaven.dao;

import com.teamexception.reseravationmaven.connection.DBFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Tharindu Jayathilake
 */
public class VehicleTypeDAO {
    public static boolean addVehilceType(String typeId,String vehilceType) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        try {
            conn = DBFactory.getConnection().getDBConnection();
            conn.setAutoCommit(false);

            PreparedStatement stm = conn.prepareStatement("Insert into VehicleType values ( ? , ? )");
            stm.setObject(1, typeId);
            stm.setObject(2, vehilceType);
            boolean state = stm.executeUpdate() > 0;
            conn.commit();
            return state;
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            conn.close();
        }
    }
    public static String getLastId() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            conn = DBFactory.getConnection().getDBConnection();
            conn.setAutoCommit(false);

            String sql = "select typeId from VehicleType order by 1 desc limit 1";
            Statement stm = conn.createStatement();
            ResultSet rst = stm.executeQuery(sql);

            if (rst.next()) {
                conn.commit();
                return rst.getString("typeId");
                
            } else {

                conn.commit();
                return "T000000000";
            }

        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            conn.close();
        }
    }

}
