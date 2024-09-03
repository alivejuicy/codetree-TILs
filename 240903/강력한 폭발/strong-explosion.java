import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int ans;
    static int[][] map;
    static boolean[][] visit;
    static List<Pair> al;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ans = 0;
        map = new int[n][n];
        visit = new boolean[n][n];
        al = new ArrayList<>();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
               int bomb = Integer.parseInt(st.nextToken());
               if(bomb > 0) al.add(new Pair(i,j)); // 폭탄 있는 위치를 담아준다.
            }
        }
        getSolution(0); // 첫 번째 좌표부터 시작
        System.out.print(ans);
    }

    private static void getSolution(int depth){
        //3가지 폭탄 방식을 백트래킹해서 최대값을 비교하여 탐색한다.

        if(depth == al.size()){ // 폭탄 개수까지 탐색했으면
            ans =Math.max(ans, calc()); // 최대값 할당함
            return;
        }
         for(int i = 1; i <= 3; i++) {
            int x = al.get(depth).x;
            int y = al.get(depth).y;
            
            map[x][y] = i;
            getSolution(depth+ 1);
            map[x][y] = 0;
        }
    }

    private static int calc(){
        for(int i = 0; i<n; i++){
            for(int j =0; j<n; j++){
                visit[i][j] = false;
            }
        }

        for(int i = 0; i<n; i++){
            for(int j =0; j<n; j++){
                if(map[i][j] > 0){
                    boom(i, j, map[i][j]);
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i<n; i++){
            for(int j =0; j<n; j++){
                if(visit[i][j]) cnt++;
            }
        }

        return cnt;
    }

    private static void boom(int x, int y, int type){
        Pair[][] bombShapes = {
            {},
            {new Pair(-2, 0), new Pair(-1, 0), new Pair(0, 0), new Pair(1, 0), new Pair(2, 0)},
            {new Pair(-1, 0), new Pair(1, 0), new Pair(0, 0), new Pair(0, -1), new Pair(0, 1)},
            {new Pair(-1, -1), new Pair(-1, 1), new Pair(0, 0), new Pair(1, -1), new Pair(1, 1)}
        };
        for(int i = 0; i < 5; i++) {
            int dx = bombShapes[type][i].x;
            int dy = bombShapes[type][i].y;
            
            int nx = x + dx, ny = y + dy;
            if(inRange(nx, ny))
                visit[nx][ny] = true;
        }
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}

class Pair{
    int x;
    int y;

    public Pair(int x, int y){
        this.x = x; 
        this.y = y;
    }
}