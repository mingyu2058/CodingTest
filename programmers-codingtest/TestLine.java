import java.util.*;

// 3문제 중 2문제 but 히든 케이스는 모름
public class TestLine {
    public static void main(String args[]){
        /* 1번
        String logs[] = {"kate sqrt"};
        String[] s =solutionv1(logs);
        for(int i =0 ; i< s.length; i++)
            System.out.println("s = " + s[i]);
        */
        /*2번*/

        int n = 10;
        int[] times = {1,2,3,4,5};
        System.out.println(solutionV2(n,times));
    }
    public static String[] solutionv1(String[] logs) {
        String s = "";
        String tmpAnswer = "";
        String[] answer = {};
        String[] tmp;

        HashMap<String, TreeSet<String>> hm = new HashMap<>();
        TreeSet<String> tmpSet = new TreeSet<>();
        TreeSet<String> solve = new TreeSet<>();
        TreeSet<String> person = new TreeSet<>();


        for(int i = 0; i < logs.length; i++){
            tmpSet = new TreeSet<>();
            tmp = logs[i].split(" ");
            tmpSet = hm.getOrDefault(tmp[1],tmpSet);
            tmpSet.add(tmp[0]);
            hm.put(tmp[1],tmpSet);
            solve.add(tmp[1]);
            person.add(tmp[0]);
        }

        int num = person.size();
        Iterator iterate = solve.iterator();


        while(iterate.hasNext()){
            s = (String)iterate.next();
            tmpSet = hm.get(s);
            if(tmpSet.size() % 2== 0 && tmpSet.size() >= num/2){
                tmpAnswer += s+ " ";
            }
            else if(tmpSet.size() % 2 != 0 && tmpSet.size() > num/2){
                tmpAnswer += s+" ";
            }
        }

        answer = tmpAnswer.split(" ");

        return answer;
    }
    public static int solutionV2(int n, int[] times) {
        int answer = 0;
        int line = 1;
        answer = function(line, n,times,answer);

        return answer;
    }
    public static int function(int line, int n, int[] times, int answer){
        if(line == 1) {
            answer += times[0];
            line *= 2;
        }
        else {
            System.out.println("www");
            answer += times[1];
            line = 2;
        }
        while (line * 2 <= n) {
            System.out.println("qqq");
            answer += times[line - 1];
            line *= 2;
        }

        if(line == n){
            System.out.println("aqwe");
            return answer;
        }
        else if(n-line==1){
            System.out.println("n-line = " + (n-line));
            return answer+=times[0];
        }
        else {
            System.out.println("asd");
            System.out.println("answer = " + answer);
            System.out.println("line = " + (n-line));
            return function(0, n-line,times, answer);
        }
    }

}
