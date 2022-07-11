/**
 * 문제 : 피보나치 수 5 (10870번)
 * 링크 : https://www.acmicpc.net/problem/10870
 **/

import java.util.Scanner;

public class Fibonacci5 {

    // 기존 풀이(점화식 사용x)
    /*
    public static void main(String args[]) {
        int sum = 0, n1, n2;
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num == 0) System.out.println(0);
        else if (num == 1) System.out.println(1);
        else if (num == 2) System.out.println(1);
        else {
            n1 = 1;
            n2 = 1;
            sum = 1;

            for (int i = 0; i < num - 2; i++) {
                n1 = n2;
                n2 = sum;
                sum += n1;
            }
            System.out.println(sum);
        }
    }*/
    public static void main(String args[]){
        int n;

        int  num[] = new int[20];
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
