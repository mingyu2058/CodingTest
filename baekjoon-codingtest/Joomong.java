/**
 * 문제 : 주몽
 * 링크 : https://www.acmicpc.net/problem/1940
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Joomong {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        StringTokenizer tokenizer = new StringTokenizer(bf.readLine());

        int arr[] = new int[10000001];
        int result = 0;

        for(int i = 1; i <= n; i++){
            arr[Integer.parseInt(tokenizer.nextToken())]++;
        }

        int i = 1;

        while( i < (m-i)){
            if( (i!=m-i) && arr[i]==1 && arr[m-i]==1){
                arr[i] = 0;
                arr[m-i] =0;
                result++;
            }
            i++;
        }
/*
        for(int i = 1; i < m; i++){
            if( (i!=m-i) && arr[i]==1 && arr[m-i]==1){
                arr[i] = 0;
                arr[m-i] =0;
                result++;
            }
        }

 */
        System.out.println(result);
    }
}
