import java.io.*;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException{
        //1 n 숫자 안겹치게 있는 수열
        // n개 카드를 수열에 따라 3번 섞음
        // 섞기 전 상태를 구함
        // 각 위치에 있던 카드를 해당 위치에 적혀있는 수열 원소의 위치로 보냄
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        int[] card = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        } // 2 3 5 4 1
       
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            card[i] = Integer.parseInt(st.nextToken());
        } // 102 103 105 104 101

        int[] ans = solution(arr, card);

        for(int a : ans){
            System.out.println(a);
        }
        
    }
    //해당 위치에 적혀있는 수열 원소의 위치
    private static int[] solution(int[] arr, int[] card){
        for(int i = 0; i<3; i++){
            int[] tmp = new int[n];

            for(int j = 0; j<arr.length; j++){
                int c = card[arr[j]-1];
                
                tmp[j] = c; //103 105 101 104 102
            }
            card = tmp;
        }

        return card;
    }
}