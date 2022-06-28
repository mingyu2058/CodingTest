/**
 * 문제 : 구간 합 구하기 4
 * 링크 : https://www.acmicpc.net/problem/11659
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfSection4 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String firstLine[] = bf.readLine().split(" ");
        String secondLine[] = bf.readLine().split(" ");

        int n = Integer.parseInt(firstLine[0]);
        int testCase = Integer.parseInt(firstLine[1]);
        int num[] = new int[n+1];
        int sum[] = new int[n+1];


        num[0] = 0;
        sum[0] = 0;
        for(int i = 1; i <= n; i++){
            num[i] = Integer.parseInt(secondLine[i-1]);
            sum[i] = sum[i-1] + num[i];
        }

        for(int i = 0; i < testCase; i++){
            String section[] = bf.readLine().split(" ");
            int start = Integer.parseInt(section[0]);
            int end = Integer.parseInt(section[1]);

            System.out.println(sum[end] - sum[start-1]);
        }

    }
}
