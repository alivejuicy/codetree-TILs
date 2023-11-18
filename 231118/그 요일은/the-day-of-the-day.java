import java.util.*;
import java.io.*;

public class Main {
    static int[] month = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] sevenDays = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        String s = br.readLine();

        int start = calc(m1, d1);
        int end = calc(m2, d2);
        
        //일 수의 차이를 먼저 구하고
        int tmp = end - start; 
        //A 요일이 나오는 개수 세서 리턴하기
        System.out.println(solution(tmp,s));
    }

    private static int calc(int m, int d){
        int days = 0;
        for(int i = 1; i<m; i++){
            days+=month[i];
        }
        days+=d;
        return days;
    }

    private static int solution(int tmp, String s){
        int ans = 0;
        int target = 0;

        for(int i =0; i<sevenDays.length; i++){
            if(s.equals(sevenDays[i])) {
                target = i;
                break;
            }
        }

        while(tmp > 0){
            if(tmp %  7 == target){
                ans++;
            }
            tmp--;
        }

        return ans;
    }
}