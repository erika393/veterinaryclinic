import java.util.ArrayList;

public class Veterinarian {
    private final String vet_name;
    private String vet_address;
    private String vet_tel;
    private ArrayList<Query> listQuerysVeterinarian = new ArrayList<>();

    public Veterinarian(String vet_name, String vet_address, String vet_tel) {
        this.vet_name = vet_name;
        this.vet_address = vet_address;
        this.vet_tel = vet_tel;

        if(vet_name == null||vet_name.equals("")){
            throw new IllegalArgumentException("The name is null or empty");
        }

        if(vet_address == null||vet_address.equals("")){
            throw new IllegalArgumentException("The address is null or empty");
        }

        if(vet_tel == null||vet_tel.equals("")){
            throw new IllegalArgumentException("The telephone is null or empty");
        }
    }

    public String getVet_name() {
        return vet_name;
    }

    public String getVet_address() {
        return vet_address;
    }

    public String getVet_tel() {
        return vet_tel;
    }

    public void addQueryVeterinarian(Query query){
        listQuerysVeterinarian.add(query);
    }

    public String getList(){
        String list = "";
        for(Query objeto : listQuerysVeterinarian){
            list+=objeto.toString() + "\n";
        }
        return list;
    }

    @Override
    public String toString() {
        return "VETERINARIAN" +
                "\nName: " + getVet_name() +
                "\nAddress: " + getVet_address()+
                "\nTelephone: " + getVet_tel();
    }
}
