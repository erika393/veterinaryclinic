import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ClinicTest {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        int answer = 0;
        int answer_moreanimals = 0;
        int answer_exam = 0;
        int answer_query = 0;

        File report = new File("C:\\arquivosDaAula\\clinicatrabm3.txt");

        try{
            if(!report.exists()){
                report.createNewFile();
            }
            FileWriter fw = new FileWriter(report, true);
            BufferedWriter bw = new BufferedWriter(fw);
            do{
                System.out.println("Welcome to Vetamor Clinic");
                System.out.println("Choose one of the options:\n" +
                        "1- New Registration\n2- Report\n3- Exist");
                answer = input.nextInt();

                //CLIENT REGISTRATION
                switch(answer) {
                    case 1:
                    System.out.print("Client Name: ");
                    String client_name = input.next();
                    System.out.print("Address: ");
                    String client_address = input.next();
                    input.nextLine();
                    System.out.print("Telephone: ");
                    String client_tel = input.next();
                    input.nextLine();
                    System.out.print("Cep: ");
                    long cep = input.nextLong();
                    System.out.print("Email: ");
                    String email = input.next();
                    Client client = new Client(client_name, client_address, client_tel, cep,
                            email);

                    do {
                        //ANIMAL REGISTRATION
                        System.out.print("Animal Name: ");
                        String animal_name = input.next();
                        System.out.print("Age: ");
                        int animal_age = input.nextInt();
                        System.out.print("Animal Gender: ");
                        String animal_gender = input.next().toUpperCase();
                        while (!(animal_gender.equals("F") || animal_gender.equals("M"))) {
                            System.out.println("answer Incorreta!");
                            System.out.print("Sexo do Animal: ");
                            animal_gender = input.next().toUpperCase();
                        }
                        System.out.print("Especie: ");
                        String animal_specie = input.next();
                        Specie specie = new Specie(animal_specie);
                        Animal animal = new Animal(animal_name, animal_age, animal_gender, animal_specie);
                        specie.addAnimalSpecie(animal);
                        client.addAnimalsClient(animal);

                        //VETERINARIAN REGISTRATION
                        System.out.print("Veterinarian Name: ");
                        String vet_name = input.next();
                        System.out.print("Address: ");
                        String vet_address = input.next();
                        System.out.print("Telephone: ");
                        String vet_tel = input.next();

                        Veterinarian vet = new Veterinarian(vet_name, vet_address, vet_tel);

                        do {
                            System.out.print("Query Date: ");
                            String query_date = input.next();
                            System.out.print("Historic: ");
                            String historic = input.next();
                            Query query = new Query(query_date, historic, vet);
                            do {
                                System.out.print("Exam Description: ");
                                String exam_des = input.next();
                                Exam exam = new Exam(exam_des);
                                System.out.print("Another Exam? (1- yes 2- no)");
                                answer_exam = input.nextInt();
                                if (!(answer_exam == 1 || answer_exam == 2)) {
                                    System.out.print("Invalid Answer!");
                                }
                                query.addExame(exam);
                            } while (answer_exam == 1);

                            //TREATMENT REGISTRATION
                            System.out.print("Treatment Start Date: ");
                            String start_date = input.next();
                            System.out.print("");
                            System.out.print("Treatment End Date: ");
                            String end_date = input.next();
                            Treatment treatment = new Treatment(start_date, end_date, animal, client, vet);

                            treatment.addQuery(query);
                            animal.addTreatmentAnimal(treatment);
                            vet.addQueryVeterinarian(query);

                            System.out.print("Another Query? (1- yes 2- no)");
                            answer_query = input.nextInt();
                            if (!(answer_query == 1 || answer_query == 2)) {
                                System.out.print("Invalid Answer!");
                            }
                        } while (answer_query == 1);

                        System.out.print("Another Animal? (1- yes 2- no)");
                        answer_moreanimals = input.nextInt();
                        if (!(answer_moreanimals == 1 || answer_moreanimals == 2)) {
                            System.out.print("answer invalida!");
                        }

                        bw.write("Report" + "\n" + client);
                    } while (answer_moreanimals == 1);
                    break;

                    case 2:
                        bw.newLine();
                        bw.close();
                        fw.close();

                        FileReader fr = new FileReader(report);
                        BufferedReader br = new BufferedReader(fr);

                        while(br.ready()){
                            String linha = br.readLine();
                            System.out.println(linha);
                        }
                        br.close();
                        fr.close();

                        break;

                    case 3:
                        System.out.print("Thank you for your visit!");
                }
            }while(answer == 1);
        }catch (IOException e) {
            e.printStackTrace();
        }catch(InputMismatchException e){
            System.out.println("Please enter a number!");
            input.nextLine();
        }

    }
}
