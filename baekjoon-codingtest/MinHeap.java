/**
 * 문제 : 최소 힙
 * 링크 : https://www.acmicpc.net/problem/1927
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Heap mh = new Heap();

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            if(value==0){
                System.out.println(mh.delete());
            }else{
                mh.insert(value);
            }

        }
    }
}

class Heap{
    List<Integer> list;

    public Heap(){
        list = new ArrayList<>();
        list.add(0); // 트리를 1부터 시작하니깐 0을 넣어줌
    }

    public void insert(int val){
        // 1. leaf 마지막에 삽입
        list.add(val);

        // 2. 부모와 비교 후 조건에 맞지 않으면 Swap
        // 3. 조건이 만족되거나 root 까지 반복
        int current = list.size()-1;
        int parent = current/2;
        while (true){
            if(parent==0 || list.get(parent) <= list.get(current)){
                break;
            }
            int temp = list.get(parent);
            list.set(parent, list.get(current));
            list.set(current, temp);

            current = parent;
            parent = current/2;
        }
    }

    public int delete(){
        // 처음에 0 넣은 것만 있을 때 (root가 아님)
        if(list.size()==1){
            return 0;
        }
        // 1. Root에 leaf 마지막 데이터 가져옴
        int top = list.get(1); // 1번이 root
        list.set(1, list.get(list.size() - 1));
        list.remove(list.size()-1);

        // 2. 자식과 비교 후 조건이 맞지 않으면 swap


        // 3. 조건이 만족되거나 leaf까지 반복
        int currentPos = 1;
        while (true){
            int leftPos = currentPos*2;
            int rightPos = currentPos*2+1;

            // 왼쪽 자식 먼저 확인 , 왼쪽 자식이 존재하지 않으면 오른쪽도 없음
            if(leftPos >= list.size()){
                break;
            }
            int minValue = list.get(leftPos);
            int minPos = leftPos;

            // 오른쪽 자식 확인 // 왼쪽은 있어도 오른쪽은 없을 수 있으니 list.size로 확인
            if(rightPos < list.size() && minValue > list.get(rightPos)){
                minValue = list.get(rightPos);
                minPos = rightPos;
            }
            // Swap, 현재 자리랑 비교
            if (list.get(currentPos) > minValue) {
                int temp = list.get(currentPos);
                list.set(currentPos, list.get(minPos));
                list.set(minPos, temp);
                currentPos = minPos;
            }
            else{
                break;
            }
        }
        return top;
    }
}