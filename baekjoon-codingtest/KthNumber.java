/**
 * 문제 : K번째 수
 * 링크 : https://www.acmicpc.net/problem/11004
 **/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KthNumber {
    /*
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(bf.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(arr);
        System.out.println(arr[k-1]);

    }
    */
    
    public static void main(String args[]) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        int[] arr = new int[n];

        tokenizer = new StringTokenizer(bf.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        quicksort(arr,0,n-1,k-1);

        System.out.println(arr[k-1]);
    }
    public static void quicksort(int[] arr, int start, int end, int k){
        if(start < end){
            int pivot = partition(arr, start, end);
            if(pivot == k) {
                return;
            }
            else if(pivot > k){
                quicksort(arr,start,pivot-1,k);
            }
            else{
                quicksort(arr,pivot+1,end,k);
            }
        }

    }
    public static int partition(int[] arr, int start, int end) {
        int middle = (start + end) / 2;
        swap(arr, start, middle);
        int pivot = arr[start];
        int i = start, j = end;

        while (i < j) {
            while (pivot < arr[j]) {
                j--;
            }
            while (i < j && pivot >= arr[i]) {
                i++;
            }
            swap(arr, i, j);
        }
        arr[start] = arr[i];
        arr[i] = pivot;

        return i;
    }
    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }



}
