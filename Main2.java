import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Main2 {

    public static void main(String[] args) {

        try  {
            File file = new File("input2.txt");
            FileInputStream fis = new FileInputStream(file);
            byte[] byteArray = new byte[(int)file.length()];
            fis.read(byteArray);
            String data = new String(byteArray);
            String[] stringArray = data.split("-| |\n");
            int n = stringArray.length;

            int res = 0;
            for (int i = 0; i < n/4; i++){
                int inferior = Integer.parseInt(stringArray[4*i]);
                int superior = Integer.parseInt(stringArray[4*i+1]);
                char letter = stringArray[4*i+2].charAt(0);
                String word = stringArray[4*i+3];
                if ((letter == word.charAt(inferior-1) && letter != word.charAt(superior-1)) || (letter != word.charAt(inferior-1) && letter == word.charAt(superior-1))){
                    res++;
                }
            }
            System.out.println(res);
        }
        catch(Exception e) {
            System.out.println("Missing file");
        }
    }
}
