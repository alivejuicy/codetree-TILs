import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int ans;
    static int[] mat;

    public static void main(String[] args) throws IOException{
        // 증가하는 부분 수열 중 가장 긴 것의 길이
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        mat = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            mat[i] = Integer.parseInt(st.nextToken());
        }

        getSolution();
        System.out.println(ans);
    }
    private static void getSolution(){
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i =1; i<n; i++){
            for(int j =0; j < i; j++){
                if(mat[i]> mat[j]) // 현재 요소가 이전 요소보다 크면
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }

        ans = Arrays.stream(dp).max().getAsInt();
    }
}