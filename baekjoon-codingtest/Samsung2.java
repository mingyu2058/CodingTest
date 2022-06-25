import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Samsung2 {

    public static void main(String args[]) throws IOException {

        BufferedReader bf = new BufferedReader(
                new FileReader("sample_input.txt")
        );
        int testCase = Integer.parseInt(bf.readLine());

        int N, M, R, K;
        for(int t = 0; t < testCase; t++){
            String s[] = new String[4];
            s = bf.readLine().split(" ");
            N = Integer.parseInt(s[0]); // 세로
            M = Integer.parseInt(s[1]); // 가로
            R = Integer.parseInt(s[2]); // 그렉의 세로
            K = Integer.parseInt(s[3]); // 그렉의 가로

            int[][] w = new int[N][M];


            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){

                }
            }

        }



    }
}
