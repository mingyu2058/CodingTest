/**
 * 문제 : 숫자의 합
 * 링크 : https://www.acmicpc.net/problem/11720
 **/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfNumber {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        String num[] = br.readLine().split("");
        int sum = 0;

        for(int i = 0; i < testCase; i++){
            sum += Integer.parseInt(num[i]);
        }
        System.out.println(sum);

    }
}
