/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamexception.reseravationmaven.dao;

import com.teamexception.reseravationmaven.model.PredefinedServices;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tharindu Jayathilake
 */
@Service
public interface PredefinedServicesDAO {
    
    public boolean addService(PredefinedServices services) throws SQLException, ClassNotFoundException;
    
    public String getLastId() throws SQLException, ClassNotFoundException;
    
    public boolean updateService(PredefinedServices services) throws ClassNotFoundException, SQLException;

    public ArrayList<PredefinedServices> getAllServices(String facilitatorId) throws ClassNotFoundException, SQLException;;

    public PredefinedServices searchServiceById(String serviceId) throws ClassNotFoundException, SQLException;;

    public boolean deleteService(String serviceId) throws ClassNotFoundException, SQLException;
}
