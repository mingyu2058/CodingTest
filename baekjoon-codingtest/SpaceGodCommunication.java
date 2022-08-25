/**
 * 문제 : 우주신과의 교감
 * 링크 : https://www.acmicpc.net/problem/1774
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SpaceGodCommunication {
    static int N,M;
    static int count = 0;
    static double result = 0.00;
    static int parent[];
    static Coordinate coor[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        parent = new int[N+1];
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        PriorityQueue<double []> pq = new PriorityQueue<double []>(new Comparator<double []>() {
            @Override
            public int compare(double[] arg0, double[] arg1) {
                if(arg0[2] - arg1[2] < 0)
                    return -1;
                else
                    return 1;
            }
        });


        coor = new Coordinate[N+1];
        for(int i = 1; i <= N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            coor[i] = new Coordinate(x,y);
        }

        for(int i = 1; i <= N-1; i++) {
            for(int j = i+1; j <= N; j++) {
                double x = Math.abs(coor[i].x - coor[j].x);
                double y = Math.abs(coor[i].y - coor[j].y);
                double length = Math.sqrt(x*x + y*y);
                pq.add(new double[] {i,j,length});
            }
        }

        for(int j = 0; j < M; j++) {
            tokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            pq.add(new double[] {a,b,0});
        }


        while(!pq.isEmpty()) {
            double cur[] = pq.poll();
            int a = (int) cur[0];
            int b = (int) cur[1];
            double w = cur[2];

            if(find(a) != find(b)) {
                result += w;
                count++;
                union(a,b);
            }
        }
        System.out.println(String.format("%.2f", result));
    }

    static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
        parent[aParent] = bParent;

    }

    static int find(int n) {
        if(parent[n] == n) {
            return n;
        }else {
            return parent[n] = find(parent[n]);
        }
    }

}
class Coordinate{
    int x,y;

    Coordinate(int x,int y){
        this.x = x;
        this.y = y;
    }
}
