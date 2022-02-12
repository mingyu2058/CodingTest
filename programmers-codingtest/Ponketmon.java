/**
 * 문제 : 폰켓몬
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/1845
 */
import java.util.HashMap;

public class Ponketmon {
    public static void main(String args[]){
        //int[] nums = {3, 1, 2, 3}; //2
        //int[] nums = {3, 3, 3, 2, 2, 4}; //3
        int[] nums = {3, 3, 3, 2, 2, 2}; //2

        System.out.println(solution(nums));
    }
    public static int solution(int[] nums){
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int num : nums) hm.put(num, hm.getOrDefault(num, 0) + 1);

        if(hm.size()>=nums.length/2)
            return nums.length/2;
        else
            return hm.size();


    }
}
