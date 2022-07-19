/**
 * 문제 : 가르침
 * 링크 : https://www.acmicpc.net/problem/1062
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Teaching {
    static char[] c;
    static String s = "";

    static int N,K;
    static String[] words;
    static boolean[] visited;
    static int max = 0;
    static int selectedCount = 0;

    static char[] answer;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());

        words = new String[N];
        visited = new boolean[26];

        answer = new char[K];

        for(int i = 0; i < N; i++){
            words[i] = bf.readLine();
        }

        if( K < 5) {
            System.out.println(0);
            return;
        }

        visited['a'-'a'] = true;
        visited['n'-'a'] = true;
        visited['t'-'a'] = true;
        visited['i'-'a'] = true;
        visited['c'-'a'] = true;

        selectedCount = 5;
        max = countWords();

        for (int i = 0; i  < 26; i++) {
            if(visited[i] == false)
                dfs(i);
        }

        System.out.println(max);



    }
    static void dfs(int index){
        /**
         * 체크인
         * 목적지인가? : selectedCount == K => 읽을 수 있는 단어 계산
         * 연결된곳? : a 선택시 b~z  b 선택시 c~z => index+1 ~ z
         *      갈 수 있는가? : 방문 여부
         *      간다 : dfs()
         * 체크아웃
         */

        // 1. 체크인
        visited[index] = true;
        selectedCount++;

//      2. 목적지인가?
        if(selectedCount == K){
            max = Math.max(max,countWords());
            //계산
        }else {
            //      3.연결된 곳을 순회
            for(int i = index +1; i <= 25; i++){
                //      4. 갈 수 있는가?
                if(visited[i] == false){
                    //  5. 간다
                    dfs(i);
                }
            }
        }

        // 6. 체크아웃
        visited[index] = false;
        selectedCount--;
    }

    static int countWords(){
        int count = 0;

        for (int n = 0; n < N; n++) {
            boolean isPossible = true;
            String word = words[n];

            for (int i = 0; i < word.length(); i++) {
                if(visited[word.charAt(i) - 'a'] == false) {  // 알파벳을 index로 치환
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                count++;
            }

        }

        return count;
    }

}
