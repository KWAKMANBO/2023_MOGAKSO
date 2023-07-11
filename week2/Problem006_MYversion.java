import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Problem006_MYversion {
    public static void main(String args[]) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N =Integer.parseInt(st.nextToken());

        int S[] = new int[N+1];
        // 합배열을 생성
        S[0] = 0;
        for(int i=1; i<= N; i++){
            S[i] += i +S[i-1];
        }

        // N은 무조건 카운트하므로 cnt는 1부터 시작
        int cnt = 1;
        for(int i=1; i <=N; i++){
            for(int j = N; j > 0; j--){
                if(S[j] - S[i] == N)cnt++;
            }
        }
        System.out.println(cnt);
    }
}
