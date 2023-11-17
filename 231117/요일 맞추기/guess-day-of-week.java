import java.util.*;
import java.io.*;

public class Main {
    static String[] sevenDays = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    static int[] month = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        int date = calc(m1, d1, m2, d2);


        System.out.println(sevenDays[date % 7]);
       

    }
    private static int calc(int m1, int d1, int m2, int d2){
        
        int start = d1;
        int end = d2;
        for(int i =0; i<m1; i++){
            start += month[i];
        }

        for(int i =0; i<m2; i++){
            end += month[i];
        }

        int ans = end - start;
        
        while(ans < 0){
            ans+=7;
        }

        return ans+1;
    }

}