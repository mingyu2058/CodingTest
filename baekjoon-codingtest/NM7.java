/**
 * 문제 : N과 M (7)
 * 링크 : https://www.acmicpc.net/problem/15656
 **/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NM7 {
    static int N,M;
    static BufferedWriter bw;
    static int arr[];
    static int Count;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        arr = new int[N];

        tokenizer = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(arr);

        for(int i = 0; i < N; i++){
            dfs(i,"");
        }

        bw.flush();
        bw.close();

    }
    static void dfs(int num,String s) throws IOException {
        // 체크인
        s += arr[num];
        Count++;

        // 목적지 확인
        if(Count == M){
            s += "\n";
            bw.write(s);
        }
        s += " ";

        // 순회
        for(int i = 0; i < N; i++){
            if(Count < M) {
                dfs(i, s);
            }
        }

        // 체크아웃
        Count--;
    }

}
