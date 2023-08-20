import java.util.*;
import java.io.*;

public class Problem014_Answer {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> MyQueue = new PriorityQueue<>((o1,o2) ->{
            int first_abs =Math.abs(o1);
            int second_abs = Math.abs(o2);
            
            if(first_abs == second_abs){
                return o1 > o2 ? 1: -1;
                // 두 객체의 절댓값이 같은 경우
                // o1 이 o2 보다 크다면 1을 반환 --> 순서를 바꿈
                // o1 이 o2 보다 작다면 -1을 반환 --> 순서를 바꾸지 x
            }else{
                return first_abs - second_abs;
                // 절댓값을 기준으로 정렬
                // first_abs - second_abs > 0 이면 first_abs가 더 크므로 second_abs(o2)가 앞으로 오도록
                // first_abs - second_abs < 0 이면 second_abs가 더 크므로 first_abs(o1)이 앞으로 오도록
            }
        });

        for(int i = 0; i < N; i++){
            int reqeust =  Integer.parseInt(br.readLine());

            if(reqeust ==0){
                if(MyQueue.isEmpty()){
                    System.out.println("0");
                }else{
                    System.out.println(MyQueue.poll());
                }
            }else{
                MyQueue.add(reqeust);
            }
        }

    }
}
