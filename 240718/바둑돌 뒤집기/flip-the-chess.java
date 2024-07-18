import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static String[] statusArr;
    static String[] goalArr;
    public static void main(String[] args) throws IOException {
       //임의 2개의 포지션을 골라 위치 바꾼다.
       // 돌 1개를 들어 뒤집어서 색상 변경
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       n = Integer.parseInt(br.readLine());
       String status = br.readLine();
       String goal = br.readLine();
       
       int caseBW = 0;
       int caseWB = 0;
       for(int i =0; i<n; i++){
        if(status.charAt(i) == 'B' && goal.charAt(i) == 'W'){
            caseBW++;
        }else if(status.charAt(i) == 'W' && goal.charAt(i) == 'B'){
            caseWB++;
        }
       }

        int count = Math.min(caseBW, caseWB); //돌을 뒤집어서 색상을 바꿔야 할 최소 수
        int reverse = Math.abs(caseBW-caseWB);
        int ans = count+reverse;

        System.out.println(ans);
    }
}