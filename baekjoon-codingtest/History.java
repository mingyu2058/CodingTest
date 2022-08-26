/**
 * 문제 : 역사
 * 링크 : https://www.acmicpc.net/problem/1613
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class History {
    static int N,K,S;
    static int event[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());;

        N = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());

        event = new int[N+1][N+1];
        for(int i = 0; i < K; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            event[a][b] = -1;
            event[b][a] = 1;
        }

        for(int i = 1; i <= N; i++) {
            event[i][i] = -2;
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                for(int k = 1; k <= N; k++) {
                    if(event[j][k] == 0) {
                        if(event[j][i] == -1 && event[i][k] == -1) {
                            event[j][k] = -1;
                        }else if(event[j][i] == 1 && event[i][k] == 1) {
                            event[j][k] = 1;
                        }

                    }
                }
            }
        }

        S = Integer.parseInt(br.readLine());
        for(int i = 0; i < S; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            sb.append(event[a][b]+"\n");
        }


        System.out.print(sb.toString());


    }
}
