package de.breitenbach;

import java.sql.*;

class iHealthBloodPressureToDB
{

    static void insertBP(iHealthBloodPressureData bp)
    {
       Connection con;
        try
        {
            con = DriverManager.getConnection
                    ("jdbc:mariadb://localhost:3306/ehealth", "root", "mar44br89");
            PreparedStatement psInsertBP = con.prepareStatement(
                    "INSERT INTO `blutdruck` (`User-ID`, `Timestamp`, `Systole`,`Diastole`, `Puls`) VALUES (?, FROM_UNIXTIME(?), ?, ?,?);");
            psInsertBP.setInt(1, 3);
            psInsertBP.setLong(2, bp.getMDate());
            psInsertBP.setInt(3, bp.getHP());
            psInsertBP.setInt(4, bp.getLP());
            psInsertBP.setInt(5, bp.getHR());
            psInsertBP.execute();

        } catch (SQLException e)
        {
            System.err.println("Fehler beim Einfügen in die Datenbank!");
            e.printStackTrace();
        }

        con = null;


    }

    static String[][] selectBP()
    {
        String table[][] = null;
        try
        {
            Connection con = DriverManager.getConnection
                    ("jdbc:mariadb://localhost:3306/ehealth", "root", "mar44br89");
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
