import java.util.*;
import java.io.*;

public class Main {
    //2가지의 구간이 있다면, 두 케이스로 나눠서 생각하지 않고
    //배열을 통해 두 구간을 채워주고 값이 있는 곳을 확인
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        //1번 칸, N번 칸까지
        // A번째 칸부터 B번째 칸까지 블럭을 1씩 쌓을 것
        // 명령 횟수는 총 K번
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        
        for(int i = 1; i<= k; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for(int j = start; j<=end; j++){
                arr[j]+=1;
            }
        }

        //명령 다 수행한 이후, 1번부터 N번 칸까지 쌓인 블럭 수 중 최대 구하기
        // int ans = Arrays.stream(arr).max().getAsInt(); //stream은 시간 더 걸림
        int ans =0;
        for(int z : arr){
            ans = Math.max(ans, z);
        }
        
        System.out.println(ans);
    }
}