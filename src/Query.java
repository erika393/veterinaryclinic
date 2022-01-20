import java.util.ArrayList;

public class Query {
    private String query_date;
    private String historic;
    private Veterinarian veterinarian;
    private ArrayList<Exam> listExamQuery = new ArrayList<>();

    public Query(String query_date, String historic, Veterinarian veterinarian) {
        this.query_date = query_date;
        this.historic = historic;
        this.veterinarian = veterinarian;
    }

    public String getQuery_date() {
        return query_date;
    }

    public String getHistoric() {
        return historic;
    }

    public String getList(){
        String list = "";
        for(Exam objeto : listExamQuery){
            list+=objeto.toString() + "\n";
        }
        return list;
    }

    public void addExame(Exam exam){
        listExamQuery.add(exam);
    }

    @Override
    public String toString() {
        return "QUERY" +
                "\nVeterinarian: " + "\n" + veterinarian +
                "\nQuery Date: " +getQuery_date() +
                "\nHistoric: " + getHistoric() +
                "\n" + getList();
    }
}
