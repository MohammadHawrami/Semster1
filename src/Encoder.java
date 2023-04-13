import java.util.Scanner;

public class Encoder {
    public static void main(String[] args) {
        char [] converter = {
                          'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
                          'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
                          };
        String result = "";
        boolean added = false;
        Scanner in = new Scanner (System.in);
        System.out.println("String eingeben");
        String input  = in.nextLine();

        for (int i = 0; i < input.length(); i++) {
                added = false;
            int j = 0;

            while(!added && j < converter.length) {
                if(input.charAt(i) == 'Z'){
                          added = true;
                    result += 'A';
                }
                else if(input.charAt(i) == 'z'){
                               added = true;
                    result += 'a';
                }
                else if(input.charAt(i) == converter[j]) {
                               added = true;
                               result += converter[j+1];
                }
                j++;
            }

            if(!added){
                result += input.charAt(i);
            }

        }
        System.out.println(result);
        in.close();
    }
}