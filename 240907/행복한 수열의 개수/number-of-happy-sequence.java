import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int ans;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = 0;
        for(int i =0; i<n; i++){
            if(getCol(i)) ans++;

            if(getRow(i)) ans++;
        }
        System.out.println(ans);
    }

    private static boolean getCol(int col){
        int cnt = 0;
        for(int i = 1; i<n; i++){
            if(map[i-1][col] == map[i][col]) cnt++;
            else{
                if(cnt < m-1) cnt = 0;
                // m-1로 두는 이유는 m개 이상의 수열 개수인데, 하나의 수도 수열이기 때문
                // 2 2 면 동일한 수 2개의 수열이다.
            }
        }
        //탐색 다 돌앗으면
        return cnt >= m - 1;
    }
    private static boolean getRow(int row){
        int cnt = 0;
        for(int i = 1; i<n; i++){
            if(map[row][i-1] == map[row][i]) cnt++;
            else{
                if(cnt < m-1) cnt = 0;
            }
        }
        return cnt >= m - 1;
    }
}

// import java.util.*;
// import java.io.*;

// public class Main {
//     // 연속하여 m개 이상의 동일한 원소가 나오는 순간이 존재하는 수열
//     static int N,M;
//     static int[][] arr;
//     public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        arr = new int[N][N];
//        // M개 이상 순서있게 동일한지 여부를 알고싶다.
//        // O(2 * n^2)

//        for(int i = 0; i<N; i++){
//             st = new StringTokenizer(br.readLine());
//             for(int j =0; j<N; j++){
//                 arr[i][j] = Integer.parseInt(st.nextToken());
//             }
//        }
//         int ans = 0;
//         //행
//         for(int i =0; i<N; i++){
//             ans += getRow(i);
//         }
//         //열
//         for(int i =0; i<N; i++){
//             ans+= getCol(i);
//         }

//         System.out.println(ans);
//     }
//     private static int getRow(int start){
//         int happy = 0;
//         for(int i = 1; i<N; i++){
//             if(arr[start][i-1] == arr[start][i] ) happy++;
//             else{
//                 if(happy < M-1) happy = 0;
//             }
//         }
//         if(happy >= M-1){
//             return 1;
//         }
//         return 0;
//     }
//     private static int getCol(int start){
//         int happy = 0;
//         for(int i = 1; i<N; i++){
//             if(arr[i-1][start] == arr[i][start]) {
//                 happy++;
//             }
//             else{
//                 if(happy < M-1) happy = 0;
//             }
//         }
//         if(happy >= M-1){
//             return 1;
//         }
//         return 0;
//     }
// }