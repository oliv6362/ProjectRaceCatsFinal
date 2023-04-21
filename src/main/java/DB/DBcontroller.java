package DB;

import Entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DBcontroller {


    public Connection connection;
    private Statement stmt;

    DBcontroller() {
        connection = null;
        stmt = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/RaceKatte", "root2", "1234");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //TODO - Users
    public void addUser(User u) {
        try {
            String sql = "INSERT INTO User (fNavn,lNavn,email,password,phoneNumber) VALUES('" //ret til database table navne
                    + String.valueOf(u.getfName()) + "','" + u.getlName() + "','";
            sql = sql + u.getEmail() + "','" + u.getPassword() + "','" + u.getPhoneNumber() + "')";

            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            System.out.println("Connection to MySQL has been established. \n");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public User getUser(int Id) {
        try {
            User u = new User();

            String sql = "SELECT * FROM User where userId = '" + Id + "'" ;
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                u.setUserID(rs.getInt("userID"));       //ID
                u.setfName(rs.getString("fNavn"));      //fnavn
                u.setlName(rs.getString("lNavn"));      //enavn
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setPhoneNumber(rs.getInt("phoneNumber"));
            }
            return u;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList<User> getAllUser() {
        try {
            String sql = "SELECT * FROM User ";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            ArrayList<User> userListe = new ArrayList<>();
            while (rs.next()) {
                {
                    User u = new User(
                            rs.getInt("userID"),      //ID
                            rs.getString("fNavn"),      //fnavn
                            rs.getString("lNavn"),      //enavn//postnr
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getInt("phoneNumber"));
                    userListe.add(u);
                }
            }
            return userListe;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int editUser() {

        return 0;
    }


    /*
                                rs.getInt("userID"),      //ID
                            rs.getString("fNavn"),      //fnavn
                            rs.getString("lNavn"),      //enavn//postnr
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getInt("phoneNumber"),
     */


}