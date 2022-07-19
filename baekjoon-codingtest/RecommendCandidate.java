/**
 * 문제 : 후보 추천하기
 * 링크 : https://www.acmicpc.net/problem/1713
 **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class RecommendCandidate {
    static int N,K;
    static Nominee[] nominees;
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        K = Integer.parseInt(bf.readLine());

        nominees = new Nominee[101];
        ArrayList<Nominee> list = new ArrayList<>();

        StringTokenizer tokenizer = new StringTokenizer(bf.readLine());

        for (int k = 0; k < K; k++) {
            int num = Integer.parseInt(tokenizer.nextToken());
            // 해당 후보가 최초 호출 시 (아직 넣은 건 아님)
            if(nominees[num]==null){
                nominees[num] = new Nominee(num,0,0,false);
            }

            // 해당 후보가 사진틀에 있을 경우
            if(nominees[num].isIn == true){
                nominees[num].count++;
            }else{
                // 해당 후보가 사진 틀에 없음
                // 사진틀이 가득 찬 경우
                if(list.size()==N){
                    //정렬, 지울 후보 선정, 제거
                    Collections.sort(list);
                    Nominee nominee = list.remove(0);
                    nominee.isIn = false;
                }
                // 사진틀에 여유가 있는 경우
                nominees[num].count = 1;
                nominees[num].isIn = true;
                nominees[num].timestamp = k;
                list.add(nominees[num]);
            }
        }

        Collections.sort(list, new Comparator<Nominee>() {
            @Override
            public int compare(Nominee o1, Nominee o2) {
                return Integer.compare(o1.num,o2.num);
            }
        });

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).num+" ");
        }

    }
}
class Nominee implements Comparable<Nominee> {
    int num;
    int count;
    int timestamp;
    boolean isIn;

    public Nominee(int num, int count, int timestamp, boolean isIn) {
        this.num = num;
        this.count = count;
        this.timestamp = timestamp;
        this.isIn = isIn;
    }

    // 1. 추천수 // 2. 시간
    @Override
    public int compareTo(Nominee o) {
        // 추천 수 기준
        //return Integer.compare(count, o.count);
        int compare = Integer.compare(count, o.count);

        // 추천수 기준 후 같으면 시간
        if (compare==0){
            return Integer.compare(timestamp, o.timestamp);
        }else{
            return compare;
        }

    }
}
