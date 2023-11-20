import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] binary = br.readLine().split("");
        int num =0;
        
        for(int i =0; i<binary.length; i++){
            int tmp = Integer.parseInt(binary[i]);
            num = num * 2 +tmp;
        }
        System.out.println(num);
    }
}