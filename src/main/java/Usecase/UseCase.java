package Usecase;

import Entity.Pet;
import Entity.User;

public class UseCase {

    public User buildUser(int userID, String fName, String lName, String email, String password, int phoneNumber){
        return new User(userID, fName, lName, email, password, phoneNumber);
    }

    public Pet buildPet(int petID, int chipNo, int petPedigreeNo, String name, String owner, char sex){
        return new Pet(petID, chipNo, petPedigreeNo, name, owner, sex);
    }
}