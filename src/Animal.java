import java.util.ArrayList;

public class Animal {
    private final String animal_name;
    private final int animal_age;
    private final String animal_gender;
    private final String specie;
    private ArrayList<Treatment> listTreatments = new ArrayList<>();

    public Animal(String animal_name, int animal_age, String animal_gender, String specie) {
        this.animal_name = animal_name;
        this.animal_age = animal_age;
        this.animal_gender = animal_gender;
        this.specie = specie;

        if(animal_name == null || animal_name.equals("")) {
            throw new IllegalArgumentException("The name is null or empty");
        }
        if(specie == null || specie.equals("")) {
            throw new IllegalArgumentException("The specie is null or empty");
        }
    }

    public String getAnimal_name() {
        return animal_name;
    }

    public int getAnimal_age() {
        return animal_age;
    }

    public String getAnimal_gender() {
        return animal_gender;
    }

    public String getSpecie() {
        return specie;
    }

    public void addTreatmentAnimal(Treatment treatment){
        listTreatments.add(treatment);
    }

    public String getList(){
        String list = "";
        for(Treatment objeto : listTreatments){
            list+=objeto.toString() + "\n";
        }
        return list;
    }

    @Override
    public String toString(){
        return "ANIMAL" +
                "\nName: " + getAnimal_name() +
                "\nAge: " + getAnimal_age() +
                "\nGender: " + getAnimal_gender() +
                "\nSpecie: " + getSpecie() +
                "\n\nTreatment(s): " + getList();
    }
}
