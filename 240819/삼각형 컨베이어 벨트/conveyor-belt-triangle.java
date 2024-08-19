import java.io.*;
import java.util.*;

public class Main {
    static int n,t;
    static int[] arrA;
    static int[] arrB;
    static int[] arrC;
    static StringBuilder sb =new StringBuilder();

    public static void main(String[] args) {
        //제일 후미의 값을 기억해둠.
        // A는 C의 후미 값을 가져온다.
        // B는 A의 후미 값
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        arrA = new int[n];
        arrB = new int[n];
        arrC = new int[n];

        for(int i =0; i<n; i++){
            arrA[i]= sc.nextInt();
        }
        for(int i =0; i<n; i++){
            arrB[i]= sc.nextInt();
        }
        for(int i =0; i<n; i++){
            arrC[i]= sc.nextInt();
        }
        
        setSolution();
        
        System.out.println(sb.toString());
    }

    private static void setSolution(){
        while(t-- >0){
            int tmp = arrA[n-1];
            for(int i = n-1; i>=1; i--){
                arrA[i] = arrA[i-1];
            }
            arrA[0] = arrC[n-1]; // 밑변의 후미 값

            int temp = arrB[n-1];
            for(int i=n-1; i>=1; i--){
                arrB[i] = arrB[i-1];
            }
            arrB[0] = tmp;

            for(int i=n-1; i>=1; i--){
                arrC[i] = arrC[i-1];
            }
            arrC[0] = temp;
        }

        for(int a : arrA){
            sb.append(a).append(" ");
        }
        sb.append("\n");
        for(int a: arrB){
            sb.append(a).append(" ");
        }
        sb.append("\n");
        for(int a: arrC){
            sb.append(a).append(" ");
        }
        sb.append("\n");
    }   
}