import java.util.*;
import java.io.*;

public class Main {
    // 그리디, 
    // 주어진 수 길이의 홀,짝을 구한다.
    // 중앙값을 짝수로해서 구한다.

    static int n;
    static int[] arr;
    static int ans;
    static int len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        getSolution();
        System.out.println(ans);

    }
    private static void getSolution(){
        ans = 0;
        len = arr.length-1;
        Arrays.sort(arr);

        if(arr.length % 2 != 0) ans+= arr[arr.length/2];

        for(int i=0; i<len; i++){
            if(i == arr.length/2) break;
            int front = arr[i];
            int back = arr[len-i];
            ans+= back*2;
        }
    }
}