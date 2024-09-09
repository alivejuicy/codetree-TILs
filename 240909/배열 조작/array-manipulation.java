import java.io.*;
import java.util.*;

public class Main {
    static String P;
    static int n;
    static Queue<Integer> que = new ArrayDeque<>();
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
        try{
            for(int i= 0; i< P.length(); i++){
                char c = P.charAt(i);
                if(c == 'R'){
                    List<Integer> al = new ArrayList<>(que);
                    Collections.reverse(al);
                    que.clear();
                    que.addAll(al);
                }else if(c == 'D'){
                    que.poll();
                }else{
                    throw new Exception();
                }
            }
        }catch(Exception ex){
            System.out.println("error");
            return;
        }
        StringBuilder sb = new StringBuilder();
        while(!que.isEmpty()){
            sb.append(que.poll()).append(" ");
        }

        System.out.println(sb.toString());
    }
}