/**
 * 문제 : 피보나치 수 2 (2748번)
 * 링크 : https://www.acmicpc.net/problem/2748
 **/

import java.util.Scanner;

public class Fibonacci2 {
    public static void main(String args[]){
        int n;

        long  num[] = new long[20];
        num[0] = 0;
        num[1] = 1;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 2; i < 20; i++){
            num[i] = num[i-1] + num[i-2];
        }
        System.out.println(num[n]);

    }

}
