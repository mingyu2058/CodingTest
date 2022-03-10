/**
 * 문제 : 최소직사각형
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/86491
 */

public class MinimumRectangle {
    public static void main(String args[]){
        //int sizes[][] = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};  // 4000
        //int sizes[][] = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};  // 120
        int sizes[][] = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};  // 133
        System.out.println(solution(sizes));

    }
    public static int solution(int [][] sizes){
        int height = 0 , width = 0;

        // 기존 풀인
/*
        int[] tmp = new int[sizes.length];

        for (int i = 0; i < sizes.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (height < sizes[i][j])
                    height = sizes[i][j];
            }
            if(sizes[i][0]<sizes[i][1])
                tmp[i] = sizes[i][0];
            else
                tmp[i] = sizes[i][1];
        }
        for(int n : tmp)
            if(n > width)
                width = n;
*/

        // min,max(Math함수) 활용
        for(int i=0; i<sizes.length; i++){
            height = Math.max(height,(Math.max(sizes[i][0],sizes[i][1])));
            width = Math.max(width,Math.min(sizes[i][0],sizes[i][1]));
        }

        return width*height;
    }
}
