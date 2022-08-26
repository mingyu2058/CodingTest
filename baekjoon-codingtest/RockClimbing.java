/**
 * 문제 : 암벽등반
 * 링크 : https://www.acmicpc.net/problem/2412
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class RockClimbing {
    static int N, T;
    static ArrayList<Integer> list[];
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        T = Integer.parseInt(tokenizer.nextToken());

        Queue<Rock> queue = new LinkedList<Rock>();
        list = new ArrayList[T+1];
        for(int i = 0; i <= T; i++) {
            list[i] = new ArrayList();
        }


        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            list[b].add(a);
        }

        for(int i = 0; i <= T; i++) {
            Collections.sort(list[i]);
        }


        queue.add(new Rock(0, 0, 0));

        while (!queue.isEmpty()) {
            Rock cur = queue.poll();

            if (cur.y == T) {
                result = cur.count;
                break;
            }

            for(int i = cur.y-2; i <= cur.y+2; i++) {

                if(i < 0 || i > T) {
                    continue;
                }else {
                    for(int j = 0; j < list[i].size(); j++) {
                        if(list[i].get(j) - cur.x > 2) {
                            break;
                        }
                        if(Math.abs(cur.x-list[i].get(j)) <= 2) {
                            queue.add(new Rock(list[i].get(j),i,cur.count+1));
                            list[i].remove(j);
                            j--;
                        }
                    }
                }
            }

        }

        if(result == 0) {
            sb.append(-1);
        }else {
            sb.append(result);
        }
        System.out.print(sb.toString());
    }


}

class Rock implements Comparator<Rock> {
    int x;
    int y;
    int count;

    Rock(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }

    @Override
    public int compare(Rock arg0, Rock arg1) {
        int tmp = arg0.x - arg1.x;
        if (tmp == 0) {
            return arg0.y - arg1.y;
        }
        return tmp;
    }
}
