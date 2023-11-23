import java.util.*;
import java.io.*;

public class Main {
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //n명이 n개에 중복되지 않게 
        //원하는 연봉, 맞출 수 있는 최대 연봉
        //n명이 중복되지 않으면서 모두 원하는 만큼 받을 수 있는 경우 구하기

        int n = Integer.parseInt(br.readLine());
        int[] pay = new int[n];
        int[] want = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            want[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            pay[i] = Integer.parseInt(st.nextToken());
        }
        answer = 0;

        solution(n, 0, want, pay); //순열
        System.out.println(answer);
    }

    private static void solution(int n, int d, int[] want, int[] pay){
        if(d == n){
            if(check(want, pay)) answer++;
            return;
        }
        
        for(int i = d; i < n; i++){
            swap(want, d, i);
            solution(n, d+1, want, pay);
            swap(want, d, i);
        }
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j]= tmp;
    }

    private static boolean check(int[] want, int[] pay){
        for(int i = 0; i<want.length; i++){
            if(want[i] > pay[i]) return false;
        }
        return true;
    }
}