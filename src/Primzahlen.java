import java.util.Scanner;

public class Primzahlen {
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        System.out.println("Geben sie eine Zahl größer 1 ein");
        n = in.nextInt();

        for (int i = n; i > 1; i--) {
                isPrime(i);
        }
        in.close();
    }

     static void isPrime(int n) {
             for (int i = 2; i < n; i++) {
                 if(n % i == 0){
                     return;
                      }
             }

             System.out.println(n + " ist eine Primzhal");
             return;
     }
}