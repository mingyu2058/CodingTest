/**
 * 문제 : 피보나치 수 5 (10870번)
 * 링크 : https://www.acmicpc.net/problem/10870
 **/

import java.util.Scanner;

public class Fibonacci5 {
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
    }

}
