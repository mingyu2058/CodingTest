/**
 * 문제 : 경로 찾기
 * 링크 : https://www.acmicpc.net/problem/11403
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindRoute {
    static int N;
    static int dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tokenizer;

        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            Arrays.fill(dp[i], 0);
        }


        for(int i = 1; i <= N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                dp[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                for(int k = 1; k <= N; k++) {
                    if(dp[j][k] == 0) {
                        dp[j][k] = (dp[j][i] + dp[i][k] == 2) ? 1 : 0;
                    }


                }
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                sb.append(dp[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);


    }
}
