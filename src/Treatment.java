import java.util.ArrayList;

public class Treatment {
    private String start_date;
    private String end_date;
    private Animal animal;
    private Client client;
    private Veterinarian veterinarian;
    private ArrayList<Query> listQueryTreatment = new ArrayList<>();

    public Treatment(String start_date, String end_date, Animal animal, Client client, Veterinarian veterinarian) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.animal = animal;
        this.client = client;
        this.veterinarian = veterinarian;

        if(animal == null){
            throw new IllegalArgumentException("The animal is null or empty");
        }
        if(client == null){
            throw new IllegalArgumentException("The client is null or empty");
        }
        if(veterinarian == null){
            throw new IllegalArgumentException("The veterinarian is null or empty");
        }
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public String getList(){
        String list = "";
        for(Query objeto : listQueryTreatment){
            list+=objeto.toString() + "\n";
        }
        return list;
    }

    public void addQuery(Query query){
        listQueryTreatment.add(query);
    }

    @Override
    public String toString() {
        return "\nTREATMENT" +
                "\nStart Date: " + getStart_date() +
                "\nEnd Date: " + getEnd_date() +
                "\n\nQuery(s): " + "\n" + getList();
    }
}
