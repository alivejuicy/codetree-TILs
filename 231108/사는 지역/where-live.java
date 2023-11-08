import java.util.*;
import java.io.*;

class People{
    private String name;
    private String address;
    private String place;

    public People(){}

    public People(String name, String address, String place){
        this.name=name;
        this.address = address;
        this.place=place;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public String getPlace(){
        return place;
    }
}

public class Main {
    public static List<People> peopleList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i =0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String na = st.nextToken();
            String a = st.nextToken();
            String p = st.nextToken();

            peopleList.add(new People(na,a,p));
            //동명이인 없음
        }
        
        Collections.sort(peopleList, (o1, o2) ->
                                o1.getName().compareTo(o2.getName()));

        People answer = peopleList.get(peopleList.size()-1);
        System.out.println("name "+ answer.getName());
        System.out.println("addr "+answer.getAddress());
        System.out.println("city "+answer.getPlace());
    }
}