/**
 * 문제 : ACMCraft
 * 링크 : https://www.acmicpc.net/problem/1005
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ACMCraft{
    static int T;
    static int N,K,target;
    static int time[];
    static int weight[];
    static int count[];
    static ArrayList<Integer> list[];
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tokenizer;

        T = Integer.parseInt(br.readLine());
        queue = new LinkedList<Integer>();


        for(int i = 0; i < T; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            N = Integer.parseInt(tokenizer.nextToken());
            K = Integer.parseInt(tokenizer.nextToken());

            weight = new int[N+1];
            count = new int[N+1];
            time = new int[N+1];
            tokenizer = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                int t = Integer.parseInt(tokenizer.nextToken());
                time[j] = t;
                weight[j] = t;
            }

            list = new ArrayList[N+1];
            for(int j = 1; j <= N; j++) {
                list[j] = new ArrayList<Integer>();
            }

            for(int j = 0; j < K; j++) {
                tokenizer = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(tokenizer.nextToken());
                int b = Integer.parseInt(tokenizer.nextToken());
                list[a].add(b);
                count[b]++;
            }

            queue.clear();
            for(int j = 1; j <= N; j++) {
                if(count[j]==0) {
                    queue.add(j);
                }
            }


            target = Integer.parseInt(br.readLine());
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                for(int j = 0; j < list[cur].size(); j++) {
                    int next = list[cur].get(j);
                    weight[next] = Math.max(weight[next], weight[cur]+time[next]);
                    count[next]--;
                    if(count[next]==0) {
                        if(next==target) {
                            break;
                        }
                        queue.add(next);
                    }
                }
            }
            sb.append(weight[target]+"\n");
        }
        System.out.println(sb.toString());



    }
}
