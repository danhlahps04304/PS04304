/*
 * Le An Hoang Danh 
 * PS 04304
 * PT 11302
 */
package Model;

import Bean.User;
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
public class UserModel {
    
    public UserModel(){}
    
    public boolean checkLogin(String Username, String Password) {
        try{
        PreparedStatement stm=null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url="jdbc:sqlserver://localhost:1433;databaseName=Personel";
        Connection con = DriverManager.getConnection(url, "sa", "123");
        String sql="select * from Users where Username=? and Password=?";
        stm = con.prepareStatement(sql);
        stm.setString(1, Username);
        stm.setString(2, Password);
        ResultSet rs=stm.executeQuery();
        boolean exist=false;
        exist=rs.next();
        rs.close();
        stm.close();
        con.close();
        if(exist){
            return true;
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        return  false;
    }
    
    public static List<User> showUser(String tentk){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = " select * from Users";
            if (tentk.length() > 0){
                sql += "where Username like '%"+tentk+"%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<User> list = new ArrayList<User>();
            while (rs.next()){
                String Username = rs.getString("Username");
                String Password = rs.getString("Password");
                String Fullname = rs.getString ("Fullname");
                User tk = new User(Username,Password,Fullname);
                list.add(tk);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
    
        }
     return null;
    }
    
    public static void insert(User user){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "insert into Users values(?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, user.getUsername());
            stm.setString(2, user.getPassword());
            stm.setString(3, user.getFullname());
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void update(User user){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "update Users set Password=?, Fullname=? where Username=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, user.getPassword());
            stm.setString(2, user.getFullname());
            stm.setString(3, user.getUsername());
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void delete(String Username){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = "delete from Users where Username=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, Username);
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
