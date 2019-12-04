/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqldatabase;


import java.sql.*; 
/**
 *
 * @author czm355
 */
public class SQLDatabase {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {

        try {
            
                     Connection dbConnection = 
                          
                             DriverManager.getConnection("jdbc:sqlite:sample.sqlite3", "app", "app");
                     
                     Statement stmt = dbConnection.createStatement();
                     String testQuery = "SELECT * FROM CUSTOMER";
                   
                     ResultSet results; 
                     
                     results = stmt.executeQuery(testQuery);
                     
             while (results.next()) {
             System.out.println("Result: " + results.getString("NAME"));
            }
               
             //Closes
            results.close(); 
            stmt.close(); 
            dbConnection.close(); 
                     
        }catch (SQLException e) {System.out.println("Cannot connect to database.\n" + e.getMessage());
       
          
        }
     }
}
