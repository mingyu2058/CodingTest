/**
 * 문제 : 여행가자
 * 링크 : https://www.acmicpc.net/problem/1976
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LetsTrip {
    static int N,M;
    static int parent[];
    static int target[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for(int i = 1; i <= N; i++) {
            tokenizer = new StringTokenizer(br.readLine());

            for(int j = 1; j <= N; j++) {
                int t = Integer.parseInt(tokenizer.nextToken());

                if(t==1) {
                    union(i,j);
                }
            }
        }

        target = new int[M];
        boolean result = true;
        tokenizer = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(tokenizer.nextToken()));
        for(int i = 1; i < M; i++) {
            if(start != find(Integer.parseInt(tokenizer.nextToken()))) {
                result = false;
            }
        }

        if(result == true) {
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }


    }
    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot < bRoot) {
            parent[aRoot] = bRoot;
        }
        else {
            parent[bRoot] = aRoot;
        }

    }
    static int find(int n) {
        if(parent[n] == n) {
            return n;
        }
        else return parent[n] = find(parent[n]);
    }

}
