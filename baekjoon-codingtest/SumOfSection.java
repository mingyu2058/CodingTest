/**
 * 문제 : 부분 합
 * 링크 : https://www.acmicpc.net/problem/1806
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfSection {
    static int N,S;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        S = Integer.parseInt(tokenizer.nextToken());


        int[] arr = new int[N+1];

        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int low = 0, high = 0, sum = arr[0];
        int length = Integer.MAX_VALUE;
        while(true){
            // sum이 클때
            if(sum >= S) {
                length = Math.min(high - low + 1, length);
                sum -= arr[low++];
            }
            // sum이 작을 때
            else{
                sum += arr[++high];
            }
            if(high==N){
                break;
            }

        }
        if(length != Integer.MAX_VALUE)
            System.out.println(length);
        else
            System.out.println(0);
    }
}
