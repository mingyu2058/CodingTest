/**
 * 문제 : 최솟값과 최댓값
 * 링크 : https://www.acmicpc.net/problem/2357
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MinAndMax {
    static int N,M;
    static int S = 1;
    static int value[];
    static int minTree[];
    static int maxTree[];
    static int MIN,MAX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        while(S < N) {
            S *=2;
        }
        minTree = new int[2*S];
        maxTree = new int[2*S];
        Arrays.fill(minTree, Integer.MAX_VALUE);

        value = new int[N];
        for(int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        initMax();
        initMin();

        for(int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int bottom = Integer.parseInt(tokenizer.nextToken());
            int top = Integer.parseInt(tokenizer.nextToken());
            MIN = Integer.MAX_VALUE;
            MAX = Integer.MIN_VALUE;

            minQuery(1,S,1,bottom,top);
            maxQuery(1,S,1,bottom,top);

            sb.append(MIN+" "+MAX+"\n");
        }
        System.out.print(sb.toString());
    }

    static void initMax() {
        for(int i = 0; i < N; i++) {
            maxTree[S+i] = value[i];
        }
        for(int i = S-1; i > 0; i--) {
            maxTree[i] = Math.max(maxTree[i*2], maxTree[i*2+1]);
        }
    }

    static void initMin() {
        for(int i = 0; i < N; i++) {
            minTree[S+i] = value[i];
        }
        for(int i = S-1; i > 0; i--) {
            minTree[i] = Math.min(minTree[i*2], minTree[i*2+1]);
        }
    }



    static void minQuery(int left, int right, int node, int queryLeft, int queryRight) {
        int mid = (left+right)/2;
        //System.out.print(left+" "+right+" "+node+" "+queryLeft+" "+queryRight+"\n");
        // 범위 밖
        if(right < queryLeft || left > queryRight) {
            return ;
        }
        // 범위 안
        else if(left >= queryLeft && right <= queryRight) {
            // 노드 찾기 (left~right)
            MIN = Math.min(minTree[node], MIN);
        }
        // 애매
        else {
            // 내려 보내기
            minQuery(left,mid,node*2,queryLeft,queryRight);
            minQuery(mid+1,right,node*2+1,queryLeft,queryRight);
        }
    }

    static void maxQuery(int left, int right, int node, int queryLeft, int queryRight) {
        int mid = (left+right)/2;
        // 범위 밖
        if(right < queryLeft || left > queryRight) {
            return;
        }
        // 범위 안
        else if(left >= queryLeft && right <= queryRight) {
            // 노드 찾기 (left~right)
            MAX = Math.max(maxTree[node], MAX);
        }
        // 애매
        else {
            // 내려 보내기
            maxQuery(left,mid,node*2,queryLeft,queryRight);
            maxQuery(mid+1,right,node*2+1,queryLeft,queryRight);
        }
    }


}
