import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] arr;
    static int[][][] shapes = new int[][][]{
        {{1, 1, 0},
        {1, 0, 0},
        {0, 0, 0}},
    
        {{1, 1, 0},
        {0, 1, 0},
        {0, 0, 0}},
    
        {{1, 0, 0},
        {1, 1, 0},
        {0, 0, 0}},
    
        {{0, 1, 0},
        {1, 1, 0},
        {0, 0, 0}},
    
        {{1, 1, 1},
        {0, 0, 0},
        {0, 0, 0}},
    
        {{1, 0, 0},
        {1, 0, 0},
        {1, 0, 0}},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 2차원 배열 안에 블록을 쌓아서 칸 속 숫자 합이 최대가 되도록
        // 블록으로 만들 수 있는 형태 총 6가지
        // O(NM)
        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for(int i=0;i<N;i++){
            for(int j=0; j<M; j++){
                ans = Math.max(ans, getMax(i,j));
            }
        }
       
       System.out.println(ans);
    }
    private static int getMax(int r, int c){ //해당 좌표에서 가능한 블록 케이스의 합을 탐색한다.
        int max = 0;
        for(int i=0; i<6; i++){
            boolean flag = true;
            int sum = 0;
            for(int x = 0; x<3; x++){
                 for(int y = 0; y<3; y++){
                    if(shapes[i][x][y] == 0) continue;

                    if(r+x>=N || c+y>=M) flag =false;
                    else sum+=arr[r+x][c+y];
                 }
            }

            if(flag) max = Math.max(max, sum);
        }
        return max;
    }
}