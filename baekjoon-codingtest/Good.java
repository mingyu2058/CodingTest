/**
 * 문제 : 좋다
 * 링크 : https://www.acmicpc.net/problem/1253
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Good {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[] arr = new int[n];
        boolean[] boolArr = new boolean[n];
        int result = 0;

        StringTokenizer tokenizer = new StringTokenizer(bf.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }


        int sum = arr[0] + arr[1];
        int firstPoint = 0;
        int endPoint = 1;

        for(int i = 2; i < n; i++) {
            while (true) {
                if (arr[i] == sum)
                    result++;
                else if (arr[i] < sum) {
                    firstPoint++;
                } else {
                    endPoint++;
                }
                if (firstPoint == endPoint)
                    break;
            }
        }

        System.out.println(result);

    }
    /*
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        //StringTokenizer tokenizer = new StringTokenizer(bf.readLine());

        int[] arr = new int[n];
        int[] positive = new int[n];
        int[] negative = new int[n];
        int positiveNum = 0;
        int negativeNum = 0;

        int t;
        int result = 0;

        String[] str = new String[n];
        str = bf.readLine().split(" ");

        for(int i = 0; i < 10; i++){
            //t = Integer.parseInt(tokenizer.nextToken());
            t = Integer.parseInt(str[i]);
            arr[i] = t;

            if(t >= 0)
                positive[positiveNum++] = t;
            else
                negative[negativeNum++] = t;
        }

        int pn = 0, nn = 0, sum;

        Arrays.sort(positive);
        Arrays.sort(negative);


        for(int i = 0; i < n; i++){
            t = arr[i];
            pn = 0;
            nn = 0;
            sum = 0;
            for(int j = 0; j < (positiveNum + negativeNum); j++) {
                sum = positive[pn] + negative[nn];
                if (sum == t) {
                    result++;
                    break;
                }
                else if (sum > 0) {
                    nn++;
                    if(nn == negativeNum){
                        break;
                    }
                }
                else {
                    pn++;
                    if(pn == positiveNum){
                        break;
                    }
                }

            }


        }

        System.out.println(result);
    }*/
}
