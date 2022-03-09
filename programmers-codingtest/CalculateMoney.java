/**
 * 문제 : 부족한 금액 계산하기
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/82612
 */

public class CalculateMoney {
    public static void main(String args[]){
        int price = 3;
        long money = 20;
        int count = 4;

        System.out.println(solution(price,money,count));
    }
    public static long solution(int price, long money, int count){
        long sum = 0, tmp = 0;
        
        // 등차수열의 합으로 사용해도 가능함
        for(int i=0; i<count; i++){
            tmp += price;
            sum+=tmp;
        }
        if(money-sum>=0)
            return 0;
        else
            return sum-money;

    }

}

