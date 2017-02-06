package de.breitenbach;

import java.sql.*;

class BPDatabase
{

    static void insertBP(BPData bp)
    {
        try
        {

            Connection con = DriverManager.getConnection
                    ("jdbc:mariadb://localhost:3306/ehealth", "ehealth", "mar44br89");
            PreparedStatement psInsertBP = con.prepareStatement(
                    "INSERT INTO `blutdruck` (`User-ID`, `Timestamp`, `Systole`,`Diastole`, `Puls`) VALUES (?, FROM_UNIXTIME(?), ?, ?,?);");
            psInsertBP.setInt(1, 3);
            psInsertBP.setLong(2, bp.getMDate());
            psInsertBP.setInt(3, bp.getHP());
            psInsertBP.setInt(4, bp.getLP());
            psInsertBP.setInt(5, bp.getHR());
            psInsertBP.execute();

            con.close();
        } catch (SQLException e)
        {
            System.err.println("Fehler beim Einfügen in die Datenbank!");
            e.printStackTrace();
        }
    }
    static void exportBP()
    {
        try
        {
            Connection con = DriverManager.getConnection
                    ("jdbc:mariadb://localhost:3306/ehealth", "ehealth", "mar44br89");
            Connection con_export = DriverManager.getConnection
                    ("jdbc:mariadb://localhost:3306/ehealth2", "ehealth", "mar44br89");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT `ID`, `User-ID`, `Timestamp`, `Systole`, " +
                    "`Diastole`, `Puls` from `blutdruck`");

            PreparedStatement psInsertBP = con_export.prepareStatement(
                    "INSERT INTO `blutdruck` (`ID`,`User-ID`, `Timestamp`, `Systole`,`Diastole`, `Puls`) VALUES (?, " +
                            "?, ?, ?, ?, ?);");

            while(rs.next())
            {
                psInsertBP.setInt(1, rs.getInt(1));
                psInsertBP.setString(2,rs.getString(2));
                psInsertBP.setDate(3, rs.getDate(3));
                psInsertBP.setInt(4, rs.getInt(4));
                psInsertBP.setInt(5, rs.getInt(5));
                psInsertBP.setInt(6, rs.getInt(6));
                psInsertBP.execute();
            }
            con.close();
            con_export.close();
        } catch (SQLException e)
        {
            System.err.println("Fehler beim Einfügen in die Datenbank!");
            e.printStackTrace();
        }
    }

    static String[][] selectBP()
    {
        String table[][] = null;
        try
        {
            Connection con = DriverManager.getConnection
                    ("jdbc:mariadb://localhost:3306/ehealth", "ehealth", "mar44br89");
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT `blutdruck`.`ID`, `user`.`Nickname`, `Timestamp`, `Systole`, " +
                    "`Diastole`, `Puls` FROM `blutdruck` JOIN `user` ON `blutdruck`.`User-ID` = `user`.`id`");

            rs.last();
            int count = rs.getRow();
            rs.beforeFirst();
            table = new String[count][6];
            for (int i = 0; i < count; i++)
            {
                rs.next();
                table[i][0] = rs.getString(1);
                table[i][1] = rs.getString(2);
                table[i][2] = rs.getString(3);
                table[i][3] = rs.getString(4);
                table[i][4] = rs.getString(5);
                table[i][5] = rs.getString(6);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return table;
    }
}
