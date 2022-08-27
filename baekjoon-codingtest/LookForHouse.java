/**
 * 문제 : 집 구하기
 * 링크 : https://www.acmicpc.net/problem/13911
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class LookForHouse {
    static int Min = Integer.MAX_VALUE;
    static int V,E, M, MC, S, SC;
    static int costMAC[];
    static int costStar[];
    static ArrayList<int []> list[];
    static PriorityQueue<int []> pq;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());


        pq = new PriorityQueue<int []>(new Comparator<int []>() {
            @Override
            public int compare(int[] arg0, int[] arg1) {
                return arg0[1] - arg1[1];
            }
        });

        V = Integer.parseInt(tokenizer.nextToken());
        E = Integer.parseInt(tokenizer.nextToken());

        list = new ArrayList[V+1];
        for(int i = 1; i <= V; i++) {
            list[i] = new ArrayList<int []>();
        }

        for(int i = 0; i < E; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int w = Integer.parseInt(tokenizer.nextToken());

            list[a].add(new int[] {b,w});
            list[b].add(new int[] {a,w});
        }

        tokenizer =new StringTokenizer(br.readLine());
        M = Integer.parseInt(tokenizer.nextToken());
        MC = Integer.parseInt(tokenizer.nextToken());
        costMAC = new int[V+1];

        Arrays.fill(costMAC, Integer.MAX_VALUE);
        tokenizer = new StringTokenizer(br.readLine());
        for(int i = 1; i <= M; i++) {
            int t = Integer.parseInt(tokenizer.nextToken());
            costMAC[t] = 0;
            pq.add(new int[] {t,0});
        }

        dijkstra(costMAC);


        pq.clear();
        tokenizer = new StringTokenizer(br.readLine());
        S = Integer.parseInt(tokenizer.nextToken());
        SC = Integer.parseInt(tokenizer.nextToken());
        costStar = new int[V+1];

        Arrays.fill(costStar, Integer.MAX_VALUE);
        tokenizer = new StringTokenizer(br.readLine());
        for(int i = 1; i <= S; i++) {
            int t = Integer.parseInt(tokenizer.nextToken());
            costStar[t] = 0;
            pq.add(new int[] {t,0});
        }

        dijkstra(costStar);


        for(int i = 1; i <= V; i++) {
            if(costMAC[i] != 0 && costMAC[i] <= MC && costStar[i] != 0 && costStar[i] <= SC) {
                Min = Math.min(costMAC[i]+costStar[i] , Min);
            }
        }
        if(Min == Integer.MAX_VALUE) {
            sb.append(-1);
        }else {
            sb.append(Min);
        }

        System.out.print(sb.toString());
    }
    static void dijkstra(int distance[]) {

        while(!pq.isEmpty()) {
            int cur[] = pq.poll();
            int curIndex = cur[0];
            int curWeight = cur[1];

            for(int i = 0; i < list[curIndex].size(); i++) {
                int next[] = list[curIndex].get(i);

                if(distance[next[0]] > curWeight + next[1]) {
                    pq.add(new int[] {next[0], curWeight+next[1]});
                    distance[next[0]] = curWeight+next[1];
                }
            }

        }
    }


}
