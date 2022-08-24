/**
 * 문제 : 구슬 탈출2
 * 링크 : https://www.acmicpc.net/problem/13460
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EscapeBead2 {
    static int N, M;
    static int count = -1;
    static char board[][];
    static int dx[] = { -1, 1, 0, 0 };
    static int dy[] = { 0, 0, -1, 1 };
    static Ball ball;
    static boolean visited[][][][];
    static int holeX, holeY;
    static Queue<Ball> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                board[i][j] = c;

                if (c == 'R') {
                    rx = i;
                    ry = j;
                } else if (c == 'B') {
                    bx = i;
                    by = j;
                } else if (c == 'O') {
                    holeX = i;
                    holeY = j;
                }
            }
        }
        ball = new Ball(rx, ry, bx, by, 0);
        visited[rx][ry][bx][by] = true;
        queue = new LinkedList<Ball>();
        queue.add(ball);

        bfs();

        System.out.println(count);
    }

    static void bfs() {

        while(!queue.isEmpty()) {
            Ball cur = queue.poll();

            if(cur.count > 10) {
                count = -1;
                break;
            }

            if(board[cur.bx][cur.by]=='O') {
                continue;
            }
            if(board[cur.rx][cur.ry]=='O') {
                count = cur.count;
                return;
            }

            int rx,ry,bx,by;

            for(int i = 0; i < 4; i++) {
                rx = cur.rx;
                ry = cur.ry;
                while(true) {
                    rx += dx[i];
                    ry += dy[i];
                    if(rx==holeX && ry == holeY) {
                        break;
                    }
                    else if(board[rx][ry]=='#') {
                        rx -= dx[i];
                        ry -= dy[i];
                        break;
                    }
                }

                bx = cur.bx;
                by = cur.by;
                while(true) {
                    bx += dx[i];
                    by += dy[i];
                    if(board[bx][by] == 'O') {
                        break;
                    }
                    else if(board[bx][by]=='#') {
                        bx -= dx[i];
                        by -= dy[i];
                        break;
                    }
                }

                if(rx == bx && ry == by && board[rx][ry] != 'O') {
                    int rLength = Math.abs(rx-cur.rx) + Math.abs(ry-cur.ry);
                    int bLength = Math.abs(bx-cur.bx) + Math.abs(by-cur.by);

                    if(rLength > bLength) {
                        rx -= dx[i];
                        ry -= dy[i];
                    }else {
                        bx -= dx[i];
                        by -= dy[i];
                    }
                }

                if(visited[rx][ry][bx][by] == false) {
                    visited[rx][ry][bx][by] = true;
                    queue.add(new Ball(rx,ry,bx,by,cur.count+1));
                }
            }
        }


    }

}

class Ball {
    int rx;
    int ry;
    int bx;
    int by;
    int count;

    Ball(int rx, int ry, int bx, int by, int count) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.count = count;
    }
}
