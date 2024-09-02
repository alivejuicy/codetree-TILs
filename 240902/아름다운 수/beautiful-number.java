import java.util.*;

public class Main {
    static int n;
    static List<Integer> al = new ArrayList<>();
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ans=0;
        getSolution(0);

        System.out.println(ans);
    }

    private static void getSolution(int depth){
        if(depth == n){
            if(isBeautiful()) ans++;
            return;
        }

        for(int i=1; i<=4; i++){
            al.add(i);
            getSolution(depth+1);
            al.remove(al.size()-1);
        }
    }

    private static boolean isBeautiful(){
        for(int i =0; i<n; i+= al.get(i)){
            if(i + al.get(i)-1>= n){
                return false;
            }
            for(int j = i; j<i+al.get(i); j++){
                if(al.get(j)!= al.get(i)){
                    return false;
                }
            }
        }
        return true;
    }
}


/*
한번에 아름다운 수를 만들지 말고,
1-4 사이 숫자로만 이루어진 숫자를 만들어낸 뒤
그 중에서 아름다운 수의 수를 세자.
*/