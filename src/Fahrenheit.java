import java.util.Scanner;

public class Fahrenheit {
    public static void main(String[] args) {

        double epsilon = 0.005;
        double f = 0.0, c;

        Scanner in = new Scanner(System.in);

        do{
            System.out.println("Programm endet durch Eingabe von 1");
            System.out.println("Eingabe der Fahrenheit-Temperatur");

            f = in.nextDouble();

            c = ((f - 32)*5)/9;

            System.out.println("... Celsius: " + c + "Grad\n");

        }while (Math.abs(f-1) > epsilon);

        System.out.println("... und Tschüss");
        in.close();
    }
}
