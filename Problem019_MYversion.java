import java.util.*;
import java.io.*;

public class Problem019_MYversion {
    public static void quickSort(int[] a, int start, int end){
        

        if(start < end){

            int pivot = partition(a, start, end);
            quickSort(a, start, pivot-1);
            quickSort(a, pivot+1, end);
        }
    }

    public static int partition(int[] a, int left, int right){
        int pivot = a[right];
        int start =  left;
        int end = right-1;

        while(start <= end){
            while(start <= end && a[start] < pivot){
                start++;
            }
            while(start <= end && a[end] > pivot){
                end--;
            }

            if(start <end){
                int tmp = a[start];
                a[start] = a[end];
                a[end] = tmp;
                start++;
                end--;
            }
          
        }

        int temp = a[right];
        a[right] = a[start];
        a[start] = temp;

        return start;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int a[] = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i =0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        quickSort(a, 0, n-1);

        System.out.println(a[k-1]);
    }
}
