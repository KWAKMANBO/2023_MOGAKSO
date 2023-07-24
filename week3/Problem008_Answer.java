import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class Problem008_Answer {
    public static void main(String args[]) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int cnt = 0;
        long A[] = new long[N];

         st = new StringTokenizer(bf.readLine());
         
         for(int i =0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
         }

         Arrays.sort(A);

         for(int k =0; k < N; k++){ // N번만큼 반복 
            long find = A[k];
            int i =0;
            int j = N -1;
            while(i<j){
                if(A[i] + A[j] == find){
                    if(i != k && j !=k){ // k가 자기 자신일때는 제외해야함
                        cnt++;
                        break;
                    }else if(i == k ){
                        i++;
                    }else{
                        j--;
                    }
                }else if(A[i] + A[j] < find){
                    i++;
                }else{
                    j--;
                }
            }
         }
         System.out.println(cnt);
         }
    }

