import java.util.*;
import java.io.*;

public class Problem019_Answer {

    public static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static int partition(int[] A, int S, int E){
        if(S + 1 == E){
            if(A[S] > A[E]){
                swap(A, S, E);
                return E;
            }
            
            int M = (S + E)/2;
            swap(A, S, M);
        }
    }
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
    }
}
