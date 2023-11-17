import java.util.*;
import java.io.*;

public class Main {
    static int[] arr = new int[]{0,31, 28, 31,30,31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());

        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        
        for(int i = 0; i<=m1; i++){
            d1 += arr[i];
        }
        for(int i = 0; i<=m2; i++){
            d2 += arr[i];
        }

        System.out.println(d2-d1);
    }
}