/**
 * 문제 : 나머지 합
 * 링크 : https://www.acmicpc.net/problem/10986
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfRemainder {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer =  new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        long result = 0;

        long sum[] = new long[n];
        long remainder[] = new long[m];


        tokenizer = new StringTokenizer(bf.readLine());

        sum[0] = Integer.parseInt(tokenizer.nextToken());

        for(int i = 1; i < n; i++){
            //arr[i] = Integer.parseInt(tokenizer.nextToken());
            sum[i] = sum[i-1] + Integer.parseInt(tokenizer.nextToken());
//            remainder[sum[i]%m]++;
//            if(sum[i]%m==0)
//                result++;
        }
        for(int i = 0; i < n; i++){
            remainder[(int) (sum[i]%m)]++;
            if(sum[i]%m==0)
                result++;
        }

        for(int i = 0; i < m; i++){
            if(remainder[i] > 1) {
                result += remainder[i] * (remainder[i] - 1) / 2;
            }
        }

// 초기 계산 - 시간초과
/* 
        for(int i = n; i >= 1; i--){
            for(int j = 0; j < i; j++){
                if((sum[i] - sum[j]) % m == 0){
                    result++;
                }
            }
        }
*/
        System.out.println(result);
    }
}
