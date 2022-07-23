/**
 * 문제 : 순열의 순서
 * 링크 : https://www.acmicpc.net/problem/1722
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SequenceOfPermutations {
    static int N,K;
    static int nums[];
    static long fact[] = new long[21];
    static boolean visited[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        fact[0] = 1;

        for (int i = 1; i <= 20; i++) {
            fact[i] = fact[i-1] * i;
        }

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        K = Integer.parseInt(tokenizer.nextToken());

        if(K==1){
            long target = Long.parseLong(tokenizer.nextToken());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (visited[j]) {
                        continue;
                    }
                    if (target > fact[N - i - 1]) {
                        target -= fact[N - i - 1];
                    } else {
                        sb.append(j);
                        sb.append(" ");
                        visited[j] = true;  // 숫자 하나를 썼으니깐
                        break;
                    }

                }
            }
            System.out.println(sb.toString());
        }else if (K==2) {
            nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(tokenizer.nextToken());
            }
            long result = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 1; j < nums[i]; j++) {
                    if(visited[j]==false){
                        result += fact[N-i-1];
                    }
                }
                visited[nums[i]] = true;
            }
            System.out.println(result+1);
        }
    }
}
