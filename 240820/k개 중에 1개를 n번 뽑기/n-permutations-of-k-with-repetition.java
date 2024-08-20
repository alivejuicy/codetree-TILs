import java.io.*;
import java.util.*;

public class Main {
    static int K,N;
    static int[] numArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        N = sc.nextInt();
        numArr = new int[K];
        getSolution(0);
    }

    // depth: 0부터  idx: 1부터
    private static void getSolution(int depth){
        if(depth == N){
            for(int i=0; i<numArr.length; i++){
                System.out.print(numArr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i = 1; i<= K; i++){
            numArr[depth] = i;
            getSolution(depth+1);
        }
    }
}

/*
원하는 모든 조합을 만들어서 문제에서 요구하는 솔루션을 고른다.

Input이 작고, 모든 조합을 만드는데에 걸리는 시간이 주어진 제한시간보다
작다면, 모든 조합을 다 만들어 보는것이 가독성, 코드 작성 입장에서 가장 베스트 케이스가 된다.
*/