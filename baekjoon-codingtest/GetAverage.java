/**
 * 문제 : 평균
 * 링크 : https://www.acmicpc.net/problem/1546
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class GetAverage {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(bf.readLine());
        String num[] = bf.readLine().split(" ");
        ArrayList<Double> list = new ArrayList<>();
        double result = 0;

        for(int i = 0; i < testCase; i++){
            list.add(Double.parseDouble(num[i]));
        }
        list.sort(Comparator.naturalOrder());
        Double m = list.get(testCase-1);

        for(int i = 0; i < testCase; i++){
            result += list.get(i)/m*100;
        }

        System.out.println(result/testCase);
    }
}
