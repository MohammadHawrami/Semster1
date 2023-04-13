import java.util.Scanner;

public class Erathosthenes {
    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.println("zahl eingeben: ");
            int input = in.nextInt();
            boolean [] isPrime = new boolean[input];

            for (int i = 1; i < isPrime.length; i++) {
                isPrime[i] = true;
            }

    for (int i = 2; i < isPrime.length; i++){
             for (int j = ((i+i)-1); j < isPrime.length; j += i){
                 if (isPrime[j]){
                     isPrime[j] = false;
                 }
             }
    }

    for (int i = 0; i < isPrime.length; i++) {
             if (isPrime[i]) {
                 System.out.println((i+1));
        }
    }
    in.close();
    }
}