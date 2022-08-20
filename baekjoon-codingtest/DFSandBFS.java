import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DFSandBFS {
    static int N,M,V;
    static int Count = 0;
    static boolean visited[];
    static ArrayList<Integer> adj[];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        V = Integer.parseInt(tokenizer.nextToken());

        visited = new boolean[N+1];
        adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < M; i++){
            tokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            adj[a].add(b);
        }


        dfs(V,"");


    }
    static void dfs(int n, String s){
        // 체크인
        s += n;
        Count++;
        visited[n] = true;
        // 목적지 확인
        if(Count == N){
            s += "\n";
            System.out.println(s);
            return;
        }
        s += " ";
        // 순회
        for(int i = 0; i < adj[n].size(); i++) {
            int cur = adj[n].get(i);
            // 갈 수 있는가
            if(visited[cur]==false) {
                //간다
                dfs(cur,s);
            }

        }
    }
    static void bfs(){
        // 큐 뽑기
        // 목적지 확인
        // 순회
        // 갈 수 있는가
            // 큐에 삽입
    }
}
