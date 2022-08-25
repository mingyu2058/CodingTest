/**
 * 문제 : 서강그라운드
 * 링크 : https://www.acmicpc.net/problem/14938
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SeogangGround {
    static int N,M,R;
    static int city[];
    static int floyd[][];
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        R = Integer.parseInt(tokenizer.nextToken());

        city = new int[N+1];
        tokenizer = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            city[i] = Integer.parseInt(tokenizer.nextToken());
        }

        floyd = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            Arrays.fill(floyd[i], 1000000000);
            floyd[i][i] = 0;
        }

        for(int i = 0; i < R; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());
            floyd[a][b] = Math.min(c, floyd[a][b]);
            floyd[b][a] = Math.min(c, floyd[b][a]);
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                for(int k = 1; k <= N; k++) {
                    floyd[j][k] = Math.min(floyd[j][k], floyd[j][i]+floyd[i][k]);
                }
            }
        }


        result = -1;
        for(int i = 1; i <= N; i++) {
            int tmp = 0;
            for(int j = 1; j <= N; j++) {
                if(floyd[i][j] <= M) {
                    tmp += city[j];
                }
            }
            result = Math.max(result, tmp);
        }

        System.out.println(result);
    }
}
