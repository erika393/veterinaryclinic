import java.util.ArrayList;

public class Client {
    private final String client_name;
    private String client_address;
    private String client_tel;
    private long client_cep;
    private String client_email;

    private ArrayList<Animal> listAnimalsClient = new ArrayList<>();

    public Client(String client_name, String client_address, String client_tel, long client_cep, String client_email) {
        this.client_name = client_name;
        this.client_address = client_address;
        this.client_tel = client_tel;
        this.client_cep = client_cep;
        this.client_email = client_email;

        if(client_name == null || client_name.equals("")){
            throw new IllegalArgumentException("The name is null or empty");
        }

        if(client_address == null || client_address.equals("")){
            throw new IllegalArgumentException("The address is null or empty");
        }

        if(client_tel == null || client_tel.equals("")){
            throw new IllegalArgumentException("The telephone is null or empty");
        }

        if(client_email == null || client_email.equals("")){
            throw new IllegalArgumentException("The email is null or empty");
        }
    }

    public String getClient_name() {
        return client_name;
    }

    public String getClient_address() {
        return client_address;
    }

    public String getClient_tel() {
        return client_tel;
    }

    public long getClient_cep() {
        return client_cep;
    }

    public String getClient_email() {
        return client_email;
    }

    public void addAnimalsClient(Animal animal){
        listAnimalsClient.add(animal);
    }

    public  String getList(){
        String list = "";
        for(Animal objeto : listAnimalsClient){
            list+=objeto.toString() + "\n";
        }
        return list;
    }

    @Override
    public String toString() {
        return "CLIENT" +
                "\nName:" + getClient_name()+
                "\nAddress: " + getClient_address() +
                "\nTelephone: " + getClient_tel() +
                "\nCep: " + getClient_cep() +
                "\nEmail: " +getClient_email() +
                "\nAnimals Belonging:" + "\n" + getList();
    }
}
