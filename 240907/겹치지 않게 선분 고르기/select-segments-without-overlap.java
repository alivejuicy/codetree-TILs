import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int ans;
    static List<int[]> pair = new ArrayList<>();
    static List<int[]> selectedPair = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int x1,x2;
        for(int i=0; i<n; i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            pair.add(new int[]{x1,x2});
        }
        ans=0;
        backTracking(0);
        System.out.println(ans);


    }
    private static void backTracking(int depth){
        /*
        3
        1 2
        1 4
        3 4
        */
        if(depth == n){
            if(inRange()){ //선분이 겹치지 않는지?
                ans = Math.max(ans, selectedPair.size());
            }
            return;
        }
        //depth번째 선분을 고를지 말지 선택하고 depth+1번째 선분을 고려하기 위해 재귀로 넘어감
        // depth번째 선분을 선택한 경우, 선택하지 않은 경우로 두번의 재귀 호출
        selectedPair.add(pair.get(depth));
        backTracking(depth+1);
        selectedPair.remove(selectedPair.size()-1);
        backTracking(depth+1);
    }
    private static boolean inRange(){
        //조합 탐색 방식
        for(int i =0; i<selectedPair.size(); i++){
            for(int j = i+1; j<selectedPair.size(); j++){
                if(isSame(selectedPair.get(i), selectedPair.get(j))){
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean isSame(int[] a1, int[] a2){
        // 두 선분의 지점 4개가 다 겹쳐선 안됨
        // 4개의 케이스 중 하나라도 겹치면 불가
        return (a1[0] <= a2[0] && a2[0] <= a1[1]) || (a1[0] <= a2[1] && a2[1] <= a1[1])
        || (a2[0] <= a1[0] && a1[0] <= a2[1]) || (a2[0] <= a1[1] && a1[1] <= a2[1]);
    }
}