import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Workbook {
    static int N,M;
    static int problem[];
    static int count[];
    static boolean visited[];
    static ArrayList<Integer> list[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        visited = new boolean[N+1];
        count = new int[N+1];
        problem = new int[N+1];
        for(int i = 1; i <= N; i++) {
            problem[i] = 1;
        }

        list = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            list[a].add(b);
            count[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int i = 1; i <= N; i++) {
            if(count[i] == 0) {
                pq.add(i);
            }
        }

        while(!pq.isEmpty()) {
            int cur = pq.poll();
            visited[cur] = true;
            sb.append(cur+" ");

            for(int i = 0; i < list[cur].size(); i++) {
                int next = list[cur].get(i);
                count[next]--;
                if(count[next] == 0 && visited[next] == false) {
                    pq.add(next);
                }

            }
        }

        System.out.print(sb.toString());
    }
}
