import java.util.*;
import java.io.*;

public class Problem014_MYversion {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Comparator<Integer> cp = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                if(Math.abs(o1) < Math.abs(o2)){ // o1이 o2보다 작다면
                    return -1;
                }else if(Math.abs(o1) == Math.abs(o2)){
                    return o1 < o2 ? -1:1;
                }else{
                    return 1;
                }
            
                // o1의 절댓값이 o2보다 작다면 1을반환, --> 1 순서를 바꿈
                // o1의 절댓값이 o2보다 크다면 -1을반환 --> -1 순서를 안바꿈
            }
        };

        PriorityQueue<Integer> pq = new PriorityQueue<>(n, cp);

       
        for(int i = 0; i < n ; i++){
            int x = Integer.parseInt(br.readLine());

            if(x == 0 ){
                if(pq.isEmpty()){
                    bw.write("0\n");
                }else{
                    bw.write(pq.poll() + "\n");
                }
            }else{
                pq.add(x);
            }
        }
       bw.flush();
    }
}
