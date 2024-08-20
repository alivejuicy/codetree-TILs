import java.io.*;
import java.util.*;

public class Main {
    static final int BLOCK = -1;
    static int n;
    static int[] arr;
    static int[] temp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        temp = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<2; i++){
            st =new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int e1 = Integer.parseInt(st.nextToken());
            setSolution(s1, e1);
        }
        getSolution();
        
        System.out.println(sb.toString());
    }

    private static void setSolution(int s, int e){
        int index = 0;

        for(int i=s-1; i<=e-1; i++){
            arr[i] = BLOCK;
        }

        for(int i =0; i<n; i++){
            if(arr[i] != BLOCK) {
                temp[index] = arr[i];
                index++;
            }
        }
        arr = temp;       
    }

    private static void getSolution(){
        int cnt = 0;
        for(int i = arr.length-1; i>=0; i--){
            if(arr[i] != 0){
                sb.append(arr[i]).append("\n");
                cnt++;
            }
        }
        sb.append(cnt);
        sb.reverse();
    }
}




/*
    
    시간 복잡도 O(n)에 진행하기 위해 temp 배열을 활용한다.

    1. temp라는 이름의 2차원 배열을 생성한다.
    2. 기존 배열의 타겟인 열에 대해서 n-1 행부터 0까지 자료를 조사하고
    있을때만 temp의 n-1부터 자료를 쌓는다.
    3. 쌓은 temp 배열의 타겟 열을 기존 배열의 열에다 복사한다.


    1차원으로 생각해서 접근한다.
*/