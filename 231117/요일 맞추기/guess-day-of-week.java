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

        for(int i =0; i<m1; i++){
            d1 += month[i];
        }

        for(int i =0; i<m2; i++){
            d2 += month[i];
        }

        return Math.abs(d2 - d1 + 1);
    }

}