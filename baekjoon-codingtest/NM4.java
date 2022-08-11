/**
 * 문제 : N과 M(4)
 * 링크 : https://www.acmicpc.net/problem/15652
 *
 **/

import java.io.*;
import java.util.StringTokenizer;

public class NM4 {
    static int N,M;
    static int Count;
    static BufferedWriter bw;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 1; i <= N; i++){
            dfs(i,"");
        }

        bw.flush();
        bw.close();
    }
    static void dfs(int num, String s) throws IOException {
        //체크인
        Count++;
        s += num;

        // 목적지 확인
        if(Count==M){
            s += "\n";
            bw.write(s);
        }
        s += " ";

        // 순회
        for(int i = num; i <= N; i++){
            if(Count < M)
                dfs(i,s);
        }


        // 체크아웃
        Count--;
    }

}
