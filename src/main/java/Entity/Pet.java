package Entity;

public class Pet {

    private int petID;
    private String name;
    private String owner;
    private char sex;
    private int chipNumber;
    private int petPedigreeNumber;



    public Pet() {

    }

    //For at finde pets


    public Pet(int petID, String name, String owner, char sex, int chipNumber, int petPedigreeNumber) {
        this.petID = petID;
        this.name = name;
        this.owner = owner;
        this.sex = sex;
        this.chipNumber = chipNumber;
        this.petPedigreeNumber = petPedigreeNumber;
    }

    public Pet(String name, String owner, char sex, int chipNumber, int petPedigreeNumber) {
        this.name = name;
        this.owner = owner;
        this.sex = sex;
        this.chipNumber = chipNumber;
        this.petPedigreeNumber = petPedigreeNumber;
    }

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public int getChipNumber() {
        return chipNumber;
    }

    public void setChipNumber(int chipNumber) {
        this.chipNumber = chipNumber;
    }

    public int getPetPedigreeNumber() {
        return petPedigreeNumber;
    }

    public void setPetPedigreeNumber(int petPedigreeNumber) {
        this.petPedigreeNumber = petPedigreeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petID=" + petID +
                ", chipNumber=" + chipNumber +
                ", petPedigreeNumber=" + petPedigreeNumber +
                ", name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", sex=" + sex +
                '}';
    }
}