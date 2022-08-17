/**
 * 문제 : N과 M (9)
 * 링크 : https://www.acmicpc.net/problem/15658
 **/

import java.io.*;
import java.util.*;

public class NM9 {
    static int N,M;
    static int Count = 0;
    static int arr[];
    static boolean visited[];
    static BufferedWriter bw;
    static ArrayList list;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        visited = new boolean[N];
        arr = new int[N];
        list = new ArrayList<String>();

        tokenizer = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++){
            if(i == 0 ||  ( i > 0 && arr[i] != arr[i-1] ))
                dfs(i,"");
        }

        bw.flush();
        bw.close();

    }
    static void dfs(int num, String s) throws IOException {
        Count++;
        s += arr[num];
        visited[num] = true;

        if(Count == M){
            s += "\n";
            if(list.isEmpty()){
                bw.write(s);
                list.add(s);
            }else {
                //if (!list.get(list.size() - 1).equals(s)) {
                    bw.write(s);
                    list.add(s);
                //}
            }
        }
        s += " ";

        for(int i = 0; i < arr.length; i++){
            if(Count < M && visited[i]==false){
                // i != i+1
                //if(i == 0 ||  (i > 0 && arr[i] != arr[i-1]) ) {
                    dfs(i, s);
                //}
            }
        }

        Count--;
        visited[num] = false;
    }
}
