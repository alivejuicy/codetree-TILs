import java.util.*;
import java.io.*;

public class Main {
    static int n,t;
    static int[] u;
    static int[] d;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        u = new int[n];
        d = new int[n];
        st= new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            u[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            d[i] = Integer.parseInt(st.nextToken());
        }

        setSolution();
        for(int a : u){
            System.out.print(a+" ");
        }
        System.out.println();
        for(int a : d){
            System.out.print(a+" ");
        }
        System.out.println();
    }
    private static void setSolution(){
        while(t-- > 0){
            //위에서부터 오른쪽으로 밀어주기
            // 맨 오른쪽은 tmp로 미리 담아둔다.
            int tmp = u[n-1];

            for(int i= n-1; i>=1; i--){
                u[i] = u[i-1];
            } 
            u[0] = d[n-1];

            for(int i= n-1; i>=1; i--){
                d[i] = d[i-1];
            }
            d[0] = tmp;
        }
    }
}

/*
밀고 당기기, 주어진 숫자를 특정 방향으로 1칸씩 밀기
2차원 배열에서
좌우로 밀어주는 과정은 1차원배열에서 밀어주는 작업과 비슷함.

밀어줄때, 가장 바깥쪽의 원소를 담아줄 temp
밀고 나서 첫번째 원소에 할당하기

*/