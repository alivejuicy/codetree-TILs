import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int answer;
    static Map<String, List<String>> hm = new HashMap<>();

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i =0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String element = st.nextToken();
            String group = st.nextToken();

            hm.putIfAbsent(group, new ArrayList<>());
            hm.get(group).add(element);
        }

        answer = 1;

        for(String group : hm.keySet()){
            int len = hm.get(group).size();
            answer *= (len+1);
        }
        answer -=1;
        System.out.println(answer);

    }
    // 물건을 고를 경우의수

    // 최소 1개 이상 고르고, 같은 그룹에선 1개만 고를 수 있다.
    // one two three 3
    // red one apple 
}