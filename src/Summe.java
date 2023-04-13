import java.util.Scanner;

public class Summe {
    public static void main(String[] args) {

        int input = 0;
        int sum = 0;
        int input_count = 0;


        Scanner in = new Scanner(System.in);

        do{
            System.out.println("Programm endet durch Eingabe einer negativen Zahl");
            System.out.println("Eingabe der Zahl: ");

            input = in.nextInt();
            input_count++;
            if(input % 2 == 0 && input > 0){
                sum += input;
            };
        }while (input >= 0);
        System.out.println("Sum: " + sum + "with" + (input_count-1) + "Inputs");
        in.close();
    }
}
