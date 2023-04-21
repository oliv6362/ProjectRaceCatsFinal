package Entity;

public class Pet {

    private int petID;
    private int chipNumber;
    private int petPedigreeNumber;
    private String name;
    private String owner;
    private char sex;

    //For at finde pets
    public Pet(int petID, int chipNumber, int petPedigreeNumber, String name, String owner, char sex) {
        this.petID = petID;
        this.chipNumber = chipNumber;
        this.petPedigreeNumber = petPedigreeNumber;
        this.name = name;
        this.owner = owner;
        this.sex = sex;
    }

    //For at lave pets
    public Pet(int chipNumber, int petPedigreeNumber, String name, String owner, char sex) {
        this.chipNumber = chipNumber;
        this.petPedigreeNumber = petPedigreeNumber;
        this.name = name;
        this.owner = owner;
        this.sex = sex;
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