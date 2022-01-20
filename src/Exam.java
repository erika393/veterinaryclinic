public class Exam {
    private String des_exame;

    public Exam(String des_exame) {
        this.des_exame = des_exame;

        if(des_exame == null || des_exame.equals("")){
            throw new IllegalArgumentException("The description is null or empty");
        }
    }

    public String getDes_exame() {
        return des_exame;
    }

    @Override
    public String toString() {
        return "\nEXAM" +
                "\nDescription: " + getDes_exame();
    }
}
