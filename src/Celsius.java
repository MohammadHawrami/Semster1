//Demo Programm für die erste Übung
import java.util.Scanner;

//Programm zur Berechnung der Fahrenheit Temperatur
//bei bekannter Celsius Temperatur
public class Celsius {
    public static void main(String[] args) {
        //benötigte Variable deklarieren
        double epsilon = 0.005;
        double c = 0.0, f;

        //Für die Eingabe von der Tastertur
        Scanner in = new Scanner(System.in);

        //Berechnungsschleife
        do {
            //Anleitung
            System.out.println("Programm endet durch Eingabe von 0");
            System.out.println("Eingabe der Celsius-Temperatur: ");
            //Eingabe, Double-Wert einlesen
            c = in.nextDouble();
            //Umrechnen in Fahrenheit
            f = c * 9.0 / 5.0 + 32.0;
            //Ausgabe des Ereignis
            System.out.println("... in Fahrenheit: " + f + "Grad\n");
            //Schleife durch Eingabe von 0 verlassen?
        }while (Math.abs(c) > epsilon);

        System.out.println("... und Tschüss");
        in.close();
    }
}

