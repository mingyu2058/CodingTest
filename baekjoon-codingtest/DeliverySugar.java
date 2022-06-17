/**
 * 문제 : 설탕배달
 * 링크 : https://www.acmicpc.net/problem/2839
 **/


import java.util.Arrays;
import java.util.Scanner;

public class DeliverySugar {
    public static void main(String args[]){
        int n;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int dp[] = new int[5001];
        Arrays.fill(dp,5001);

        dp[5] = 1;
        dp[3] = 1;

        for(int i = 6; i < 5001; i++){
            dp[i] = Math.min(dp[i-3]+1, dp[i-5]+1);
        }

        if(dp[n]>=5001)
            System.out.println(-1);
        else
            System.out.println(dp[n]);
    }

}
