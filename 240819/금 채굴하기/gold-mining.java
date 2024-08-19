import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        // 상하좌우 마름모
        // 비용 K ^ 2 + (K+1)^2
        // 격자 크기 n, 가격 m
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i= 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        for(int i= 0; i<N; i++){
            for(int j =0; j<N; j++){
                for(int k=0; k<2*(N-1); k++){ // N*N 좌표를 모두 포함시키기 위해
                    int gold = getNumOfGold(i,j,k);
                    if(gold * M >= getPrice(k)){
                        ans = Math.max(ans, gold);
                    }
                }
            }
        }
        System.out.println(ans);
    }

    private static int getPrice(int k){
        return k*k+(k+1)*(k+1); //비용 계산
    }

    private static int getNumOfGold(int r, int c, int k){ //금 개수 탐색하기
        int num = 0;
        for(int i =0; i<N; i++ ){
            for(int j =0; j<N; j++){
                // k 내부의 좌표일때만 금 개수 카운트
                if(Math.abs(r-i)+Math.abs(c-j) <= k) num += map[i][j];
            }
        }
        return num;
    }
}