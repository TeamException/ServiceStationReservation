/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamexception.reseravationmaven.connection;

/**
 *
 * @author Nimesha
 */
public class DBFactory {
    public static DBConnection getConnection(){
        return new DBConnectionImpl();
    }
}
