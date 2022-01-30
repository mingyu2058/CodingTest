/**
 * 문제: 크레인 인형뽑기 게임
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/64061
 */


import java.util.Stack;

public class ClawCrane {
    public static void main(String args[]){
        int board[][] = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int moves[] = {1, 5, 3, 5, 1, 2, 1, 4};

        int result = solution(board, moves);
        System.out.println("result = " + result);
    }

    public static int solution(int[][] board, int[] moves){
        int answer = 0, tmp, number =0;
        int[] count = new int[board.length];
        Stack<Integer> stack = new Stack<Integer>();

        for(int move : moves){
            for(int i=0; i< board.length; i++){
                if(board[i][move-1]!=0) {
                    number = board[i][move - 1];
                    board[i][move-1]=0;
                    break;
                }
                else
                    number = 0;
            }
            if(number==0)
                continue;

            if(stack.empty()) {
                stack.push(number);
            }
            else {
                tmp = stack.pop();
                if (tmp != number) {
                    stack.push(tmp);
                    stack.push(number);
                }
                else{
                    answer+=2;
                }
            }

        }

        // count를 따로 빼서 돌렸을 때
/*
        for(int i = 0; i< board.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[j][i]!=0) {
                    count[i] = j;
                    break;
                }
            }
        }
        
        for(int move : moves){

            if(count[move-1]==board.length)
                continue;;
            number = board[count[move-1]][move-1];

            if(number==0)
                continue;

            count[move-1]++;

            if(stack.empty()) {
                stack.push(number);
            }
            else {
                tmp = stack.pop();
                if (tmp != number) {
                    stack.push(tmp);
                    stack.push(number);
                }
                else{
                    answer+=2;
                }
            }


        }
*/
        return answer;
    }


}
