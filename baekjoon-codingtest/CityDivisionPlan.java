/**
 * 문제 : 도시 분할 계획
 * 링크 : https://www.acmicpc.net/problem/1647
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CityDivisionPlan {
    static int N,M;
    static int parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        parent = new int[N+1];
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }


        PriorityQueue<int []> pq = new PriorityQueue<int []>(new Comparator<int []>() {
            @Override
            public int compare(int[] arg0, int[] arg1) {
                // TODO Auto-generated method stub
                return arg0[2] - arg1[2];
            }
        });

        for(int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int w = Integer.parseInt(tokenizer.nextToken());

            pq.add(new int[] {a,b,w});
        }

        int tmp = 0;
        long w = 0;
        while(!pq.isEmpty()) {
            int cur[] = pq.poll();

            int aRoot = find(cur[0]);
            int bRoot = find(cur[1]);
            if(aRoot != bRoot) {
                w += cur[2];
                tmp = cur[2];
                union(cur[0],cur[1]);
            }
        }

        w -= tmp;

        System.out.print(w);


    }

    static void union(int a, int b) {
        int aRoot = parent[a];
        int bRoot = parent[b];

        if(aRoot!=bRoot) {
            parent[aRoot] = bRoot;
        }
    }
    static int find(int n) {
        if(parent[n]==n) {
            return n;
        }
        return parent[n] = find(parent[n]);
    }


}
