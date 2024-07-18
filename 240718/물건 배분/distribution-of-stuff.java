import java.io.*;
import java.util.*;

public class Main {
    static int n; //물건 개수
    static int m; // 상자 최대 수용 무게
    static int[] arr;
    static int ans;

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solution();
        System.out.println(ans+1);
    }
    private static void solution(){
        ans = 0;
        int sum = 0;
        for(int i =0; i<arr.length; i++){
            if(sum+arr[i] > m) {
                ans++;
                sum = arr[i];
            }else{
             sum += arr[i];
            }
        }
    }
}