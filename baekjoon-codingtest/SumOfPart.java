/**
 * 문제 : 구간 합 구하기
 * 링크 : https://www.acmicpc.net/problem/2402
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfPart {
    static int N,K,M, S;
    static long nums[];
    static long tree[];

    public static void  main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());
        S = 1;

        while (S < N) {
            S *= 2;
        }
        nums = new long[N];
        tree = new long[2 * S];

        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }

        init();


        for (int i = 0; i < K + M; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            long b = Long.parseLong(tokenizer.nextToken());
            long c = Long.parseLong(tokenizer.nextToken());
            // 변경시 ( update)
            if(a==1){
                update(b,c);
            }
            // 구간 합 구할시 ( query)
            else {
                System.out.println(query(1,S,1,b,c));
            }
        }
    }
    static void init() {
        for (int i = 0; i < N; i++) {
            tree[S+i] = nums[i];
        }
        for (int i = S - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }
    static long query(int left,int right, int node, long leftNode, long rightNode){
        // 구간 합 만족 x
        if(left > rightNode || right < leftNode){
            return 0;
        }
        // 구간 합 만족
        else if(left >= leftNode && right <= rightNode){
            return tree[node];
        }
        // 구간 합 판정 불가
        else {
            int mid = (left + right) / 2;
            long leftQuery = query(left, mid, 2 * node, leftNode, rightNode);
            long rightQuery = query(mid + 1, right, 2 * node + 1, leftNode, rightNode);
            return leftQuery + rightQuery;
        }
    }
    static void update(long target, long value){
        int t = (int) (S + target -1);
        tree[t] = value;
        t /= 2;
        while(t>0){
            tree[t] = tree[t*2]+tree[t*2+1];
            t /= 2;
        }
    }
}
