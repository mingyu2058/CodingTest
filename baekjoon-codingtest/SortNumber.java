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

        // Use Arrays.sort
        /*
        Arrays.sort(arr);
        */

        // Use Select sort
        /*
        int tmp;
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(arr[i] > arr[j]){
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        */

        // Use Bubble sort
        int tmp;
        for(int j = n-1; j >=1; j--) {
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = tmp;
                }
            }
        }


        for(int i = 0; i < n; i++){
            System.out.println(arr[i]);
        }

    }
}
