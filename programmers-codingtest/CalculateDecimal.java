/**
 * 문제 : 소수 만들기
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/12977
 */

public class CalculateDecimal {
    public static void main(String args[]){
        int[]nums ={1,2,3,4};
        //int[]nums ={1,2,7,6,4};

        int result = solution(nums);

    }
    public static int solution(int[] nums){
        int answer=0,sum;

        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j< nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    sum = nums[i]+nums[j]+nums[k];
                    if(cal(sum))
                        answer++;
                }
            }
        }

        return answer;
    }

    public static boolean cal(int num){
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0)
                return false;
        }
        return true;
    }


}

