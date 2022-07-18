/**
 * 문제 : 탈출
 * 링크 : https://www.acmicpc.net/problem/3055
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Escape {
    static final int[] MX = {-1, 1, 0, 0};
    static final int[] MY = {0, 0, -1, 1};

    static int R;
    static int C;
    static char[][] map;
    static int[][] dp;
    static Queue<Point> queue;

    static boolean foundAnswer;

    static Point dest;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());

        queue = new LinkedList<>();
        map = new char[R][C];
        dp = new int[R][C];

        Point water = null;
        Point start = null;

        for (int i = 0; i < R; i++) {
            tokenizer = new StringTokenizer(bf.readLine());
            String s = tokenizer.nextToken();

            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'S') {
                    start = new Point(i, j, 'S');
                } else if (map[i][j] == 'D') {
                    dest = new Point(i, j, 'D');
                } else if (map[i][j] == '*') {
                    water = new Point(i, j, '*');
                    queue.add(water);
                }
            }
        }

        queue.add(start);
        // [ Q[*,S] ]

        while (!queue.isEmpty()) {
            // 1. 큐에서 꺼내옴 -> *,S,.,D
            Point p = queue.poll();
            // 2. 목적지인가? -> D
            if (p.type == 'D') {
                foundAnswer = true;
                break;
            }
            // 3. 연결된 곳을 순회 -> 좌, 우, 위, 아래
            for (int i = 0; i < 4; i++) {
                int col = p.col + MX[i];
                int row = p.row + MY[i];

                // 4. 갈 수 있는가? (공통) : 맵 안에 들어오는가
                if (0 <= row && row < R && 0 <= col && col < C) {

                    // 4. 갈 수 있는가? (고슴도치) : . , D, 방문하지 않은 곳
                    if (p.type == 'S' || p.type == '.') {
                        if ((map[row][col] == '.' || map[row][col] == 'D') && dp[row][col] == 0) {

                            // 5. 체크인 (고슴도치) : dp[][] = 이동거리
                            dp[row][col] = dp[p.row][p.col] + 1;
                            // 6. 큐에 넣음
                            queue.add(new Point(row, col, map[row][col]));
                        }
                    } else if (p.type == '*') {
                        // 4. 갈 수 있는가? (물) : . 시작점도 갈 수 있음
                        if (map[row][col] == '.' || map[row][col] == 'S') {
                            // 5. 체크인 (물) : map[][] = *
                            map[row][col] = '*';
                            // 6. 큐에 넣음
                            queue.add(new Point(row, col, '*'));
                        }
                    }
                }
            }
        }

        if(foundAnswer)
            System.out.println(dp[dest.row][dest.col]);
        else
            System.out.println("KAKTUS");
    }
}
class Point{
    int row;
    int col;
    char type;

    Point(int row, int col, char type){
        this.row = row;
        this.col = col;
        this.type = type;
    }
}

