/**
 * 문제 : 바이러스
 * 링크 : https://www.acmicpc.net/problem/2606
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Virus {
    static int N, M;
    static boolean visited[];
    static ArrayList<Integer> list[];
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        Queue<Integer> q = new LinkedList();
        q.add(1);
        visited[1] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int i = 0; i < list[cur].size(); i++) {
                int t = list[cur].get(i);
                if(visited[t] == false) {
                    q.add(t);
                    visited[t] = true;
                    result++;
                }
            }
        }

        System.out.println(result);

    }
}
