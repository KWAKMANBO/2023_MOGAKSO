import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Stack;

public class Problem012_Answer {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int  N = Integer.parseInt(br.readLine());

        int A[] = new int[N];
        int ans[] = new int[N];

        String str[] = br.readLine().split("");
        
        for(int i = 0 ; i < N; i++){
            A[i] = Integer.parseInt(str[i]);
        }

    }
}