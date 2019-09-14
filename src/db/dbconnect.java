/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class dbconnect  {
    private static final String USERNAME ="root";
    private static final String PASSWORD="";
    private static final String HOST="";
    private static final int PORT=3306;
    private static final String DB_NAME="login";
    public static Connection connex;
    
    static{
        try{
            connex=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DB_NAME+"?zeroDate TimeBehavior=convertToNull",USERNAME,PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static int checklogin(String username ,String password){
        Connection connex=dbconnect.connex;
        if(connex==null)
            return -1;
            String sql="SELECT * FROM admin WHERE username =? AND password =? ";
            try{
                PreparedStatement stet=connex.prepareStatement(sql);
                stet.setString(1, username);
                stet.setString(2, password);
                ResultSet rs=stet.executeQuery();
                
                      while(rs.next()){
                          return 0;
                      }
                    
            }catch(SQLException se){
               se.printStackTrace(); 
            }
            
          return 1;
    }}
    
   

