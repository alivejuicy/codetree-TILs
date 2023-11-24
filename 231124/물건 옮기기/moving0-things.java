import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> hm = new HashMap<>();
        int ans = 0;

        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int loc = Integer.parseInt(st.nextToken());

            if(!hm.containsKey(num)) hm.put(num, loc);
            else 
                if(hm.get(num) != loc) ans++;
                hm.put(num, loc);
        }
        System.out.println(ans);
    }
}