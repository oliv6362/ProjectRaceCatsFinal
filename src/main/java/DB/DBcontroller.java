package DB;

import Entity.User;
import Entity.Pet;
import Usecase.UseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DBcontroller {
    public Connection connection;
    private Statement stmt;

    public DBcontroller() {
        connection = null;
        stmt = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/RaceKatte", "root2", "1234");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addUser(User u) {
        try {
            String sql = "INSERT INTO user (fName,lName,email,password,phoneNumber) VALUES('" //ret til database table name
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

    public User getUser(User user){
        String sql = "select * from user where userid '" + user.getUserID() + "'";
        //String query = "select * from user where userid 'user' "; explanation for Sofia
        try {

            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();

            ;

            connection.close();
            return user;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<User> getAllUsers() {
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
                            rs.getString("fName"),      //
                            rs.getString("lName"),      ////postnr
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

    public void editUser(User user) {
        String sql = "Insert INTO user (fname,lname,email,password,phonenumber) " +
                "values ('" + user.getfName() + "','" + user.getlName()+"','" + user.getEmail()+"','" +
                user.getPassword()+"','" + user.getPhoneNumber()+"')";

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteUser(int userID) {

        String url = "jdbc:mysql://localhost:3306/RaceKatte";
        String user = "root2";
        String password = "1234";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement("DELETE * FROM user, pet WHERE owner = '" + userID + "'");
            pstmt.execute();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPet(Pet p) {
        try {
            String sql = "INSERT INTO pet (name,owner,sex,chipNumber,petPedigreeNumber) VALUES('" //ret til database table name
                    + String.valueOf(p.getName()) + "','" + p.getOwner() + "','";
            sql = sql + p.getSex() + "','" + p.getChipNumber() + "','" + p.getPetPedigreeNumber() + "')";

            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            System.out.println("Connection to MySQL has been established. \n");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Pet getPet(Pet pet){
        String sql = "select * from user where userid '" + pet.getPetID() + "'";
        //String query = "select * from user where userid 'user' "; explanation for Sofia
        try {

            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();

            pet.setName(rs.getString("name"));
            pet.setName(rs.getString("owner"));      //nøgle til userID
            pet.setName(rs.getString("sex"));
            pet.setName(rs.getString("chipNumber"));
            pet.setName(rs.getString("petPedigreeNumber"));

            connection.close();
            return pet;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //todo getAllPets - ikke done
   /* public ArrayList<Pet> getAllPets() {
        try {
            String sql = "select * from pet where petID '" +"'";

            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            ArrayList<Pet> petlist = new ArrayList<>();
            while (rs.next()) {
                {
                    Pet p = new Pet(
                            rs.getInt("petID"),      //ID
                            rs.getString("name"),      //
                            rs.getString("owner"),
                            rs.getString("sex"),
                            rs.getInt("chipNumber"),
                            rs.getInt("petPedigreeNumber"));
                    petlist.add(p);
                }
            }
            return petlist;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/

    public static void deletePet(int petID) {

        String url = "jdbc:mysql://localhost:3306/RaceKatte";
        String user = "root2";
        String password = "1234";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement("DELETE * FROM user WHERE petID = '" + petID + "'");
            pstmt.execute();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //TODO - TESTER LOGIN
    public User getUserPass(User u,String email, String password) {
        try {

            //String sql = "SELECT * FROM User where password = '" + password + "'" + " AND WHERE eMail = '" + eMail + "'";
            String sql = "SELECT * FROM User WHERE email = '" + email + "' AND password = '" + password + "'";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                u.setUserID(rs.getInt("userID"));       //ID
                u.setfName(rs.getString("fName"));      //
                u.setlName(rs.getString("lName"));      //
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setPhoneNumber(rs.getInt("phoneNumber"));
            }

            return u;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}