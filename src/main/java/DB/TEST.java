package DB;


import Entity.User;


import java.util.ArrayList;

public class TEST {

    //todo tester
    DBcontroller db = new DBcontroller();
    //printer alle modtagere


    public void test1() {


        System.out.println("print alle brugere");
        ArrayList<User> userListe;
        userListe = db.getAllUser();
        for (int i = 0; i < userListe.size(); i++) {
            System.out.println(userListe.get(i));
        }
    }




}
