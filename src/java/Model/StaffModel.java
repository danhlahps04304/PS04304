/*
 * Le An Hoang Danh 
 * PS 04304
 * PT 11302
 */
package Model;

import Bean.Staff;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author L.A.H.D
 */
public class StaffModel {
    public static List<Staff> showStaff(String staff){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = " select * from Staffs";
            if (staff.length() > 0){
                sql += "where Id like '%"+staff+"%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<Staff> list = new ArrayList<Staff>();
            while (rs.next()){
                String ID = rs.getString("Id");
                String Name = rs.getString("Name");
                boolean Gender = rs.getBoolean("Gender");
                String Date = rs.getString ("Birthday");
                String Photo = rs.getString ("Photo");
                String Email = rs.getString ("Email");
                String Phone = rs.getString ("Phone");
                float Salary = rs.getFloat ("Salary");
                String Note = rs.getString ("Notes");
                String DepartId = rs.getString ("DepartId");
                Staff staffs = new Staff(ID, Name, Gender, Date, Photo, Email, Phone, Salary, Note, DepartId);
                list.add(staffs);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
    
        }
     return null;
    }
    
    public static void delete(String Id){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "delete from Staffs where Id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, Id);
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
        
         public static void insert(Staff staff){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "insert into Staffs values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, staff.getID());
            stm.setString(2, staff.getName());
            stm.setBoolean(3, false);
            stm.setString(4, staff.getDate());
            stm.setString(5, staff.getPhoto());
            stm.setString(6, staff.getEmail());
            stm.setString(7, staff.getPhone());
            stm.setFloat(8, staff.getSalary());
            stm.setString(9, staff.getNote());
            stm.setString(10, staff.getDepartId());
            
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
         
         public static void update(Staff staff){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "update Staffs set Name=?, Gender=?, Birthday=?, Photo=?,Email=?, Phone=?, Salary=?, Notes=?,DepartId=? where Id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            
            stm.setString(1, staff.getID());
            stm.setString(2, staff.getName());
            stm.setBoolean(3, true);
            stm.setBoolean(3, false);
            stm.setString(4, staff.getDate());
            stm.setString(5, staff.getPhoto());
            stm.setString(6, staff.getEmail());
            stm.setString(7, staff.getPhone());
            stm.setDouble(8, staff.getSalary());
            stm.setString(9, staff.getNote());
            stm.setString(10, staff.getDepartId());
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
