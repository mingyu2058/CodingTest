/**
 * 문제 : 미로탐색
 * 링크 : https://www.acmicpc.net/problem/2178
 **/

import java.io.*;
import java.util.*;

public class SearchMaze {
    static int N,M;
    static int count = 0;

    static int maze[][];
    static boolean visited[][];

    static int dx[] = {1,- 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        maze = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j)-48;
            }
        }

        Queue<int []> queue = new LinkedList<int []>();
        queue.add(new int[] {0,0,1});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            // queue 추출
            int tmp[] = queue.poll();

            // 목적지 찾기
            if(tmp[0] == N-1 && tmp[1] == M-1) {
                count = tmp[2];
                break;
            }

            for(int i = 0; i < 4; i++) {
                int tRow = tmp[0] + dx[i];
                int tCol = tmp[1] + dy[i];

                // 순회
                if(0 <= tRow && tRow <= N-1 && 0 <= tCol && tCol <= M-1) {
                    if(maze[tRow][tCol] != 0 && visited[tRow][tCol]==false) {
                        // 갈 수 있다면 queue 삽입
                        visited[tRow][tCol] = true;
                        queue.add(new int[] {tRow,tCol,tmp[2]+1});
                    }
                }
            }
        }



        System.out.print(count);
    }
}
