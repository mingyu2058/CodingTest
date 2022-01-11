/*
	https://programmers.co.kr/learn/courses/30/lessons/77484
	로또의 최고 순위와 최저 순위
*/
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0,0};
        int tmp=0;
        int min=7 ,max=1;
        
        for(int i=0; i<lottos.length; i++){
            if(lottos[i]==0)
                tmp++;
        }
        
        if(tmp!=0){
            for(int i=0; i<lottos.length; i++){
                for(int j=0; j<lottos.length; j++){
                    if(lottos[i]==win_nums[j])
                        min--;
                }
            }
            
            max = min-tmp;
            
            if(tmp==6)
                min = 6;
            answer[0]=max;
            answer[1]=min;
            return answer;
        }
        else{
            for(int i=0; i<lottos.length; i++){
                for(int j=0; j<lottos.length; j++){
                    if(lottos[i]==win_nums[j])
                        min--;
                }
            }
            if(min==7)
                min=6;
            answer[0]=min;
            answer[1]=min;
            return answer;
        }
        
        
    }
}