import java.util.*;
import java.io.*;

public class week5_test{
    public static void main(String args[]) throws IOException{
        PriorityQueue<Integer> pq;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      
        Comparator<Integer> cp = new Comparator<Integer>(){
              @Override
              public int compare(Integer o1, Integer o2){
            //  return o1 < o2 ? 1 : -1;
            //   return o1.compareTo(o2);  
            return o2.compareTo(o1);
            }
        };
        pq = new PriorityQueue<>(cp);
        
        pq.add(4);
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(5);
        pq.add(6);

        for(int i =0 ; i <6; i++){
            bw.write(pq.poll() + " ");

        }
        bw.flush();
        bw.close();
    }
  

}