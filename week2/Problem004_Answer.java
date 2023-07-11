import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Problem004_Answer  {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 행렬 크기, 질의 갯수 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 원본 배열 저장
        int A[][] = new int[N+1][N+1];
        for(int i = 1 ; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j <=N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 합배열 저장
        int D[][] = new int[N+1][N+1];
        for(int i=1; i <= N; i++){
            for(int j =1; j <=N; j++){
                D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j];
            }
        }

        // 구간 합 구하기
        for(int i =0; i <M; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1];
            System.out.println(result);
        }   
     }
}
