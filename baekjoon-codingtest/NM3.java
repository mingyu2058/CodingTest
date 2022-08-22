/**
 * 문제 : N과 M(3)
 * 링크 : https://www.acmicpc.net/problem/15651
 *
 **/

import java.io.*;
import java.util.StringTokenizer;

public class NM3 {
    static int N,M;
    static int count = 0;
    static BufferedWriter bw;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        for (int i = 1; i <= N; i++) {
            dfs(i,"");
        }

        bw.flush();
        bw.close();

    }
    static void dfs(int num, String s) throws IOException {
        // 체크인
        count++;
        s += num;
        // 확인 -> 출력
        if(count==M){
        //    System.out.println(s);
            s += "\n";
            bw.write(s);
        }
        s+= " ";

        // 순회
        for (int i = 1; i <= N; i++) {
            // 갈수 있는가?
            if(count < M) {
                //간다
                dfs(i, s);
            }
        }

        // 체크아웃
        count--;
    }
}
