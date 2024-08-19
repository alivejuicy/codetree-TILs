import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        // my-algorithm
        // 2차원 배열을 이름순으로 정렬한 후에 -> 1차원으로 줄마다 받아서
        // 맵에다 담아서 키가 잇으면 +1 -> 키를 str형의 조합 전체로 만든다.
        // 가장 많은 조합의 값을 출력
        Map<String, Integer> hm = new HashMap<>();
        String key = "";
        for(int i =0; i<N; i++){
           String[] arr = br.readLine().split(" ");

           Arrays.sort(arr);
           key = String.join(" ", arr);

           hm.put(key, hm.getOrDefault(key, 0)+1);
        }
        
        int ans = Collections.max(hm.values());
        System.out.println(ans);
    }
}