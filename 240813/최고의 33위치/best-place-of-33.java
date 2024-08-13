import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(j+2>=N || i+2 >= N) continue;
                int tmp = getSolution(i, j, i+2, j+2);
                ans = Math.max(ans, tmp);
            }
        }
        System.out.println(ans);
    }

    private static int getSolution(int r, int c, int er, int ec){
        int sum = 0;
        for(int i = r; i<= er; i++){
            for(int j = c; j<=ec; j++){
               sum +=arr[i][j];
            }
        }
        return sum;
    }
}




/*
시간 복잡도 우선 계산, 시간초과가 나지 않을 것
같다면 항상 적용해본다.
완탐을 구현하기 위한 방법으론 
for문 기반 구현과
재귀함수 기반(백트래킹) 구현이 있다.
*/