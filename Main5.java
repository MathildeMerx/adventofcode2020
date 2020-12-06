import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Main5 {

    public static void main(String[] args) {
        try  {
            File file = new File("input5.txt");
            FileInputStream fis = new FileInputStream(file);
            byte[] byteArray = new byte[(int)file.length()];
            fis.read(byteArray);
            String data = new String(byteArray);
            String[] stringArray = data.split("\n");
            fis.close();
            int n = stringArray.length;
            int res = row(stringArray[0]) * 8 + column(stringArray[0]);
            int compare = 0;

            for (int i = 0; i < n; i++){
                compare = row(stringArray[i]) * 8 + column(stringArray[i]);
                if (compare > res){
                    res = compare;
                }
            }

            System.out.println(res);                
        }
        
        catch(Exception e) {
            System.out.println("Missing file");
        }
    }

    public static int row(String ticket){
        int res = 0;
        int power = 1;
        for (int i = 6; i >= 0; i--){
            if (ticket.charAt(i) == 'B'){
                res = res + power;
            }
            power = power * 2;
        }
        return res;
    }

    public static int column(String ticket){
        int res = 0;
        int power = 1;
        for (int i = 2; i >= 0; i--){
            if (ticket.charAt(i + 7) == 'R'){
                res = res + power;
            }
            power = power * 2;
        }
        return res;
    }
}
