/**
 * 문제 : 사탕박스
 * 링크 : https://www.acmicpc.net/problem/2243
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CandyBox {
    static int N;
    static int tree[];
    static int S;
    static int Max = 1000000;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        N = Integer.parseInt(br.readLine());

        S = 1;
        while (S < Max) {
            S *= 2;
        }

        // 총 갯수는 2*S
        tree = new int[2 * S];

        for (int i = 0; i < N; i++) {
            int a, b, c;
            tokenizer = new StringTokenizer(br.readLine());
            a = Integer.parseInt(tokenizer.nextToken());
            b = Integer.parseInt(tokenizer.nextToken());
            // 사탕 상자를 꺼낼 경우
            if (a == 1) {
                int index = query(1, S, 1, b);
                update(1, S, 1, index, -1);
                System.out.println(index);
            }
            // 사탕을 넣는 경우
            else {
                c = Integer.parseInt(tokenizer.nextToken());
                update(1, S, 1, b, c);
            }

        }
    }

    static int query(int left, int right, int node, int count) {
        // 1. leaf에 도착했을 때
        if (left == right) {
            return left;
        } else {
            int mid = (left + right) / 2;
            // 2. 왼쪽 >= count -> 왼쪽으로 이동
            if (tree[node * 2] >= count) {
                return query(left, mid, node * 2, count);
            }
            // 3. 왼쪽 < count 오른쪽으로 이동
            else {
                count -= tree[node * 2];
                return query(mid + 1, right, node * 2 + 1, count);
            }
        }
    }

    static void update(int left, int right, int node, int index, long diff) {
        if (left <= index && index <= right) {
            tree[node] += diff;
            if (left != right) { // leaf가 아니면
                int mid = (left + right) / 2;
                update(left, mid, node * 2, index, diff);
                update(mid + 1, right, node * 2 + 1, index, diff);
            }

        }
    }
}