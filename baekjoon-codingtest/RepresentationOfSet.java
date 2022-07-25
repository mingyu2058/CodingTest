/**
 * 문제 : 집합의 표현
 * 링크 : https://www.acmicpc.net/problem/1717
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RepresentationOfSet {
    static int N,M;
    static AdjacentList list;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        list = new AdjacentList();

        // 리스트 초기화
        for (int i = 1; i < 1000001; i++) {
            list.vertex[i] = i;
            list.parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int select = Integer.parseInt(tokenizer.nextToken());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            // union 연산
            if (select == 0) {
                union(a, b);
            }
            // find 연산
            else{
                if(find(a) == find(b)){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }


        }

    }
    static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        list.parent[aRoot] = bRoot;
    }
    static int find(int a){
        if(list.parent[a]==a){
            return a;
        }
        else{
            return (list.parent[a] = find(list.parent[a]));
        }
    }
}
class AdjacentList{
    int[] vertex = new int[1000001];
    int[] parent = new int[1000001];


}
