import java.io.*;
import java.util.*;

class Number{
    int element;
    int index;
    
    public Number(int element, int index){
        this.element = element;
        this.index = index;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Number> al = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            int tmp = Integer.parseInt(st.nextToken());
            //객체로 생성해서 리스트에 수열 저장
            al.add(new Number(tmp, i));
        }

        Collections.sort(al, new Comparator<Number>() {
            @Override
            public int compare(Number a, Number b){
                if(a.element == b.element) return a.index - b.index;
                return a.element - b.element;
            }
        });

        //리스트 오름차순 정렬하고
        

        // 3(1) 1(2) 6(3) ..
        // 1 1 2 3 6 7 30 (원소, 기존 인덱스)
        // 2 7 6
        int[] ans = new int[n];
        
        for(int i =0; i<n; i++){
            ans[al.get(i).index] = i+1;
        }
        
        for(int i = 0; i<n; i++){
            System.out.print(ans[i]+" ");
        }
    }
}