import java.util.InputMismatchException;
import java.util.Scanner;

public class Rom {
    public static void main(String[] args) {
        int [] ints = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String [] romes = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    Scanner in = new Scanner(System.in);
    String result = "";
    System.out.println("Bitte Zahl eingeben: ");
    int input = in.nextInt();

    if(input < 1 || input > 3999) {
             in.close();
                throw new InputMismatchException("Please enter a number between 1 and 3999");
    }
    int i = 0;

    while(input > 0) {
        while(input >= ints[i]){
            input -= ints[i];
            result += romes[i];
        }
        i++;
    }

    System.out.println(result);
    }
}