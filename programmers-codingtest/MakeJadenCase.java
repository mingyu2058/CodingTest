import java.util.StringTokenizer;

public class MakeJadenCase {
    static StringBuilder sb;
    public static void main(String args[]){
        //String s = "3people unFollowed me";
        String s = "for the last week";

        String print = solution(s);
        System.out.println("print = " + print);

    }
    static String solution(String s){
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s);
        boolean isCheck;

        while(st.hasMoreTokens()){
            String cur = st.nextToken();
            isCheck = true;

            for(int i = 0; i < cur.length(); i++){
                char c = cur.charAt(i);
                check(c,isCheck);
                

            }

            break;
        }
        return answer;
    }

    static char check(char c, boolean isCheck){
        if(c<65){

        }else{

        }
    }

}
