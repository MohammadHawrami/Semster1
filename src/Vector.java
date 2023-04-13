import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector {
    public static void main(String[] args) {
        Vector testInstance = new Vector();
    }
    //calculates cross product of 2 vectors
    public void vectorProduct(int [] vector1, int [] vector2) {
        //checks if both vectors are 2D and prinst result
        if(vector1.length == 2 && vector2.length == 2) {
            System.out.println(vector1[0] * vector2[1] - vector2[0] * vector1[1]);

        }
        //checks if both vectors are 3D and prinst result
        else if(vector1.length == 3 && vector2.length ==3) {
            System.out.println(vector1[1] * vector2[2] - vector1[2]  * vector2[1]);
            System.out.println(vector1[2] * vector2[0] - vector1[0]  * vector2[2]);
            System.out.println(vector1[0] * vector2[1] - vector1[1]  * vector2[0]);
        }
        // if vectors are invaild print error massage
        else {
               System.out.println("vectors invalid: please enter 2 vectors of same length (2D or 3D");
        }
    }
    //executes matrice multiplication (takes vectro of arbitrary length as param
    public void skalar (int[] vector, int skalar) {
        //multiplies each coordinates of given vector by skalar
        for (int index = 0; index < vector.length; index++) {
            vector[index] *= skalar;
        }
        System.out.println(Arrays.toString(vector));
    }
    //calculates vector length of vector with arbitrary length
    public double vectorLength(int[] vector) {
            int subtotal = 0;
            //calculates sum of each coordinate of given vector to power of 2
            for(int coordinate : vector){
                    subtotal += Math.pow(coordinate, 2);
            }
            //prints and return sqrt of subtotal
            System.out.println(Math.sqrt(subtotal));
            return Math.sqrt(subtotal);
    }
    //checks if given martikelnumber is vaidated between 2020 and 2022 1
    public boolean matrikelCheck(String martikel) {

            String regex =  "[2][0-1][1-2][0-9]{4}|[2][2][1][0-9]{4}";
    Pattern p = Pattern.compile(regex);

    if(martikel == null) {
        return false;
    }
    Matcher m = p.matcher(martikel);

    System.out.println(m.matches());
    return m.matches();
    }
    //checks if given time is vaild in format HH:MM (hours 0-23, minutes 0-59)
    public boolean timecheck(String time) {
            String regex = "([01][0-9]|2[0-3]):[0-5][0-9]";
    Pattern p = Pattern.compile(regex);

        if (time == null) {
            return false;
        }
        Matcher m = p.matcher(time);

        System.out.println(m.matches());
        return m.matches();
    }
    //multiplies 3x3 matrice by a given vector
    public int [][] matrixReloaded(int [][] matrix, int skalar){
        // checks if matrice is 3x3 format
        if(matrix.length != 3) {
                return null;
        }
        for(int[] element : matrix) {
                if(element.length != 3) {
                        return null;
                }
        }
        // iterares through each element of nestes array (matrix) and multipiles each element by skalar
        for(int rowindex = 0; rowindex <= 2; rowindex++){
            for(int columnindex = 0; columnindex <=2; columnindex++) {
                matrix[rowindex][columnindex] *= skalar;

            }
        }

        System.out.println(Arrays.deepToString(matrix));
        return matrix;
    }
}