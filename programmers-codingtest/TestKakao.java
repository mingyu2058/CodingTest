public class TestKakao {
    public static void main(String args[]){
        //String survey[] = {"AN", "CF", "MJ", "RT", "NA"};
        //int[] choices = {5,3,2,7,5};
        //String survey[] = {"TR","RT","TR"};
        //int[] choices = {7,1,3};
        //String answer = solution(survey,choices);
        //System.out.println("answer = " + answer);

        //int queue1[] = {3,2,7,2};
        //int queue2[] = {4,6,5,1};

        //int queue1[] = {1,2,1,2};
        //int queue2[] = {1,10,1,2};

        //int queue1[] = {1,1};
        //int queue2[] = {1,5};
        //int result = solution(queue1,queue2);

        int alp = 10;
        int cop = 10;

        int problems[][] ={{10,15,2,1,2},{20,20,3,3,4}};

        int result = solution(alp,cop,problems);


        System.out.println("result = " + result);

    }
    static int solution(int alp, int cop, int[][] problems) {
        int answer = 0;

        for(int i = 0; i < problems.length; i++){
            if(alp >= problems[i][0] && cop >=problems[i][1]){
                    continue;
            }
            else{
                if(alp<problems[i][0]){
                    if(i == 0) {
                        answer += problems[i][0] - alp;
                        alp = problems[i][0];
                    }

                }
                if(cop < problems[i][1]) {
                    if (i == 1) {
                        answer += problems[i][1] - cop;
                        cop = problems[i][1];
                    }

                }
            }

        }


        return answer;
    }

    /*
    static String solution(String[] survey, int[] choices) {
        String answer = "";
        int tmp;

        HashMap hm = new HashMap<Character,Integer>();

        hm.put('R',0); hm.put('T',0);
        hm.put('C',0); hm.put('F',0);
        hm.put('J',0); hm.put('M',0);
        hm.put('A',0); hm.put('N',0);

        for(int i = 0; i < choices.length; i++){
            tmp = choices[i];
            if(tmp==4)
                continue;
            else if(tmp>=5){
                hm.put(survey[i].charAt(1),(Integer)hm.get(survey[i].charAt(1))+tmp-4);
                continue;
            }
            else{
                switch (choices[i]){
                    case 1:
                        hm.put(survey[i].charAt(0),(Integer)hm.get(survey[i].charAt(0))+3);
                        break;
                    case 2:
                        hm.put(survey[i].charAt(0),(Integer)hm.get(survey[i].charAt(0))+2);
                        break;
                    case 3:
                        hm.put(survey[i].charAt(0),(Integer)hm.get(survey[i].charAt(0))+1);
                        break;
                }
            }
        }
        System.out.println("hm = " + hm);

        answer += Integer.parseInt(hm.get('R').toString()) >= Integer.parseInt(hm.get('T').toString()) ? "R" : "T";
        answer += Integer.parseInt(hm.get('C').toString()) >= Integer.parseInt(hm.get('F').toString()) ? "C" : "F";
        answer += Integer.parseInt(hm.get('J').toString()) >= Integer.parseInt(hm.get('M').toString()) ? "J" : "M";
        answer += Integer.parseInt(hm.get('A').toString()) >= Integer.parseInt(hm.get('N').toString()) ? "A" : "N";


        return answer;
    }
     */

/*
    static int solution(int[] queue1, int[] queue2) {
        int result = 0;

        ArrayList<Integer> initList = new ArrayList<Integer>();

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        long sum1 = 0, sum2 =0;

        int rear1 = 0, rear2 = 0;

        for(int i = 0; i < queue1.length; i++){
            list1.add(queue1[i]);
            initList.add(queue1[i]);
            sum1 += queue1[i];

            list2.add(queue2[i]);
            sum2 += queue2[i];
        }

        long avg = (sum1+sum2) / 2;
        int tmp;

        while(true){
            if(sum1 == avg){
                return result;
            }
            if(sum1 >= sum2){
                tmp = list1.remove(rear1);

                if(list1.isEmpty())
                    return -1;

                list2.add(tmp);
                sum1 -= tmp;
                sum2 += tmp;
            }
            else{
                tmp = list2.remove(rear2);

                if(list2.isEmpty())
                    return -1;

                list1.add(tmp);
                sum2 -= tmp;
                sum1 += tmp;
            }
            result++;

            if(queue1.length==list1.size() || queue2.length==list2.size() ){
                if(initList.equals(list1))
                    return -1;
            }
        }
    }*/
/*
    static int solution(int[] queue1, int[] queue2) {

        int answer = -0;

        long front1 = queue1.length, front2 = queue2.length;  // 삽입
        int rear1 = 0, rear2 = 0;  // 추출

        long sum1 = 0L, sum2 = 0L;

        int initNum1, initNum2;

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        long avg;

        int tmpqueue1[] = new int[1000000];
        int tmpqueue2[] = new int[1000000];

        int tmp;

        for (int i = 0; i < queue1.length; i++) {
            sb1.append(queue1[i]);
            tmpqueue1[i] = queue1[i];
            sum1 += queue1[i];

            tmpqueue2[i] = queue2[i];
            sum2 += queue2[i];
        }

        initNum1 = (int) sum1;
        initNum2 = (int) sum2;

        if ((sum1 + sum2) % 2 != 0)
            return -1;

        avg = (sum1 + sum2) / 2;


        while (true) {
            if(answer>2147483647)
                return -1;

            if (sum1 == avg)
                return answer;
            else {
                answer++;
                if (sum1 > sum2) {
                    tmp = tmpqueue1[rear1++];
                    tmpqueue2[(int) front2++] = tmp;
                    sum1 -= tmp;
                    sum2 += tmp;
                } else {
                    tmp = tmpqueue2[rear2++];
                    tmpqueue1[(int) front1++] = tmp;
                    sum2 -= tmp;
                    sum1 += tmp;
                }
            }

            if (sum1 == avg)
                return answer;

            if(front1-rear1 < rear1){
                for(int i = 0; i < (front1-rear1); i++){
                    tmpqueue1[i] = tmpqueue1[rear1+i];
                }
                front1 = front1-rear1;
                rear1=0;

            }
            if(front2-rear2 < rear2){
                for(int i = 0; i < (front2-rear2); i++){
                    tmpqueue2[i] = tmpqueue2[rear2+i];
                }
                front2 = front2-rear2;
                rear2=0;
            }


            if ((initNum1 == sum1) && (initNum2 == sum2) && ((queue1.length == front1 - rear1) || (queue2.length == front2 - rear2))) {
                sb2.setLength(0);
                for (int i = rear1; i < front1; i++) {
                    sb2.append(tmpqueue1[i]);
                }

                if (sb1.toString().equals(sb2.toString()))
                    return -1;
            }
        }
    }
*/


}

