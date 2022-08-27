/**
 * 문제 : 히스토그램에서 가장 큰 직사각형
 * 링크 : https://www.acmicpc.net/problem/6549
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxRectangleInHistogram {
    static int N, S;
    static int tree[] ;
    static int height[];
    static long MAX = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tokenizer;



        while (true) {
            //Arrays.fill(tree, 0);
            tokenizer = new StringTokenizer(br.readLine());
            N = Integer.parseInt(tokenizer.nextToken());
            MAX = -1;

            if (N == 0) {
                break;
            }


            S = 1;
            while (S < N) {
                S *= 2;
            }
            tree = new int[S*2];


            height = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                height[i] = Integer.parseInt(tokenizer.nextToken());
            }

            //init();
            initTest(1,1,N);


            for(int i = 0; i < 2*S; i++) {
                System.out.print(tree[i]+" ");
            }
            System.out.println();

            sb.append(max(1, N)+"\n");

            //sb.append(MAX + "\n");
        }
        System.out.println(sb.toString());

    }

    static void initTest(int node, int start, int end) {
        // 리프 노드에는 start index를 넣음.
        if (start == end) {
            tree[node] = start;
        } else {
            int mid = (start + end) / 2;
            initTest(node * 2, start, mid);
            initTest(node * 2 + 1, mid + 1, end);

            // 각 구간에서 가장 높이가 낮은 값의 index을 노드에 넣음.
            if (height[tree[node * 2]] <= height[tree[node * 2 + 1]]) {
                tree[node] = tree[node * 2];
            } else {
                tree[node] = tree[node * 2 + 1];
            }
        }
    }

    static void init() {
        for (int i = 0; i < N; i++) {
            tree[S + i] = i+1;
        }

        for (int i = S - 1; i > 0; i--) {
            int leftNode = tree[i * 2];
            int rightNode = tree[i * 2 + 1];

			/*
			if (height[rightNode] == 0) {
				tree[i] = leftNode;
				continue;
			}*/

            tree[i] = (height[leftNode] <= height[rightNode]) ? leftNode : rightNode;

        }
    }

    static int query(int left, int right, int node, int queryLeft, int queryRight) {
        if (left > queryRight || right < queryLeft) {
            return -1;
        }
        if (left >= queryLeft && right <= queryRight) {
			/*
			System.out.println("left : " + left + " right : " + right + " node : " + node + " ql : " + queryLeft + " qr : " + queryRight);
			System.out.println(" tree[node] : " + tree[node]);
			System.out.println(" node : " + node);
			*/
            return tree[node];
        }

        int mid = (left +right) / 2;
        int l = query(left, mid, node * 2, queryLeft, queryRight);
        int r = query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);


        if(l == -1) {
            return r;

        }else if(r == -1) {
            return l;

        }else {

            if(height[l] <= height[r]) {
                return l;
            }else {
                return r;
            }

        }


		/*
		if (l == -1 && r != -1) {
			return r;
		}

		if (l != -1 && r == -1) {
			return l;
		}

		if(l != -1 && r != 1){
			return (height[l] <= height[r] ? l : r);
		}

		return 0;
		*/
    }

    static long max(int start, int end) {

        //System.out.print("N : "+ N );
        //System.out.print(" start : " + start + " end : " + end);
        int cur = query(1,N,1,start,end);
        //System.out.println(" cur : " + cur);

        long length = (long) (end - start + 1) * height[cur];

        //MAX = Math.max(MAX, tmp);
        //System.out.println(start + " " + end + " " + cur + " " + tmp);


        if (start <= cur - 1) {
            long tmp = max(start, cur - 1);
            length = Math.max(tmp, length);
        }
        if (end >= cur + 1) {
            long tmp = max(cur+1,end);
            length = Math.max(tmp, length);
        }

        return length;

    }
}
