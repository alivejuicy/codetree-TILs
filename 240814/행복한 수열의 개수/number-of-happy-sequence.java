import java.util.*;
import java.io.*;

public class Main {
    // 연속하여 m개 이상의 동일한 원소가 나오는 순간이 존재하는 수열

    static int N,M;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());
       arr = new int[N][N];
       // M개 이상 순서있게 동일한지 여부를 알고싶다.
       // O(2 * n^2)

       for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
       }
        int ans = 0;
        //행
        for(int i =0; i<N; i++){
            ans += getRow(i);
        }
        //열
        for(int i =0; i<N; i++){
            ans+= getCol(i);
        }

        System.out.println(ans);
    }
    private static int getRow(int start){
        int happy = 0;
        for(int i = 1; i<N; i++){
            if(arr[start][i-1] == arr[start][i] ) happy++;
            else{
                if(happy < M-1) happy = 0;
            }
        }
        if(happy >= M-1){
            return 1;
        }
        return 0;
    }
    private static int getCol(int start){
        int happy = 0;
        for(int i = 1; i<N; i++){
            if(arr[i-1][start] == arr[i][start]) {
                happy++;
            }
            else{
                if(happy < M-1) happy = 0;
            }
        }
        if(happy >= M-1){
            return 1;
        }
        return 0;
    }
}