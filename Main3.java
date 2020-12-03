import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Main3 {

    public static void main(String[] args) {
        try  {
            File file = new File("input3.txt");
            FileInputStream fis = new FileInputStream(file);
            byte[] byteArray = new byte[(int)file.length()];
            fis.read(byteArray);
            String data = new String(byteArray);
            String[] stringArray = data.split("\n");
            int n = stringArray.length;
            int l = stringArray[0].length();

            int res1 = 0;
            int horizontal1 = 1;
            int res3 = 0;
            int horizontal3 = 3;
            int res5 = 0;
            int horizontal5 = 5;
            int res7 = 0;
            int horizontal7 = 7;
            for (int i = 1; i < n; i++){
                if (stringArray[i].charAt(horizontal1) == '#'){
                    res1++;
                }
                if (stringArray[i].charAt(horizontal3) == '#'){
                    res3++;
                }
                if (stringArray[i].charAt(horizontal5) == '#'){
                    res5++;
                }
                if (stringArray[i].charAt(horizontal7) == '#'){
                    res7++;
                }
                horizontal1 = horizontal1 + 1;
                if (horizontal1 >= l){
                    horizontal1 = horizontal1 - l;
                }
                horizontal3 = horizontal3 + 3;
                if (horizontal3 >= l){
                    horizontal3 = horizontal3 - l;
                }
                horizontal5 = horizontal5 + 5;
                if (horizontal5 >= l){
                    horizontal5 = horizontal5 - l;
                }
                horizontal7 = horizontal7 + 7;
                if (horizontal7 >= l){
                    horizontal7 = horizontal7 - l;
                }
            }
            System.out.println("1 "+res1 + "  3 "+res3+"  5 "+res5+"  7 "+res7);

            int res = 0;
            int horizontal = 1;
            for (int i = 1; i < n/2; i++){
                if (stringArray[2*i].charAt(horizontal) == '#'){
                    res++;
                }
                horizontal = horizontal + 1;
                if (horizontal >= l){
                    horizontal = horizontal - l;
                }
            }

            System.out.println(res);
            System.out.println(res1*res3*res5*res7*res);
        }
        catch(Exception e) {
            System.out.println("Missing file");
        }
    }
}
