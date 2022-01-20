import java.util.ArrayList;

public class Specie {
    private final String specie_name;
    private ArrayList<Animal> listAnimalsSpecie = new ArrayList<>();

    public Specie(String specie_name) {
        this.specie_name = specie_name;

        if(specie_name == null || specie_name.equals("")){
            throw new IllegalArgumentException("The name is null or empty");
        }
    }

    public String getSpecie_name() {
        return specie_name;
    }

    public void addAnimalSpecie(Animal animal){
        listAnimalsSpecie.add(animal);
    }

    public String getList(){
        String list = "";
        for(Animal objeto : listAnimalsSpecie){
            list+=objeto.toString() + ",\n";
        }
        return list;
    }

    @Override
    public String toString() {
        return "\nSpecie Name: " + getSpecie_name();
    }
}
