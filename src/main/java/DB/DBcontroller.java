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

    //TODO - Users - done
    public void addUser(User u) {
        try {
            String sql = "'INSERT INTO user (fName,lName,email,password,phoneNumber) VALUES('" //ret til database table name
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
    //todo hvad fuck mener programmet med SQL Dialect og hvordan korigere vi det ?
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
    //todo edit user - ikke done!
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

    //todo slette user - ikke helt done! mangler ui
    public static void deleteUser(int userID) {

        String url = "jdbc:mysql://localhost:3306/RaceKatte";
        String user = "root2";
        String password = "1234";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement("DELETE * FROM user, pet WHERE owner = '" + userID + "'");
            pstmt.execute();

            System.out.println("User Deleted");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //TODO - Kæledyr -done
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
    //todo getAllPets -done
    public ArrayList<User> getAllPets() {
        try {
            String sql = "select * from user where userid '" +"'";

            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            ArrayList<User> userListe = new ArrayList<>();
            while (rs.next()) {
                {
                    User u = new User(
                            rs.getInt("petID"),      //ID
                            rs.getString("name"),      //
                            rs.getString("owner"),
                            rs.getString("sex"),
                            rs.getString("chipNumber"),
                            rs.getInt("petPedigreeNumber"));
                    userListe.add(u);
                }
            }
            return userListe;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //todo getPet2 virker den?
    public Pet getPet2(Pet pet){
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

    //todo slette kæledyr
    public static void deletePet(int petID) {

        String url = "jdbc:mysql://localhost:3306/RaceKatte";
        String user = "root2";
        String password = "1234";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement("DELETE * FROM user WHERE petID = '" + petID + "'");
            pstmt.execute();

            System.out.println("Pet Deleted");
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


    //todo snakke med Lærer mikel om info pass direkte til UI eller igennem Controller laget ?(CLean architecture) -a ok send den igennem lag
    // til senere javadocs: metode henter delvis user info, sendes til ?,11 efter redigereing retuneres til DB.
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
    //todo bare lige så vi kan kører programmet

    //todo SLET ALT HERUNDER SNART!!!!
/*
    public Pet getPet(Pet pet){
        String sql = "select * from user where userid '" + pet.getPetID() + "'";
        //String query = "select * from user where userid 'user' "; explanation for Sofia
        try {

            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            //todo skal ikke ligge her
            ArrayList<Pet> pets;
            pet = db.getPets();
            for (int i = 0; i < pets.size(); i++) {
                System.out.println(pets.get(i));
                // todo ^ryk mig
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

*/
    //TODO - Udstilling

    //todo slet udkommenteret når done
/*
 ville være noget i retningen af
 ArrayList <User> table = new Arraylist<>();
  String sql = "select fName, lName, phoneNumber from User where UserID = '" id "'" +
  Statement stmt=connection.createStatement();
  ResultSet rs = stmt.executeQuery(sql);
  while(rs.next()) {
  User user=new User();
                setUserFname(rs.getString("Fname"));
                user.setLnavn(rs.getString("Lnavn"));
                user.setphoneNumber(rs.getString("setphoneNumber"));

    public void nullclear
    for (User : user<i>)
    if user.Fname = null

                tabel.add(user);
  //ville nok ændre det til en simpel sout uden while løkke hvis i kun søger på 1 id
  //løkken gir kun mening hvis i kan søge på flere id's
            }

 */
//todo redigere info fra track&trace, bruger update?
/*
 //public String updateUser(int userID, String nyLokation) {
        String pakke = "";
        try {
            String sql = "UPDATE Pakke SET lokation = '" + nyLokation + "'" + "WHERE userID = '" + UserID + "'" ;
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            sql = "SELECT lokation FROM Pakke WHERE userID = '" + userID + "'";
            stmt.execute(sql);

            ResultSet rs = stmt.getResultSet();

            if (rs.next()) {
                pakke = rs.getString("lokation");
            }

            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return pakke;
    }
}*/

    //todo fra frisør salon

    /*    public int redigerBehandlingsType(int bestillingsId, int nyBehandlingsType) {
         int bestillingId = 0;

        try {
            String sql = "UPDATE Bestilling SET behandlingsType = '" + nyBehandlingsType + "'" + "WHERE bestillingId = '" + bestillingsId + "'" ;
            Statement stmt = connection.createStatement();
            stmt.execute(sql);

            sql = "SELECT behandlingsType FROM Bestilling WHERE bestillingId = '" + bestillingsId + "'";
            stmt.execute(sql);

            ResultSet rs = stmt.getResultSet();

            if (rs.next()) {
                bestillingId = rs.getInt("behandlingsType");
            }

            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bestillingId;
    }


        public User getUserID(int Id) {
            try {
                User u = new User();

                String sql = "SELECT * FROM User where userId = '" + Id + "'" ;
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
        }*/
}