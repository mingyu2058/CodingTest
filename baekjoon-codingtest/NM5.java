/**
 * 문제 : N과 M(5)
 * 링크 : https://www.acmicpc.net/problem/15654
 **/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NM5 {
    static int N,M;
    static boolean visited[];
    static int list[];
    static int Count = 0;
    static BufferedWriter bw;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        list = new int[N];
        visited = new boolean[N];

        tokenizer = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            list[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(list);

        for(int i = 0; i < N; i++){
            dfs(i,"");
        }

        bw.flush();
        bw.close();

    }
    static void dfs(int num, String s) throws IOException {
        // 체크인
        Count++;
        visited[num] = true;
        s += list[num];

        // 목적지
        if(Count == M){
            s += "\n";
            bw.write(s);
        }

        s += " ";

        // 순회
        for(int i = 0; i < N; i++){
            // 갈 수 있는가?
            if( Count < M  && visited[i] == false){
                dfs(i,s);
            }

        }

        // 체크아웃
        Count--;
        visited[num] = false;

    }
}
