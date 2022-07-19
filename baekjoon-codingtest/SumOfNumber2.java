/**
 * 문제 : 두 배열의 합
 * 링크 : https://www.acmicpc.net/problem/2003
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfNumber2 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[] arr = new int[n+1]; // 배열 크기를 +1 로 해줘서 밑에 값을 처리할 수 있게 함

        tokenizer = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int low = 0, high = 0, sum = 0;
        int result = 0;
        sum = arr[0];

        while(true){
            // sum == M -> 답,  low++
            if(sum == m){
                result++;
                sum -= arr[low++];
            } else if(sum < m){
                sum += arr[++high];
            } else{
                sum -= arr[low++];
            }
            if(high==n) {
                break;
            }
        }
        System.out.println(result);
    }

}
