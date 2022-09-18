/**
 * 문제 : 나무 자르기
 * 링크 : https://www.acmicpc.net/problem/2805
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CutTree {
    static int N,M;
    static int trees[];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        trees = new int[N] ;
        tokenizer = new StringTokenizer(br.readLine());

        long max = -1;

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(tokenizer.nextToken());
            max = Math.max(trees[i], max);
        }

        long start = 0;
        long end = max;
        long mid;
        long result = 0;

        while (true) {
            mid = (start+end)/2;
            long sum = calc(mid);
            // sum == M -> 정답 , 탈출
            if(sum == M){
                result = mid;
                break;
            }
            // sum < M -> mid -> end
            else if( sum < M){
                end = mid - 1;
            }
            // sum > M -> mid -> s, 정답 후보
            else{
                result = mid;
                start = mid + 1;
            }
            if(start > end){
                break;
            }
        }
        System.out.println(result);
    }

    static long calc(long value){
        long result = 0;
        for (int i = 0; i < trees.length; i++) {
            int tree = trees[i];
            if(tree > value){
                result += tree-value;
            }
        }
        return result;
    }
}
