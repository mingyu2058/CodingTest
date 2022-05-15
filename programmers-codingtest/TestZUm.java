public class TestZUm {
    public static void main(String args[]){
        //int n = 3;


        //int[][] data = {{1,0,5},{2,2,2},{3,3,1},{4,4,1},{5,10,2}};
        //int[][] data = {{1,0,3},{2,1,3},{3,3,2},{4,9,1},{5,10,2}};

       /*
        int[][] data = {{1,2,10},{2,5,8},{3,6,9},{4,20,6},{5,25,5}};
        int[] result;
        result = solution(data);
        //System.out.println(solution(data));

        for(int i = 0; i < result.length; i++)
            System.out.println("result = " + result[i]);
        */

        /*
        int histogram[] = {2,2,2,3};
        System.out.println("solution(histogram) = " + solution(histogram));
        */

        int grid[][] = {{2,1,1,3,5,1},{1,1,3,3,5,5},{8,3,3,3,1,5},{3,3,3,4,4,4},{3,3,4,4,4,4},{1,4,4,4,4,4}};

        int result[];
        result = solution(grid);
        for(int i = 0; i < result.length; i++)
            System.out.println("result = " + result[i]);

    }
    
    // 1
    public static long solution(long n) {
        long answer = 0;

        for(int i = 1; i < n*n; i++){
            if(i/n == i%n) {
                answer += i;
            }
            else{
                continue;
            }
        }

        return answer;
    }

    
    //2 
    /*
    public static int[] solution(int[][] data) {
        int[] answer = new int[data.length];
        int leastTime,least=0;
        int tmpFinish=0;

        // 0 : 번호, 1 : 시각,  2: 페이지
        while(true) {
            leastTime = 100000001;
            for (int i = 0; i < data.length; i++) {
                //아직 안빠져나가고 시간이 적게 남은 애
                if (data[i][0]!= -1) {
                    if (data[i][1] < leastTime) {
                        leastTime = data[i][1];
                        least = i;
                    }
                    else if(data[i][1] == leastTime){
                        if(data[i][2] < data[least][2]){
                            leastTime = data[i][1];
                            least  = i;
                        }
                    }
                }

            }
            answer[tmpFinish++] = least+1;

            for(int i = 0; i < data.length; i++) {
                if(data[i][1] >=0)
                    data[i][1] = ((data[i][1] - data[least][2] - 1)<0) ? 0 : data[i][1]-data[least][2]-1;
                data[least][0]=-1;
            }
            if(tmpFinish == data.length)
                break;
        }

        return answer;
    }
    */

    //3 
    /*
    public static int solution(int[] histogram) {
        int answer = -1;
        int minHeight;

        for(int i = 0; i < histogram.length-1; i++){
            for(int j = i+2; j < histogram.length; j++){
                minHeight = histogram[i];
                if(histogram[j] < minHeight)
                    minHeight = histogram[j];

                if((j - i - 1) * (minHeight) > answer) {
                    answer = (j - i - 1) * minHeight;
                }

            }

        }

        return answer;
    }
     */

    //4 -> 해결 못함
    public static int[] solution(int[][] grid) {
        int[] answer = {};

        int max = -1;

        for(int i = 1; ; i++){
            if(grid.length < (i+2-1)){
                max = i-1;
                break;
            }
        }

        for(int i = 0; i < grid.length - (max*2)-1; i++){
            for(int h = i; h < grid.length - max; h++){
                for(int w = i; w < grid.length - max; w++){

                }
            }
        }


        return answer;
    }
}

