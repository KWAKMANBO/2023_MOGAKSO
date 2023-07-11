import java.util.Scanner;

public class Problem005_Answer {
    public static void main(String argsp[]){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        long S[] = new long[N];
        long C[] = new long[M];
        long cnt = 0;

        S[0] = sc.nextInt();
        for(int i =1; i < N; i++){
            S[i] = S[i-1] + sc.nextInt();
        }

        for(int i=0; i < N; i++){
            int remainder = (int)(S[i]%M);

            if(remainder ==0) cnt++;
            C[remainder]++;
        }
        for(int i=0; i < M; i++){
            if(C[i]>1){
                cnt = cnt + (C[i]*(C[i]-1))/2;
            }
        }
    }
    
}
