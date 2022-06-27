import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Samsung2 {

    static int w[][];
    static int A[] = new int[2];
    static int B[] = new int[2];
    static int C[] = new int[2];
    static boolean visited[][];
    static int N,M;


    static int aX,aY;
    static int bX,bY;
    static int cX,cY;

    public static void main(String args[]) throws IOException {

        BufferedReader bf = new BufferedReader(
                new FileReader("sample_input2.txt")
        );
        int testCase = Integer.parseInt(bf.readLine());


        int R, K;
        for(int t = 0; t < testCase; t++){
            String s[] = new String[4];
            s = bf.readLine().split(" ");

            N = Integer.parseInt(s[0]); // 세로
            M = Integer.parseInt(s[1]); // 가로
            R = Integer.parseInt(s[2])-1; // 그렉의 세로
            K = Integer.parseInt(s[3])-1; // 그렉의 가로

            // 기본 매개변수 출력
            /*
            System.out.println("N = " + N);
            System.out.println("M = " + M);
            System.out.println("R = " + R);
            System.out.println("K = " + K);
            */

            StringBuilder sb = new StringBuilder();
            String tmp[] = new String[N];

            w = new int[N][M];
            visited = new boolean[N][M];

            int finishX = 0,finishY = 0;

            // N = y  M = x
            for(int i = 0; i < N; i++){
                tmp = bf.readLine().split("");
                for(int j = 0; j < M; j++){
                    if(tmp[j].equals(".")){
                        w[i][j] = 1;
                    }
                    else if(tmp[j].equals("X")){
                        w[i][j] = 0;
                    }
                    else if(tmp[j].equals("A")){
                        A[0] = i;
                        A[1] = j;
                        w[i][j] =1;
                    }
                    else if(tmp[j].equals("B")){
                        B[0] = i;
                        B[1] = j;
                        w[i][j] =1;
                    }
                    else if(tmp[j].equals("C")){
                        C[0] = i;
                        C[1] = j;
                        w[i][j] =1;
                    }
                    else if(tmp[j].equals("S")){
                        finishX = i;
                        finishY = j;
                        w[i][j] =1;
                    }
                    else{
                        w[i][j] = 1;
                    }
                }
            }
            /*
            w[R][K] = -1;
            w[B[0]][B[1]] = 2;
            w[C[0]][C[1]] = 3;
            w[A[0]][A[1]] = 4;
            w[finishX][finishY] = 6;
*/
            //System.out.println("finishX = " + finishX);
            //System.out.println("finishY = " + finishY);
            //System.out.println("B[0]+\" \"+B[1] = " + B[0]+" "+B[1]);
            //System.out.println("C[0]+\" \"+C[1] = " + C[0]+" "+C[1]);

            // bfs로 (함수에다가 (시작점,B) -> (B,A) || (B,C)  -> (A,C) || (C,A)
            //       (함수에다가 (시작점,C) -> (C,A) || (C,B)  -> (A,B) || (B,A)
            //       (함수에다가 (시작점,A) -> (A,B) || (A,C)  -> (B,C) || (C,B)

            ArrayList<Integer> list = new ArrayList<>();
            int startA = function(R,K,0,A[0],A[1],B[0],B[1],C[0],C[1]);

            //ABC
            list.add(startA+
                    function(A[0],A[1],0,B[0],B[1],C[0],C[1],-1,-1)+
                    function(B[0],B[1],0,C[0],C[1],-1,-1,-1,-1)+
                    Math.abs(finishX-C[0]) + Math.abs(finishY-C[1])
            );
           // System.out.println("function(R,K,0,A[0],A[1],B[0],B[1],C[0],C[1]) = " + function(R,K,0,A[0],A[1],B[0],B[1],C[0],C[1]));

            //ACB
            list.add(startA+
                    function(A[0],A[1],0,C[0],C[1],B[0],B[1],-1,-1)+
                    function(C[0],C[1],0,B[0],B[1],-1,-1,-1,-1)+
                    Math.abs(finishX-B[0]) + Math.abs(finishY-B[1])

            );

            int startB = function(R,K,0,B[0],B[1],A[0],A[1],C[0],C[1]);
            //BCA
            list.add(startB+
                            function(B[0],B[1],0,C[0],C[1],A[0],A[1],-1,-1)+
                            function(C[0],C[1],0,A[0],A[1],-1,-1,-1,-1)+
                            Math.abs(finishX-A[0]) + Math.abs(finishY-A[1])
                    );
            //BAC
            list.add(startB+
                    function(B[0],B[1],0,A[0],A[1],C[0],C[1],-1,-1)+
                    function(A[0],A[1],0,C[0],C[1],-1,-1,-1,-1)+
                    Math.abs(finishX-C[0]) + Math.abs(finishY-C[1])
            );

            //System.out.println(" function(R,K,0,B[0],B[1],A[0],A[1],C[0],C[1]) = " +  function(R,K,0,B[0],B[1],A[0],A[1],C[0],C[1]));


            int startC = function(R,K,0,C[0],C[1],A[0],A[1],B[0],B[1]);
            //CAB
            list.add(startC+
                    function(C[0],C[1],0,A[0],A[1],B[0],B[1],-1,-1)+
                    function(A[0],A[1],0,B[0],B[1],-1,-1,-1,-1)+
                    Math.abs(finishX-B[0]) + Math.abs(finishY-B[1])
            );
            //CBA
            list.add(startC+
                    function(C[0],C[1],0,B[0],B[1],A[0],A[1],-1,-1)+
                    function(B[0],B[1],0,A[0],A[1],-1,-1,-1,-1)+
                    Math.abs(finishX-A[0]) + Math.abs(finishY-A[1])
            );


            //System.out.println("list = " + list);

            list.sort(Comparator.naturalOrder());
            System.out.println("#"+(t+1)+" "+list.get(0));

           // System.out.println("function(R,K,0,C[0],C[1],A[0],A[1],B[0],B[1]) = " + function(R,K,0,C[0],C[1],A[0],A[1],B[0],B[1]));


            // 그림 출력
/*
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    System.out.print(w[i][j]+" ");
                }
                System.out.println();
            }
*/
        }



    }

    static int function(int i, int j, int cnt, int goalX, int goalY, int tmp1X, int tmp1Y, int tmp2X, int tmp2Y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i,j,cnt});
        visited = new boolean[N][M];
        visited[i][j] = true;

        int distance;

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        while(!queue.isEmpty()){
            int now[] = queue.poll();
           // visited[i][j] = true;

            if(now[0] == goalX && now[1] == goalY) {
                return now[2];
            }
            for(int k = 0; k < 4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                distance = now[2];

                if(x>=0 && y>=0 && x < N && y < M) {
                    if(x == goalX && y == goalY){
                       // System.out.print("goalX = " + goalX);
                       // System.out.println("  goalY = " + goalY);
                       // System.out.println("distance = " + distance);
                        return distance+1;
                    }
                    if (w[x][y] != 0 && !visited[x][y] && !(x==tmp1X && y==tmp1Y) && !(x==tmp2X && y==tmp2Y)) /* B,C도 아니다*/{
                       // System.out.print("x = " + x);
                       // System.out.println("  y = " + y);

                        //distance++;
                        visited[x][y] = true;
                        queue.add(new int[]{x, y,distance+1});
                    }
                }
            }
        }

        return 100000;
    }
}
