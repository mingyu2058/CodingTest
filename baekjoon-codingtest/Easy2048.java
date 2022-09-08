/**
 * 문제 : 2048(Easy)
 * 링크 : https://www.acmicpc.net/problem/12100
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Easy2048 {
    static int answer = -1;
    static int N;
    static int block[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        block = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(tokenizer.nextToken());
                block[i][j] = tmp;
            }
        }
        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int count) {
        // goal check
        if (count == 5) {
            findMax();
            return;
        }
        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            copy[i] = block[i].clone();
        }
        // tour
        for (int i = 0; i < 4; i++) {
            tour(i);
            dfs(count + 1);
            for (int j = 0; j < N; j++) {
                block[j] = copy[j].clone();
            }

        }
    }

    static void tour(int c) {

        switch (c) {
            // Left
            case 0:
                for (int y = 0; y < N; y++) {
                    int cursor = 0;
                    int tmp = 0;
                    for (int index = 0; index < N; index++) {
                        if (block[y][index] != 0) {
                            if (tmp == block[y][index]) {
                                block[y][cursor-1] = tmp * 2;
                                tmp = 0;
                                block[y][index] = 0;
                            } else {
                                tmp = block[y][index];
                                block[y][index] = 0;
                                block[y][cursor] = tmp;
                                cursor++;
                            }
                        }

                    }
                }
                break;
            // Right
            case 1:
                for (int y = 0; y < N; y++) {
                    int cursor = N-1;
                    int tmp = 0; // 이전 값
                    for (int index = N - 1; index >= 0; index--) {
                        if(block[y][index] != 0) {
                            if(tmp == block[y][index]) {
                                block[y][cursor+1] = tmp*2;
                                block[y][index] = 0;
                                tmp = 0;
                            }else {
                                tmp = block[y][index];
                                block[y][index] = 0;
                                block[y][cursor] = tmp;
                                cursor--;
                            }
                        }

                    }
                }
                break;
            // Up
            case 2:
                for (int x = 0; x < N; x++) {
                    int cursor = 0;
                    int tmp = 0;
                    for (int index = 0; index < N; index++) {
                        if(block[index][x]!=0) {
                            if(tmp == block[index][x]) {
                                block[cursor-1][x] = tmp*2;
                                block[index][x] = 0;
                                tmp = 0;
                            }else {
                                tmp = block[index][x];
                                block[index][x] = 0;
                                block[cursor][x] = tmp;
                                cursor++;
                            }


                        }
                    }
                }
                break;
            // Down
            case 3:
                for (int x = 0; x < N; x++) {
                    int cursor = N-1;
                    int tmp = 0;
                    for (int index = N - 1; index >= 0; index--) {
                        if(block[index][x] != 0) {
                            if(tmp == block[index][x]) {
                                block[cursor+1][x] = tmp*2;
                                block[index][x] = 0;
                                tmp =0;
                            }else {
                                tmp = block[index][x];
                                block[index][x] = 0;
                                block[cursor][x] = tmp;
                                cursor--;
                            }

                        }
                    }
                }
                break;
        }

    }

    static void findMax() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, block[i][j]);
            }
        }

    }
}
