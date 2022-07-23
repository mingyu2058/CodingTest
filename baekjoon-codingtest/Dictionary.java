/**
 * 문제 : 사전
 * 링크 : https://www.acmicpc.net/problem/1256
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dictionary {
    static int N,M,K;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());

        dp = new int[201][201];

        if (K > combination(N + M, M)) {
            System.out.println(-1);
        }
        else{
            query(N,M,K);
            System.out.println(sb.toString());
        }

        // 파스칼 삼각형 2차원 배열 , 내가 짠 코드
        /*
        for (int i = 0; i <= N+M; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }
        for (int i = 1; i <= N+M; i++) {
            for (int j = 1; j <= N+M; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j-1];
            }
        }*/

    }
    public static void query(int n, int m, int k) {
        // 단어 끝에 도달
        if (n + m == 0) {
            return;
        }
        // z만 남은경우
        else if (n == 0) {
            sb.append('z');
            query(n,m-1,k);
        }
        // a만 남은 경우
        else if (m == 0) {
            sb.append('a');
            query(n - 1, m, k);
        }
        // a,z 둘다 남은 경우 a를 고를 때 조합 수를 보고 판단
        else {
            // z 기준으로 보고 있음
            int leftCount = combination(n+m-1,m);
            if (leftCount >= k){
                sb.append('a');
                query(n-1,m,k);
            }else{
                sb.append('z');
                query(n, m - 1, k - leftCount);
            }

        }
    }

    // 파스칼 삼각형 만들기 재귀 + dp
    public static int combination(int n, int r){
        if (n == r || r== 0){
            return 1;
        } else if(dp[n][r] != 0){
            return dp[n][r];
        } else{
            // k가 1e9라 , k 사용해도 가능
            return dp[n][r] = Math.min((int) 1e9, combination(n - 1, r - 1) + combination(n - 1, r));
        }
    }
}
