/**
 * 문제 : ATM
 * 링크 : https://www.acmicpc.net/problem/4013
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        int[] sum = new int[n];
        int result = 0;

        StringTokenizer tokenizer = new StringTokenizer(bf.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(arr);

        sum[0] = arr[0];
        result = arr[0];
        for(int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + arr[i];
            result += sum[i];
        }
        System.out.println(result);
    }

}
