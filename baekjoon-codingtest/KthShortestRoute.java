/**
 * 문제 : k번째 최단경로 찾기
 * 링크 : https://www.acmicpc.net/problem/1854
 **/
import java.io.*;
import java.util.*;
public class KthShortestRoute {
    static int N, M, K;
    static ArrayList<int[]> adj[];
    static List<Integer> dist[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        dist = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<int[]>();
            dist[i] = new ArrayList<Integer>();
        }
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new int[] {v, w});
        }
        dijkstra();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(dist[i].size() == K ? dist[i].get(K-1) : -1).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void dijkstra() {
        // PriorityQueue 가중치 오름차순 정렬
        PriorityQueue<Route> pq = new PriorityQueue<Route>();
        pq.offer(new Route(1, 0));
        int doneCnt = 0;
        while (!pq.isEmpty()) {
            // 현재 Vertex 뽑기 
            Route curr = pq.poll();

            // Vertex의 크기가 K보다 작을 때 Vertex 에다가 가중치 추가
            if (dist[curr.v].size() < K) dist[curr.v].add(curr.w);
            else continue;

            // vertext의 크기가 K랑 같다면 카운트 증가
            if (dist[curr.v].size() == K) doneCnt++;

            // 카운트가 N이랑 같다면 모든 순회 끝 -> 반복문 종료
            if (doneCnt == N) break;

            // vertex의 인접 리스트 => next
            for (int[] next : adj[curr.v]) {
                // next의 vertex
                int v = next[0];
                // next의 가중치
                int c = next[1];

                // 새로 추가될 가중치 ( next이전의 curr의 가중치 + next의 가중치 )
                int tc = curr.w + c;

                // curr의 인접 리스트 next의 크기가 K 보다 작다면
                if (dist[v].size() < K) {
                    pq.offer(new Route(v, tc));
                }
            }
        }
    }
    public static class Route implements Comparable<Route> {
        int v, w;

        public Route(int v, int w) {
            super();
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Route o) {
            return this.w - o.w;
        }
    }
}