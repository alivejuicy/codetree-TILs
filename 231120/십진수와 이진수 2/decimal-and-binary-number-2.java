import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        int num = 0;
        for(int i = 0; i< str.length; i++){
            num = num * 2 + Integer.parseInt(str[i]);
        }
        num *= 17;
        int[] arr= new int[250001];
        int n = 0;
        while(true){
            if(num < 2){
                arr[n++] = num;
                break;
            }
            arr[n++] = num % 2;
            num /= 2;
        }
        StringBuilder sb = new StringBuilder();
        for(int i =n-1; i>=0; i--){
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}