package de.breitenbach; 
 
import java.sql.*;
 
/** 
 * Created by nerix on 29.01.17. 
 */ 
class iHealthWeightToDB 
{ 
    static void insertWeight (iHealthWeightData weight) 
    { 
        try 
        { 
            Connection con = DriverManager.getConnection 
                    ("jdbc:mariadb://localhost:3306/ehealth", "root", "mar44br89"); 
            PreparedStatement psInsertWeight = con.prepareStatement( 
                    "INSERT INTO `waage` (`User-ID`, `Zeitstempel`, `Gewicht`, `BMI`) VALUES (?, FROM_UNIXTIME(?), " + 
                            "?, ?);"); 
            psInsertWeight.setInt(1,3); 
            psInsertWeight.setLong(2,weight.getMDate()); 
            psInsertWeight.setFloat(3,weight.getWeightValue()); 
            psInsertWeight.setFloat(4, weight.getBMI()); 
            psInsertWeight.execute(); 
 
        } catch (SQLException e) 
        { 
            e.printStackTrace(); 
        } 
 
    } 
    static void selectWeight() 
    { 
        try 
        { 
            Connection con = DriverManager.getConnection 
                    ("jdbc:mariadb://localhost:3306/ehealth", "root", "mar44br89"); 
            Statement stmt = con.createStatement(); 
            ResultSet rs = stmt.executeQuery("SELECT `waage`.`ID`, `user`.`Nickname`, `Zeitstempel`, `waage`.`Gewicht`, " + 
                    "`BMI` FROM `waage` join `user` on `waage`.`User-ID` = `user`.`id`"); 
 
            while (rs.next()) 
            { 
                System.out.printf( "ID: %s; User: %s; Timestamp: %s; Gewicht: %s; BMI: %s\n", 
                        rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)); 
 
            } 
            rs.close(); 
            stmt.close(); 
 
 
        } catch (SQLException e) 
        { 
            e.printStackTrace(); 
        } 
    } 
} 