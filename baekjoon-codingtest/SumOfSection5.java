/**
 * 문제 : 구간 합 구하기 5
 * 링크 : https://www.acmicpc.net/problem/11660
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfSection5 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int testCase = Integer.parseInt(tokenizer.nextToken());

        //String firstLine[] = bf.readLine().split(" ");
        //int n = Integer.parseInt(firstLine[0]);
        //int testCase = Integer.parseInt(firstLine[1]);

        int sum[][] = new int[n+1][n+1];
        int table[][] = new int[n+1][n+1];
        //String line[] = new String[n];

        for(int i = 1; i <= n; i++){
            tokenizer = new StringTokenizer(bf.readLine());
            sum[i][0] = 0;
            for(int j = 1; j <= n; j++){
                table[i][j] = Integer.parseInt(tokenizer.nextToken());
                //sum[i][j] = sum[i][j-1] + Integer.parseInt(tokenizer.nextToken());
                //sum[i][j] = sum[i][j-1] + Integer.parseInt(line[j-1]);
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + table[i][j];
            }
        }

        for(int t = 0; t < testCase; t++){
            tokenizer = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(tokenizer.nextToken()), y1 = Integer.parseInt(tokenizer.nextToken());
            int x2 = Integer.parseInt(tokenizer.nextToken()), y2 = Integer.parseInt(tokenizer.nextToken());

            int result = 0;

            if(x1==x2 && y1 == y2){
                 result = table[x1][y1];;
            }
            else {
                result = sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1];
            }

            System.out.println(result);
        }

    }
}
