import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Main4 {

    public static void main(String[] args) {
        try  {
            File file = new File("input4.txt");
            FileInputStream fis = new FileInputStream(file);
            byte[] byteArray = new byte[(int)file.length()];
            fis.read(byteArray);
            String data = new String(byteArray);
            String[] stringArray = data.split("\n\n");
            int n = stringArray.length;
            int res = 0;
            int compt = 0;
            
            for (int i = 0; i < n; i++){
                data = stringArray[i]; 
                String[] passport = data.split(" |\n");
                if (passport.length >= 7){
                    compt = 0;
                    for (int j = 0; j < passport.length; j++){
                        if (passport[j].substring(0,3).matches("byr")){
                            compt = compt + birth(passport[j]);
                        }
                        if (passport[j].substring(0,3).matches("iyr")){
                            compt = compt + issue(passport[j]);
                        }
                        if (passport[j].substring(0,3).matches("eyr")){
                            compt = compt + expiration(passport[j]);
                        }
                        if (passport[j].substring(0,3).matches("hgt")){
                            compt = compt + height(passport[j]);
                        }
                        if (passport[j].substring(0,3).matches("hcl")){
                            compt = compt + hair(passport[j]);
                        }
                        if (passport[j].substring(0,3).matches("ecl")){
                            compt = compt + eye(passport[j]);
                        }
                        if (passport[j].substring(0,3).matches("pid")){
                            compt = compt + p_id(passport[j]);
                        }
                    }
                    if (compt == 7){
                        res = res + 1;
                    }
                }
            }
            System.out.println(res);
            
        }
        catch(Exception e) {
            System.out.println("Missing file");
        }
    }

    public static int birth(String arg){
        int res = 0;
        int year = 0;
        String[] byr = arg.split(":");
        if (byr[1].matches("[0-9]+")){
            year = Integer.parseInt(byr[1]);
        }
        if (year <= 2002 && year >= 1920){
            res++;
        }
        return res;
    }

    public static int issue(String arg){
        int res = 0;
        int year = 0;
        String[] byr = arg.split(":");
        if (byr[1]. matches("[0-9]+")){
            year = Integer.parseInt(byr[1]);
        }
        if (year <= 2020 && year >= 2010){
            res++;
        }
        return res;
    }

    public static int expiration(String arg){
        int res = 0;
        int year = 0;
        String[] byr = arg.split(":");
        if (byr[1]. matches("[0-9]+")){
            year = Integer.parseInt(byr[1]);
        }
        if (year <= 2030 && year >= 2020){
            res++;
        }
        return res;
    }

    public static int height(String arg){
        int res = 0;
        int size = 0;
        String[] byr = arg.split(":");

        if (byr[1].length() == 5){
            if (byr[1].substring(0,3).matches("[0-9]+") && byr[1].substring(3,5).matches("cm")){
                size = Integer.parseInt(byr[1].substring(0,3));
            }
        }
        
        if (byr[1].length() == 4){
            if (byr[1].substring(0,2).matches("[0-9]+") && byr[1].substring(2,4).matches("in")){
                size = Integer.parseInt(byr[1].substring(0,2));
            }
        }

        if ((size >= 150 && size <= 193) || (size >= 59 && size <= 76)){
            res++;
        }
        return res;
    }

    public static int hair(String arg){
        int res = 0;
        String[] byr = arg.split(":");
        if (byr[1].matches("#[0-9a-f]+")){
            res++;
        }
        return res;
    }

    public static int eye(String arg){
        int res = 0;
        String[] byr = arg.split(":");
        if (byr[1].matches("amb") || byr[1].matches("blu") || byr[1].matches("brn") || byr[1].matches("gry") || byr[1].matches("grn") || byr[1].matches("hzl") || byr[1].matches("oth")){
            res++;
        }
        return res;
     }

    public static int p_id(String arg){
        int res = 0;
        String[] byr = arg.split(":");
        if (byr[1].length() == 9 && byr[1].matches("[0-9]+")){
            res++;
        }
        return res;
    }
}
