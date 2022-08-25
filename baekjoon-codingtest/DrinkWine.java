/**
 * 문제 : 포도주 시식
 * 링크 : https://www.acmicpc.net/problem/2156
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DrinkWine {
    static int N;
    static int glasses[];
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        glasses = new int[N+1];
        dp = new int[N+1];
        for(int i = 1; i <= N; i++) {
            glasses[i] = Integer.parseInt(br.readLine());
        }


        dp[1] = glasses[1];
        for(int i = 2; i <= N; i++) {
            if(i==2) {
                dp[i] = glasses[1]+glasses[2];
            }else if(i==3) {
                dp[i] = Math.max(dp[i-1], Math.max(glasses[1]+glasses[3], glasses[2]+glasses[3]));
            }else {
                dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+glasses[i], dp[i-3]+glasses[i]+glasses[i-1]));
            }

        }

        System.out.println(dp[N]);

    }
}
