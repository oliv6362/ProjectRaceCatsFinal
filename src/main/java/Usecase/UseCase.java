package Usecase;

import java.util.Scanner;
import DB.DBcontroller;
import Entity.Pet;
import Entity.User;
import UI.UIcontroller;
import java.util.ArrayList;

public class UseCase {
    DBcontroller db = new DBcontroller();


    //TODO Login

    public int login(String email, String password) {





        /*
        User hentetUser = db.getUserPass();

        if (.equals(hentetUser.getEmail()) && userPassword.equals(hentetUser.getPassword())) {
            System.out.print("Du er nu logget ind som: " );
            if (hentetUser.getIsMedarbejder() == 1) {
                System.out.println("kunde");
                accessType = 1;
            } else if (hentetUser.getIsMedarbejder() == 2) {
                System.out.println("medarbejder");
                accessType = 2;
            }

        } else {
            System.out.println("Email eller Password var ikke korrekt");
            accessType = 3;

        }
        return accessType;*/
        return 1;
    }


    //when pressing accout run this
    public User getUser(){

        return hentetUser;
    }
    public void editAccount(User user){
        db.editUser(user);
    }






    //TODO - Opret user - done
    public void buildUser(String fName, String lName, String email, String password, int phoneNumber){
        db.addUser(new User(fName, lName, email, password, phoneNumber));
    }


    // TODO - Rediger user

    // TODO - Slet user - db er klar
    //kalde DB controllers metode og aflevere userID. sammen for petID

    // TODO - Vis alle users (hentet fra frisaør - skriv om hvis nødvendigt)
    public void showUsers(){
        System.out.println("Hent alle users");
        ArrayList<User> userList;
        userList = db.getAllUsers();
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
        }
    }

    public Pet buildPet(int chipNo, int petPedigreeNo, String name, String owner, char sex){
        return new Pet(name, owner, sex, chipNo, petPedigreeNo);
    }

    // TODO - Rediger pet

    // TODO - Slet pet - db er klar
    //se SLette user

    // TODO - Vis alle pets (hentet fra frisaør - skriv om hvis nødvendigt)
    public void showPets(){
        System.out.println("Hent alle pets");
        ArrayList<User> petList;
        petList = db.getAllPets();
        for (int i = 0; i < petList.size(); i++) {
            System.out.println(petList.get(i));
        }
    }

    // TODO - Login

    public User login2(){
// vi skal bruge sammenligning med db, på username og password. password må ikke være sygenligt for andre.
// ved manglene sammenligning eks. ved tastefejl eller manglende bruger skal den retunere fejl.

        return null;
    }

    // TODO - Logout


    //public


}