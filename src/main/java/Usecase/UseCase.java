package Usecase;

import java.util.Scanner;
import DB.DBcontroller;
import Entity.Pet;
import Entity.User;
import UI.UIcontroller;
import java.util.ArrayList;

public class UseCase {
    DBcontroller db = new DBcontroller();
    public User hentetUser = new User();

    public boolean loginUser(String email, String password) {

        hentetUser = db.getUserPass(hentetUser,email, password);

        if (email.equals(hentetUser.getEmail()) && password.equals(hentetUser.getPassword() )) {
            hentetUser.setLogin(true);
            return true;

        } else {
            return false;
        }
    }

    public void buildUser(String fName, String lName, String email, String password, int phoneNumber){
        db.addUser(new User(fName, lName, email, password, phoneNumber));
    }

    public void editUser(String fName, String lName, String email, String password, int phoneNumber){
        db.editUser(new User(fName, lName, email, password, phoneNumber));
    }

    public void showUsers(){
        ArrayList<User> userList;
        userList = db.getAllUsers();
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
        }
    }

    public Pet buildPet(int chipNo, int petPedigreeNo, String name, String owner, char sex){
        return new Pet(name, owner, sex, chipNo, petPedigreeNo);
    }


    //todo til redigering af bruger - ikke done
    //when pressing accout run this
    public User getUser(){

        return hentetUser;
    }
    public void editAccount(User user){
        db.editUser(user);
    }

    // TODO - Vis alle pets - ikke done
   /* public void showPets(){
        System.out.println("Hent alle pets");
        ArrayList<User> petList;
        petList = db.getAllPets();
        for (int i = 0; i < petList.size(); i++) {
            System.out.println(petList.get(i));
        }
    }*/
}