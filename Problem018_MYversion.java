import java.util.*;
import java.io.*;

public class Problem018_MYversion {
    
    static void InsertionSort(int[] arr){
        int n = arr.length;

        for(int i =1; i < n; i++){
            
            int j = i -1;
            int key = arr[i];

            while( j >= 0 && key < arr[j]){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] a= new int[n];
        int[] s= new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i =0 ; i < n ; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        InsertionSort(a);

        s[0] = a[0];

        int sum =s[0];

        for(int i =1; i < n; i++){
            s[i] = s[i-1] + a[i];

            sum +=s[i];   
        }

        System.out.println(sum);
    }
}
