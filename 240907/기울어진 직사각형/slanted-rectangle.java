import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans =0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=1; k<n; k++){
                    for(int l=1; l<n; l++){
                        ans = Math.max(ans, getSolution(i,j,k,l));
                        //i,j는 기준 좌표값, k,l은 너비와 높이
                    }
                }
            }
        }
        System.out.println(ans);
    }
    private static int getSolution(int x, int y, int k, int l){
        //대각선 순서대로 좌표값
        int[] dx = new int[]{-1,-1,1,1};
        int[] dy = new int[]{1, -1, -1, 1};

        int[] num = new int[]{k,l,k,l};

        int sum =0;
        for(int i =0; i<4; i++){ //4개의 대각선 순서대로 
            for(int j =0; j < num[i]; j++ ){ //대각선 길이 내의 좌표 하나씩 확인해본다
                x += dx[i];
                y += dy[i];

                if(!inRange(x,y)) return 0; // 범위 넘었으면 리턴

                sum += map[x][y]; //값 더해나감
            }
        }
        return sum;
    }
    private static boolean inRange(int x, int y){
        return x >= 0 && x < n && y>=0 && y<n;
    }
}