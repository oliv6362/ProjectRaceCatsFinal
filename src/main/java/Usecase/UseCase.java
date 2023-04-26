package Usecase;

import java.util.Scanner;
import DB.DBcontroller;
import Entity.Pet;
import Entity.User;
import UI.UIcontroller;
import java.util.ArrayList;

public class UseCase {

        } else {
            System.out.println("Email eller Password var ikke korrekt");
            accessType = 3;

        }
        return accessType;*/
        return 1;
    }



    //TODO - Opret user
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
}