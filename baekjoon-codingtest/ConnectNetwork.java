import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ConnectNetwork {
    static int N, M;
    static int[] parent;
    static ArrayList<Integer>[] list;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        parent = new int[N+1];

        PriorityQueue<int[]> pq = new PriorityQueue<int []>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());
            pq.add(new int[]{a,b,c});
        }

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        int answer = 0;
        while(!pq.isEmpty()){
            int[] n = pq.poll();
            if(find(n[0]) != find(n[1])) {
                union(n[0], n[1]);
                answer += n[2];
            }
        }
        System.out.println(answer);


    }
    static int find(int x){
        if(parent[x] == x)
            return x;
        else
            return parent[x] = find(parent[x]);
    }
    static void union(int a,int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        parent[aRoot] = bRoot;
    }
}
