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

        int sum[][] = new int[n][n+1];
        String line[];

        for(int i = 0; i < n; i++){
            tokenizer = new StringTokenizer(bf.readLine());

            //line = bf.readLine().split(" ");
            sum[i][0] = 0;
            for(int j = 1; j <= n; j++){
                sum[i][j] = sum[i][j-1] + Integer.parseInt(tokenizer.nextToken());
                //sum[i][j] = sum[i][j-1] + Integer.parseInt(line[j-1]);
            }

        }

        for(int t = 0; t < testCase; t++){
            tokenizer = new StringTokenizer(bf.readLine());

            int x1 = Integer.parseInt(tokenizer.nextToken()), y1 = Integer.parseInt(tokenizer.nextToken());
            int x2 = Integer.parseInt(tokenizer.nextToken()), y2 = Integer.parseInt(tokenizer.nextToken());

            //line = bf.readLine().split(" ");
            //int x1 = Integer.parseInt(line[0]), y1 = Integer.parseInt(line[1]);
            //int x2 = Integer.parseInt(line[2]), y2 = Integer.parseInt(line[3]);

            int result = 0;

            if(x1==x2){
             if(y1 == y2){
                 result = sum[x1-1][y1] - sum[x1-1][y1-1];
             }
             else{
                 result = sum[x2-1][y2] - sum[x1-1][y1-1];
             }
            }
            else {
                for (int x = x1; x <= x2; x++) {
                    result += sum[x-1][y2] - sum[x-1][y1 - 1];
                }
            }
            System.out.println(result);
        }

    }
}
