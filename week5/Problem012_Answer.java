package week5;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import java.util.Stack;

public class Problem012_Answer {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int  N = Integer.parseInt(br.readLine());

        int A[] = new int[N];
        int ans[] = new int[N];

        String str[] = br.readLine().split(" ");
        
        for(int i = 0 ; i < N; i++){
            A[i] = Integer.parseInt(str[i]);
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // 처음에는 항상 스택이 empty이므로 최초값을 push초기화해줌

        for(int i =1 ; i < N; i++){
            // 스택이 비어있지 않고 현재 수열이 스택 top 인덱스가 가리키는 수열보다 클 경우
            while(!stack.empty() && A[stack.peek()] < A[i]){
                ans[stack.pop()] = A[i]; //정답 배열에 오큰수를 현재 수열로 저장
            }
            stack.push(i);
        }

        while(!stack.empty()){
            // 반목문을 다 돌고난 후 스택이 비어 있지 않다면 빌 때까지 -1을 저장
            ans[stack.pop()] = -1;
            // stack에 index에 -1을 넣음
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < N ; i++){
            bw.write(ans[i] + " ");
        }
        bw.write("\n");
        bw.flush();

    }
}