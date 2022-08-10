/**
 * 문제 : N과 M(2)
 * 링크 : https://www.acmicpc.net/problem/15650
 *
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NM2 {
    static int N,M;
    static boolean visited[];
    static int count = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            dfs(i,"");
        }
    }
    static void dfs(int num,String s){
        // 체크인
        visited[num] = true;
        count++;
        s += num;
        // 확인 -> 출력
        if(count == M){
            System.out.println(s);
        }
        s += " ";

        // 순회
        for(int i = num+1; i <= N; i++) {
            // 갈 수 있는가
            if (visited[i] == false) {
                // 간다
                dfs(i, s);
            }
        }
        // 체크아웃
        visited[num] = false;
        count--;
    }

}
