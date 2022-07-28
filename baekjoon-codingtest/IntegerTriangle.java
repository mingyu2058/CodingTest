/**
 * 문제 : 정수 삼각형
 * 링크 : https://www.acmicpc.net/problem/1932
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IntegerTriangle {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        int[][] max = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        max[0][0] = arr[0][0];

        for (int i = 1; i < n; i++) {
            max[i][0] = max[i - 1][0] + arr[i][0];
            max[i][i] = max[i - 1][i - 1] + arr[i][i];

            for (int j = 1; j < i; j++) {
                int x = max[i-1][j-1] + arr[i][j];
                int y = max[i - 1][j] + arr[i][j];
                max[i][j] = Math.max(x, y);
            }
        }

        int answer = -1;

        for (int i = 0; i < n; i++) {
            if(max[n-1][i] > answer)
                answer = max[n - 1][i];
        }

        System.out.println(answer);

    }
}
