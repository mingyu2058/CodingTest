import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        Node[] arr = new Node[n];

        for(int i = 0; i < n; i++){
            arr[i] = new Node(Integer.parseInt(bf.readLine()),i);
        }
        Arrays.sort(arr);

        int max = -1;
        for(int i = 0; i < n; i++){
            if(max < arr[i].index - i){
                max = arr[i].index - i;
            }
        }
        System.out.println(max+1);
    }

}
class Node implements Comparable<Node>{
    int value;
    int index;

    public Node(int value, int index){
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
