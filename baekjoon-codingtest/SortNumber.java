/**
 * 문제 : 수 정렬하기
 * 링크 : https://www.acmicpc.net/problem/2750
 **/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortNumber {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(arr);
        for(int i = 0; i < n; i++){
            System.out.println(arr[i]);
        }

    }
}
