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
    static String[][] selectWeight()
    {
        String table[][] = null;
        try
        {
            Connection con = DriverManager.getConnection
                    ("jdbc:mariadb://localhost:3306/ehealth", "root", "mar44br89");
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

                System.out.printf( "ID: %s; User: %s; Timestamp: %s; Gewicht: %s; BMI: %s\n",
                        table[i][0], table[i][1], table[i][2], table[i][3], table[i][4]);

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