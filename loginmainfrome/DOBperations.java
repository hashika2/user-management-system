/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginmainfrome;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
//import java.sql.*;
/**
 *
 * @author Hashika maduranga
 */
public class DOBperations {
    String url="jdbc:mysql://localhost:3306/employee";
    String username="root";
    String password="";
    Connection con=null;
    PreparedStatement pst=null;
    final String jdbc = "com.mysql.jdbc.Driver";
    Statement state = null;
    ResultSet rs=null;
    
    boolean addemployee(Employeedetails em){
        try{
            con=(Connection)DriverManager.getConnection(url, username,password);//get the connection
            state = con.createStatement();
            String query="INSERT INTO employee_details VALUES (?,?,?,?,?,?,?,?)";
            pst=(PreparedStatement)con.prepareStatement(query);
            
            pst.setInt(1,em.getRegID());// add values to the sql query
            pst.setString(2,em.getFirstname());// add values to the sql query
            pst.setString(3,em.getLastname());// add values to the sql query
            pst.setInt(4,em.getAge());// add values to the sql query
            pst.setString(5,em.getCountryname());// add values to the sql query
            pst.setString(6,em.getEmail());// add values to the sql query
            pst.setString(7,em.getUsername());// add values to the sql query
            pst.setString(8,em.getPassword());// add values to the sql query
            
            pst.executeUpdate();//execute sql query and insert the values to the db tables
             return true;
        }catch(Exception e){
            System.out.println("FOUND EXCEPTION"+e);
            return false;
    }finally{
            
            try{
                if(pst!=null){
                    pst.close();
                }
                if(con !=null){
                    con.close();
                }
            }catch(Exception e){
                
            }
        }
    
}
    int checkUsername(String username){
        try{
      con=(Connection)DriverManager.getConnection(url, username,password);//get the connection   
      String query="SELECT usename FROM emplyee_details";
      pst=(PreparedStatement)con.prepareStatement(query);
     rs= pst.executeQuery();
     while(rs.next()){
         if(username.equals(rs.getString(1))){
             return 0;//the usernsme provided already exist in the db
         }
         
     }
     return 1;//the usernsme does not  exist in the db
        }catch(Exception e){
            System.out.println(e);
            return 2;
        }
        finally{
            
            try{
                if(pst!=null){
                    pst.close();
                }
                if(con !=null){
                    con.close();
                }
            }catch(Exception e){
                
            }
        }
        }
        
}
