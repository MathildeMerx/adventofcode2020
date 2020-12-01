import java.io.InputStream;
import java.io.FileInputStream;
import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main1 {

  public static void main(String[] args) {

    try  {
		File file = new File("input1.txt");
		FileInputStream fis = new FileInputStream(file);
		byte[] byteArray = new byte[(int)file.length()];
		fis.read(byteArray);
		String data = new String(byteArray);
		String[] stringArray = data.split("\n");
		int n = stringArray.length;

		int[] array = new int[200];
        Scanner sc = new Scanner(new BufferedReader(new FileReader(new File("input1.txt"))));
        for(int i=0;sc.hasNextLine();i++) {
        	array[i]=Integer.parseInt(sc.nextLine());
			System.out.println(array[i] + '\n');
        }
	
		for (int i = 0; i < n; i++){
			for (int j = 0; j < i; j++){
				if (array[i] + array[j] == 2020){
					System.out.println("First termn is: " + array[i]);
					System.out.println("The second one is: " + array[j]);
					System.out.println("Their product is: " + array[j]*array[i]);
				}
			}
		}
	}
	catch(Exception e) {
		System.out.println("Missing file");
    }
   }
}