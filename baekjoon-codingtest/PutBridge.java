/**
 * 문제 : 다리 놓기(1010)
 * 링크 : https://www.acmicpc.net/problem/1010
 **/

import java.util.Scanner;

public class PutBridge {
    // 기존 풀이
    /*
    public static void main(String args[]) {
        int dp[][] = new int[31][31];

        Scanner sc = new Scanner(System.in);

        dp[0][0] = 0;
        for (int i = 1; i < 31; i++) {
            dp[i][i] = 1;
            dp[1][i] = i;
        }

        int sum = 0;

        // 왼쪽 site 갯수
        for (int j = 2; j < 31; j++) {
            // 오른쪽 site 갯수
            for (int k = j + 1; k < 31; k++) {
                // 덧셈
                for (int l = 1; ; l++) {
                    sum += dp[j - 1][k - l];
                    if (j - 1 == k - l) break;
                    ;
                }
                dp[j][k] = sum;
                sum = 0;
            }
        }

        int t = sc.nextInt();

        //테스트 횟수
        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(dp[n][m]);
        }
    }*/

    // 조합 사용
    public static void main(String args[]){
        int dp[][] = new int[31][31];

        
        Scanner sc = new Scanner(System.in);

        dp[0][0] = 0;

        for(int i = 0; i < 31; i++) dp[1][i] = i;

        // i = n => left site
        for(int i = 2; i < 31; i++){
            dp[i][i] = 1;
            // j = m => right site
            for(int j = i+1; j < 31; j++){
                dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
            }
        }

        int t = sc.nextInt();

        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(dp[n][m]);
        }

    }
}
