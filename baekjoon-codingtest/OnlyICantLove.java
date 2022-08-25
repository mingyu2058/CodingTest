/**
 * 문제 : 나만 안되는 연애
 * 링크 : https://www.acmicpc.net/problem/14621
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class OnlyICantLove {
    static int N,M;
    static int parent[];
    static char school[];
    static int result = 0;
    static boolean visited[];
    static PriorityQueue<int []> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(br.readLine());
        school = new char[N+1];
        for(int i = 1; i <= N; i++) {
            school[i] = tokenizer.nextToken().charAt(0);
        }

        parent = new int[N+1];
        for(int i = 1; i <= N ; i++) {
            parent[i] = i;
        }

        queue = new PriorityQueue<int[]>(new Comparator<int []>() {
            @Override
            public int compare(int[] arg0, int[] arg1) {
                return arg0[2]-arg1[2];
            }
        });

        for(int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int w = Integer.parseInt(tokenizer.nextToken());

            if(school[a] != school[b]) {
                queue.add(new int[]{a,b,w});
            }
        }

        visited = new boolean[N+1];
        kruscal();

        boolean check = true;
        for(int i = 1; i <= N; i++) {
            if(visited[i] == false) {
                check = false;
                break;
            }
        }

        if(check == true) {
            System.out.println(result);
        }else {
            System.out.println(-1);
        }

    }
    static void kruscal(){
        while(!queue.isEmpty()) {
            int cur[] = queue.poll();


            if(find(cur[0]) != find(cur[1])) {
                visited[cur[0]] = true;
                visited[cur[1]] = true;
                union(cur[0], cur[1]);
                result += cur[2];
            }

        }
    }

    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot != bRoot) {
            parent[aRoot] = bRoot;
        }
    }

    static int find(int n) {
        if(parent[n] == n) {
            return n;
        }else {
            return parent[n] = find(parent[n]);
        }
    }


}
