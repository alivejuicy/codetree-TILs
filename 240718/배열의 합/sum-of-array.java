import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] array = new int[4][4];
        StringBuilder sb= new StringBuilder();
        int sum =0;
        for(int i =0; i<4; i++){
            st =new StringTokenizer(br.readLine());
            for(int j =0; j<4; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
                sum+= array[i][j];
            }
            sb.append(sum).append("\n");
            sum = 0;
        }
        System.out.println(sb.toString());
    }
}