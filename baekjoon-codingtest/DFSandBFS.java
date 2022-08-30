/**
 * 문제 : DFS와 BFS
 * 링크 : https://www.acmicpc.net/problem/1260
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFSandBFS {
    static int N, M, V, Count = 0;
    static boolean visited[];

    static StringBuilder sb = new StringBuilder();

    static Queue<Integer> queue = new LinkedList<Integer>();
    static ArrayList<Integer> adj[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        V = Integer.parseInt(tokenizer.nextToken());

        visited = new boolean[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        for(int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }

        dfs(V);

        sb.append("\n");
        Arrays.fill(visited, false);
        queue.add(V);
        bfs();

        System.out.print(sb);
    }

    static void dfs(int n) {
        // 체크인
        sb.append(n);
        visited[n] = true;
        Count++;

        // 목적지 확인
        if(Count == N){
            return;
        }
        sb.append(" ");
        // 순회
        for(int i = 0; i < adj[n].size(); i++) {
            int cur = adj[n].get(i);
            // 갈 수 있는가
            if(visited[cur]==false) {
                //간다
                dfs(cur);
            }
        }
    }


    static void bfs() {
        Count = 0;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if(visited[cur]==true)
                continue;

            visited[cur] = true;
            visited[cur] = true;
            sb.append(cur + " ");
            Count++;

            if(Count == N) {
                sb.append("\n");
                break;
            }

            for(int i = 0; i < adj[cur].size(); i++) {
                int next = adj[cur].get(i);
                if(visited[next]==false) {
                    queue.add(next);
                }
            }

        }
    }
}
