import java.util.*;
import java.io.*;

public class Main {
    static String n;
    static int a,b;
    static String answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = br.readLine();
        casting();

        System.out.println(answer);
    }

    private static void casting(){
        answer = "";
        int num = 0;
        for(int i = 0; i<n.length(); i++){
            num = num * a + n.charAt(i)-'0';
        }
        
        int[] arr = new int[100000];
        int index = 0;

        while(true){
            if(num < b){
                arr[index++] = num;
                break;
            }
            arr[index++] = num % b;
            num/=b;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = index-1; i>=0; i--){
            sb.append(arr[i]);
        }

        answer = sb.toString();
    }
}