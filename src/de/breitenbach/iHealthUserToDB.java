package de.breitenbach;

import java.sql.*;

/**
 * Created by nerix on 29.01.17.
 */
public class iHealthUserToDB
{
    static PreparedStatement psInsertUser = null;
    //Connection connection = null;


    /**public void connectDB()
    {
        try
        {
            connection = DriverManager.getConnection
                    ("jdbc:mariadb://localhost:3306/ehealth", "root", "mar44br89");

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }**/


    public static void insertUser (iHealthUserData user)
    {
            int gender;
        try
        {
            Connection con = DriverManager.getConnection
                    ("jdbc:mariadb://localhost:3306/ehealth", "root", "mar44br89");
            psInsertUser = con.prepareStatement(
                    "INSERT INTO `user` (`Nickname`, `Gender`, `Groesse`, `Gewicht`, `GebDat`, `iHealthID`) VALUES (?, ?, ?, ?, FROM_UNIXTIME(?), ?); ");
            psInsertUser.setString(1,user.nickname);
            if (user.gender.equals("Male"))
            {
                gender = 0;
            } else
            {
                gender = 1;
            }
            psInsertUser.setInt(2,gender);
            psInsertUser.setInt(3,user.height);
            psInsertUser.setInt(4,user.weight);
            psInsertUser.setLong(5,user.dateofbirth);
            psInsertUser.setString(6, user.userid);
            psInsertUser.execute();

        } catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
    public static void selectUser()
    {
        try
        {
            Connection con = DriverManager.getConnection
                    ("jdbc:mariadb://localhost:3306/ehealth", "root", "mar44br89");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from user");

            while (rs.next())
            {
                System.out.printf( "ID: %s; Nickname: %s; Gender: %s; Größe: %s; Gewicht: %s; Geburtsdatum: %s; " +
                                " iHealth-User-ID: %s\n", rs.getString(1),
                        rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs
                                .getString(7) );

            }
            rs.close();
            stmt.close();


        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
