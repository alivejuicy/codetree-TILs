import java.io.*;
import java.util.*;

public class Main {
    static String P;
    static int n;
    static Deque<Integer> que = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        P = br.readLine();
        n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            que.offer(Integer.parseInt(st.nextToken()));
        }
        getSolution();
    }
    private static void getSolution(){
        boolean reverse = false;
        try{
            for(int i= 0; i< P.length(); i++){
                char c = P.charAt(i);
                if(c == 'R'){
                   reverse = !reverse;

                }else if(c == 'D'){
                    if(que.isEmpty()){
                        throw new Exception();
                    }
                    if(reverse){
                        que.pollLast();
                    }else{
                        que.pollFirst();
                    }
                }
            }
        }catch(Exception ex){
            System.out.println("error");
            return;
        }

        StringBuilder sb = new StringBuilder();
        while(!que.isEmpty()){
            if(reverse){
                sb.append(que.pollLast()).append(" ");
            }else{
                sb.append(que.pollFirst()).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}