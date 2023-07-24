import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Arrays;

public class Problem008_MYversion {
    public static void main(String args[]) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        System.out.println(N);
        int arr[] = new int[N];

        st = new StringTokenizer(bf.readLine());
        for(int i =0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int i =0;
        int j = N-2;
        int end = N-1; 
        int cnt = 0;
        while(end!=2){
        while(i<j){
            if(arr[i] + arr[j] > end){
                j--;
            }else if(arr[i] + arr[j] < end){
                i++;
            }else{
                cnt++;
                j--;
            }
            
        }
        end--;
        j = end-1;
        i = 0;
        System.out.println("end:" + end);
        }
        System.out.println(cnt);
    }   
}
