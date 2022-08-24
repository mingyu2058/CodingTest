/**
 * 문제 : 숨바꼭질3
 * 링크 : https://www.acmicpc.net/problem/13549
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class HideAndSeek3 {
    static int MAX = 100001;
    static int N, K;
    static int cost[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());

        cost = new int[MAX];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[N] = 0;

        dijkstra();
        System.out.print(cost[K]);
    }

    static void dijkstra() {
        PriorityQueue<CoordinateV2> pq = new PriorityQueue<CoordinateV2>();
        pq.add(new CoordinateV2(N, 0));

        while (!pq.isEmpty()) {
            CoordinateV2 cur = pq.poll();

            int next = cur.v + 1;
            if (next < MAX && cost[next] > cur.w + 1) {
                cost[next] = cur.w + 1;
                pq.add(new CoordinateV2(next, cost[next]));
            }

            next = cur.v - 1;
            if (next >= 0 && cost[next] > cur.w + 1) {
                cost[next] = cur.w + 1;
                pq.add(new CoordinateV2(next, cost[next]));
            }

            next = cur.v*2;
            if (next < MAX && cost[next] > cur.w) {
                cost[next] = cur.w;
                pq.add(new CoordinateV2(next, cost[next]));
            }

        }
    }
}

class CoordinateV2 implements Comparable<CoordinateV2> {
    int v;
    int w;

    CoordinateV2(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(CoordinateV2 arg0) {
        return this.w - arg0.w;
    }
}
