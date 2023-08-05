package week5;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Stack;
import java.util.StringTokenizer;

public class Problem012_MYversion {
    public static void main(String args[]) throws IOException{
        // stack에 새로 들어오는수가 top에 존재하는 수보다 크면 그 수는 오큰수
        // 오 큰수를 구한 후 수열에서 오큰수가 존재하지 않는 숫자에 -1을 출력
        
        Stack<Integer> stack =  new Stack<>();


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];

        st = new StringTokenizer(br.readLine());
        
        StringBuffer sb = new StringBuffer();
        arr[0] = Integer.parseInt(st.nextToken());
        stack.push(arr[0]);

        for(int i = 1; i  < N ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
            System.out.println(arr[i]);
            
            if(stack.peek() < arr[i]){
                sb.append(arr[i] + " ");
            }
            if(i == N-1){
                //System.out.println("-1");
                sb.append("-1");
            }

            stack.push(arr[i]);
        }
        System.out.println(sb);
        


    }
}
