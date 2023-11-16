import java.util.*;
import java.io.*;

class Student{
    int h;
    int w;
    int index;

    public Student(){}

    public Student(int h, int w, int index){
        this.h = h;
        this.w = w;
        this.index = index;
    }
}

//키 작은 순, 같으면 몸무게 더 큰 학생 앞으로
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int i;
        List<Student> al = new ArrayList<>();

        for(i = 1; i <=n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            al.add(new Student(h,w,i));
        }

        Collections.sort(al, new Comparator<Student>(){
                @Override
                public int compare(Student a, Student b){
                    if(a.h - b.h == 0) return b.w - a.w;

                    return a.h - b.h;
                }
        });

        for(Student s : al){
            System.out.println(s.h+" "+s.w+" "+s.index);
        }
    }
}