import java.util.*;
import java.io.*;

public class Problem018_Answer {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] A = new int[N];
        int[] S = new int[N];


        // A배열 입력받기
        for(int i=0; i < N;i++){
            A[i] = sc.nextInt();
        }

        
        for(int i =1; i <N; i++){
            int insert_point = i; // index  저장
            int insert_value = A[i]; // index에서의 값을 저장

            for(int j = i -1; j >=0; j--){
                if(A[j] < A[i]){// A[j]가 A[i]보다 작다면 
                    insert_point = j+1;
                    break;
                }
                if(j==0){
                    insert_point=0;
                }
            }

            for(int j=i; j > insert_point; j--){
                // index를 이동
                A[j] = A[j-1];
            }

            A[insert_point] = insert_value; 
        }
        S[0]  = A[0];

        for(int i=1; i <N; i++){
            S[i] = S[i-1] + A[i];
        }

        int sum =0;
        for(int i=0; i<N; i++){
            sum = sum + S[i];
        }
        
        
        System.out.println(sum);

    }
}