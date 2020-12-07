import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try  {
            File file = new File("input6.txt");
            FileInputStream fis = new FileInputStream(file);
            byte[] byteArray = new byte[(int)file.length()];
            fis.read(byteArray);
            String data = new String(byteArray);
            String[] stringArray = data.split("\n\n");
            int n = stringArray.length;
            int res = 0;

            for (int i = 0; i < n; i++){
                String[] group = stringArray[i].split("\n");
                res = res + count_yes(group);
            }

            System.out.println(res);
            
        }
        catch(Exception e) {
            System.out.println("Missing file");
        }
    }

    public static int count_yes(String[] arr){
        int res = 0;
        int[] alphaBeta = new int[26];
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length(); j++){
                char character = arr[i].charAt(j);    
                int ascii = (int) character;
                alphaBeta[ascii - 97] = alphaBeta[ascii - 97] + 1;
            }
        }
        for (int i = 0; i < 26; i++){
            if (alphaBeta[i] == arr.length){
                res = res + 1;
            }
        }
        return res;
    }
}
