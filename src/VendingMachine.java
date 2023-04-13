import java.util.Arrays;

public class VendingMachine {
    public static void main(String[] args) {
        coinsChange();
    }
    public static int [] coinsChange(int change){
        int [] result = new int [8];
        int [] coins  = {200,100,50,20,10,5,2,1};

        int i = 0;
        while(change > 0){
            if(change >= coins[i]){
                result[i]++;
                change = change - coins[i];
            }else {
                i++;
            }
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
}