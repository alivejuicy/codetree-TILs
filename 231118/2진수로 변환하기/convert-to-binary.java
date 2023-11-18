import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(calc(n));
    }

    private static String calc(int n){
        int[] arr = new int[100000];
        int cnt = 0;

        while(true){
            if(n < 2){
                arr[cnt++] = n;
                break;
            }
            arr[cnt++] = n % 2;
            n /=2;
        }

        StringBuilder sb = new StringBuilder();
        for(int i =cnt-1; i >= 0; i--){
            sb.append(arr[i]);
        }
        
        return sb.toString();
    }
    
}