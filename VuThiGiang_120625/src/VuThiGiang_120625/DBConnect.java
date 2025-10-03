/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package VuThiGiang_120625;
import java.sql.*; 
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {

    public static Connection getDBConnect() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/QLThuvien","root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
