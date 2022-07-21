/**
 * 문제 : 보석 도둑
 * 링크 : https://www.acmicpc.net/problem/1202
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JewelThief {
    static int N,K;
    static int[] bags;
    static Jewelry[] jewelries;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());

        jewelries = new Jewelry[N];
        bags = new int[K];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            jewelries[i] =
                    new Jewelry(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
        }
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 가방 오름차순 정렬
        Arrays.sort(bags);
        // 보석 무게 오름차순 정렬
        Arrays.sort(jewelries, Comparator.comparingInt(Jewelry::getWeight));
        // 보석 가격이 높은값 기준 힙 , 완전 정렬이 보장x top만 보장
        PriorityQueue<Jewelry> pq = new PriorityQueue<>(Comparator.comparingInt(Jewelry::getValue).reversed());

        int jIndex = 0;
        long result = 0;
        // 1. 남은 가방 중 제일 작은 가방을 선택 <- 정렬
        for (int i = 0; i < bags.length; i++) {
            // 쥬얼 인덱스가 N 안에 있고 무게가 가방보다 작다
            // 2. 선택된 가방에 넣을 수 있는 남은 보석 중 가장 비싼 보석을 선택
            while (jIndex < N && jewelries[jIndex].weight <= bags[i]){
                pq.add(jewelries[jIndex++]);
            }
            if(!pq.isEmpty()){
                // 이게 제일 비싼 보석
                result += pq.poll().value;
            }
        }
        System.out.println(result);
    }

}
class Jewelry {
    int weight;
    int value;

    public int getWeight(){
        return weight;
    }
    public int getValue(){
        return value;
    }
    Jewelry(int weight,int value){
        this.weight = weight;
        this.value = value;
    }
}
