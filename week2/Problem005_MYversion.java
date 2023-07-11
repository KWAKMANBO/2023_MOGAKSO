import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Problem005_MYversion {
    public static void main(String args[])throws IOException{
        BufferedReader  bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // 배열의 크기와 나눌 수를 입력받음
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 크기 N+1만큼의 배열선언 1부터 인덱스를 맞춰주기위해서 +1함
        int arr[] = new int[N+1]; 
        int sum[] = new int[N+1]; 

        // 배열의 수를 입력
        st = new StringTokenizer(bf.readLine());
        for(int i=1; i <= N; i++){
            
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + arr[i];
        }
        int cnt = 0;
        // 연속된 부분의 구간에서의
        for(int i=1; i <= N; i++){
            for(int j =N; j>= i; j--){
                if((sum[j] - sum[i-1])%M ==0){
                cnt++;
                }
            }
        }  
        System.out.println(cnt);
    }
}
