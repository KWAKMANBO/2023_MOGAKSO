import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Problem004_MYversion {
    public static void main(String args[])throws IOException{
        BufferedReader  bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        // N: 표의 크, M: 합을 구해야 하는 횟수
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        // 행렬을 입력받는 부분
        // 출력값은 합만 존재하므로 합배열을 사용
        int suArr[][] = new int[N+1][N+1];
        for(int i = 1; i <= N; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 1; j <= N; j++){
               
                suArr[i][j] = suArr[i][j-1] + Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        
        
        for(int i=0; i < M; i++){// 질의를 M번만큼 반복
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int row1 = Integer.parseInt(stringTokenizer.nextToken()); 
            int col1 = Integer.parseInt(stringTokenizer.nextToken());
            int row2 = Integer.parseInt(stringTokenizer.nextToken());
            int col2 = Integer.parseInt(stringTokenizer.nextToken());
            int sum=0;
            for(int j = row1 ; j <= row2; j++){
             sum += suArr[j][col2] -suArr[j][col1-1];   
            }
            System.out.println(sum);
        }
        
        
    }
}   