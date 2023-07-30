import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;


public class Problem010_Answer {
    
    // Node 클래스 선언
    static class Node{
        public int index;
        public int value;

        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }

    public static final Scanner sc = new Scanner(System.in);
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Deque<Node> mydeque = new LinkedList<>();

        for(int i = 0; i < N; i ++){
            int now = Integer.parseInt(st.nextToken());
            // 새로운 값이 들어올 떄마다 정렬대신 현재 수보다 큰  값을 덱에서 제거해 시간복잡도를 줄임

            while(!mydeque.isEmpty() && mydeque.getLast().value > now){
                mydeque.removeLast();
            }
            mydeque.addLast((new Node(now, i)));

            //범위에서 벗어난 값은 덱에서 제거
            if (mydeque.getFirst().index <= i - L){
                // mydeque의 첫번째 요소의 index값이 I에서 L(부분 문자열의 길이)을 뺸값보다 작은 index을 가졌다면  
                mydeque.removeFirst();
            }
            bw.write(mydeque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }
}
