import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] arr = new int[1000000];
        StringBuilder sb = new StringBuilder();
        int num = 0;
        
        while(true){
            if(n < b){
                arr[num++] = n;
                break;
            }
            arr[num++] = n % b;
            n/= b;
        }
        for(int i = num-1; i>=0; i--){
            sb.append(arr[i]);
        }
        
        System.out.println(sb);
    }
}