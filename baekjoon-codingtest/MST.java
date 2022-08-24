/**
 * 문제 : 최소 스패닝 트리
 * 링크 : https://www.acmicpc.net/problem/1197
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MST {
    static int V,E;
    static int parent[];
    static long result = 0;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        V = Integer.parseInt(tokenizer.nextToken());
        E = Integer.parseInt(tokenizer.nextToken());

        parent = new int[V+1];
        for(int i = 1; i <= V; i++) {
            parent[i] = i;
        }
        PriorityQueue<int []> pq = new PriorityQueue<int []>(new Comparator<int []>() {
            @Override
            public int compare(int[] arg0, int[] arg1) {
                return arg0[2]-arg1[2];
            }
        });

        for(int i = 0; i < E; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());
            pq.add(new int[] {a,b,c});
        }

        while(!pq.isEmpty()) {
            int cur [] = pq.poll();
            int a = cur[0];
            int b = cur[1];
            int w = cur[2];

            if(find(a) != find(b)) {
                result += w;
                count++;
                union(a,b);
            }
            if(count==V) {
                break;
            }

        }
        System.out.println(result);
    }
    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        parent[aRoot] = bRoot;
    }
    static int find(int n) {
        if(parent[n] == n) {
            return n;
        }else {
            return parent[n] = find(parent[n]);
        }
    }

}
