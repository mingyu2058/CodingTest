/**
 * 문제 : N과 M (6)
 * 링크 : https://www.acmicpc.net/problem/15655
 **/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NM6 {
    static int N,M,Count;
    static int arr[];
    static BufferedWriter bw;

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
        for(int i = num+1; i < N; i++){
            // 갈 수 있는가?
            if( Count < N ) {
                // 간다
                dfs(i, s);
            }
        }

        // 체크아웃
        Count--;

    }

}
