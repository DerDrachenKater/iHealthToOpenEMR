package de.breitenbach;

import java.sql.*;

/**
 * Created by nerix on 29.01.17. 
 */
class iHealthWeightDB
{
    static void insertWeight (iHealthWeightData weight)
    {
        try
        {
            Connection con = DriverManager.getConnection
                    ("jdbc:mariadb://localhost:3306/ehealth", "ehealth", "mar44br89");
            PreparedStatement psInsertWeight = con.prepareStatement(
                    "INSERT INTO `waage` (`User-ID`, `Zeitstempel`, `Gewicht`, `BMI`) VALUES (?, FROM_UNIXTIME(?), " +
                            "?, ?);");
            psInsertWeight.setInt(1,3);
            psInsertWeight.setLong(2,weight.getMDate());
            psInsertWeight.setFloat(3,weight.getWeightValue());
            psInsertWeight.setFloat(4, weight.getBMI());
            psInsertWeight.execute();

            con.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
    static void exportWWeight()
    {

        try
        {
            Connection con_export = DriverManager.getConnection
                    ("jdbc:mariadb://localhost:3306/ehealth2", "ehealth", "mar44br89");
            Connection con = DriverManager.getConnection
                    ("jdbc:mariadb://localhost:3306/ehealth", "ehealth", "mar44br89");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT `ID`,`User-ID`,  `Zeitstempel`,`Gewicht`,`BMI` FROM `waage`");

            PreparedStatement psInsertWeight = con_export.prepareStatement(
                    "INSERT INTO `waage` (`ID`,`User-ID`, `Zeitstempel`, `Gewicht`, `BMI`) VALUES (?, ?, ?, ?, ?);");
            while (rs.next())
            {
                psInsertWeight.setInt(1, rs.getInt(1));
                psInsertWeight.setInt(2, rs.getInt(2));
                psInsertWeight.setDate(3, rs.getDate(3));
                psInsertWeight.setFloat(4, rs.getFloat(4));
                psInsertWeight.setFloat(5, rs.getFloat(5));
                psInsertWeight.execute();
            }
            con.close();
            con_export.close();

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    static String[][] selectWeight()
    {
        String table[][] = null;
        try
        {
            Connection con = DriverManager.getConnection
                    ("jdbc:mariadb://localhost:3306/ehealth", "ehealth", "mar44br89");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT `waage`.`ID`, `user`.`Nickname`, `Zeitstempel`, `waage`.`Gewicht`, " +
                    "`BMI` FROM `waage` join `user` on `waage`.`User-ID` = `user`.`id`");

            rs.last();
            int count = rs.getRow();
            rs.beforeFirst();
            table = new String[count][5];
            for (int i = 0; i < count; i++)
            {
                rs.next();
                table[i][0] = rs.getString(1);
                table[i][1] = rs.getString(2);
                table[i][2] = rs.getString(3);
                table[i][3] = rs.getString(4);
                table[i][4] = rs.getString(5);
            }
            rs.close();
            stmt.close();

            con.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return table;
    }
} 