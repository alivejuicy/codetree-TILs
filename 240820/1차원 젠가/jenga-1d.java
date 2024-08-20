import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int[] temp;
    static StringBuilder sb = new StringBuilder();
    static int arrIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        temp = new int[n];
        arrIndex = n;

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
    }

    private static void setSolution(int s, int e){
        int index = 0;

        for(int i =0; i < arrIndex; i++){
            if(i< s-1 || i > e-1){ // 시작점과 끝점을 제외한 숫자만
                temp[index++] = arr[i]; //temp 배열에 할당한다.
            }
        }
        for(int i=0; i<index; i++){
            arr[i] = temp[i]; // temp 내 요소를 arr에 재할당해주고
        }

        arrIndex = index; // index 길이를 조절한다.
    }

    private static void getSolution(){
        sb.append(arrIndex).append("\n");

       for(int i =0; i<arrIndex; i++){
            sb.append(arr[i]).append("\n");
       }

       System.out.println(sb.toString());
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