import java.util.*;
import java.io.*;

class Weather{
    public String y;
    public String d;
    public String w;
    
    public Weather(String y, String d, String w){
        this.y=y;
        this.d=d;
        this.w=w;
    }

    public int[] casting(String s){
        String[] tmp = s.split("-");
        int[] arr = new int[3];
        int i = 0;
        for(String str : tmp){
            int num = Integer.parseInt(str);
            arr[i] = num;
            i++;
        }

        return arr;
    }
}


public class Main {
    private static final String SNOW = "Snow";
    private static final String RAIN = "Rain";
    static int minY = 3000;
    static int minM = 3000;
    static int minD = 3000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("start");
        //가장 근시에 비오는 날 찾기
        int n = Integer.parseInt(br.readLine());

        for(int i =0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String y = st.nextToken();
            String d = st.nextToken();
            String w = st.nextToken();

            if(!w.equals(RAIN)) continue;

            Weather weahter = new Weather(y,d,w);
            int[] tmp = weahter.casting(y);
            
            if(compare(tmp)){
                sb.setLength(0);
                sb.append(d).append(" ").append(w);
            }
        }
        if(minM<10) System.out.print(minY+"-"+0+minM+"-"+minD+" "+sb);
        else System.out.print(minY+"-"+minM+"-"+minD+" "+sb);
    }

    private static boolean compare(int[] tmp){
        //년월 같을 때 일 비교
            if(minY == tmp[0] && minM == tmp[1]){
                minD = Math.min(minD, tmp[2]);
                return true;
            }
            //년도 같을 때 월 비교
            if(minY == tmp[0] && tmp[1] < minM){
                minM = tmp[1];
                minD = tmp[2];
                return true;
            }

            //년도 비교
            if(tmp[0] < minY){
                minY = tmp[0];
                minM = tmp[1];
                minD = tmp[2];
                return true;
            } 

            return false;
    }
}