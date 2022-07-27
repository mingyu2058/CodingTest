/**
 * 문제 : 줄 세우기
 * 링크 : https://www.acmicpc.net/problem/2252
 **/

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LineUp {
    static int N,M;
    static Queue answer;

    static int count[];
    static ArrayList<Integer> list[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        answer = new LinkedList();
        list = new ArrayList[N+1];
        count = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            count[i] = 0;
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            list[a].add(b);
            // 키가 큰 애들 카운트
            count[b]++;
        }

        for (int i = 1; i <= N; i++) {
            if (count[i] == 0) {
                answer.add(i);
            }
        }

        while(!answer.isEmpty()) {
            // queue 값이 0인 애들 빼기 -n
            int n = (int) answer.poll();
            System.out.print(n + " ");

            // list[n]의 값들 가져오기
            for (int i = 0; i < list[n].size(); i++) {
                int tmp = list[n].get(i);
                // list[n]의 값에 해당하는 count 빼기 -> n보다 큰 사람 카운트 빼기
                count[tmp]--;
                // count[tmp]가 0이면 queue에 넣기
                if(count[tmp]==0)
                    answer.add(tmp);
            }
        }


    }
}
