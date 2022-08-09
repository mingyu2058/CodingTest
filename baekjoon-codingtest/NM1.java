/**
 * 문제 : N 과 M(1)
 * 링크 : https://www.acmicpc.net/problem/15649
 * **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NM1 {
    static boolean[] visited;
    static int N,M,L;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        L = M + M - 1;

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            dfs(i,"");
        }

    }
    static void dfs(int n, String s) {

        // 체크인
        visited[n] = true;
        s += Integer.toString(n);

        // 정답 확인
        if (s.length() == L) {
            System.out.println(s);
        }
        s += " ";

        // 순회
        for (int i = 1; i <= N; i++) {
            // 갈 수 있는가?
            if (visited[i] == false) {
                //간다
                dfs(i, s);
            }
        }
        visited[n] = false;

    }
}
