/*
 * Le An Hoang Danh 
 * PS 04304
 * PT 11302
 */
package Model;

import Bean.Record;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author L.A.H.D
 */
public class RecordModel {
    public static List<Record> showRecord(String record){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123");
            String sql = " select * from Records";
            if (record.length() > 0){
                sql += "where Id like '%"+record+"%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<Record> list = new ArrayList<Record>();
            while (rs.next()){
                String ID = rs.getString("Id");
                int Name = rs.getInt("Type");;
                String Reason = rs.getString ("Reason");
                String Date = rs.getString ("Date");
                String StaffId = rs.getString ("StaffId");
                Record records = new Record (ID, Name, Reason, Date, StaffId);
                list.add(records);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
    
        }
     return null;
    }
}
