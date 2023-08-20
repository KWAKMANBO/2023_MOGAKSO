import java.util.*;
import java.io.*;

public class Problem019_MYversion {
    public static void quickSort(int[] a, int start, int end){
    
        if(start < end){
            // start 가 end보다 작을때 만 실행
            // start가 end보다 작으면 정렬할 요소가 남아잇기 때문에
            int pivot = partition(a, start, end);
            quickSort(a, start, pivot-1);
            quickSort(a, pivot+1, end);
        }
    }

    public static int partition(int[] a, int left, int right){
        
        int pivot = a[right]; // pivot을 맨 오른쪽 요소로 설정
        int start =  left; //  시작 인덱스
        int end = right-1; // 끝 인덱스

        while(start <= end){
            while(start <= end && a[start] < pivot){
                // a[start]가 pivot보다 큰 start를 찾는 과정
                start++;
            }
            while(start <= end && a[end] > pivot){
                // a[end]가 pivot보다 작은 end를 찾는 과정
                end--;
            }

            if(start <end){
                // start가 end보다 작을때 실행
                // 정렬하기위해서
                int tmp = a[start];
                a[start] = a[end];
                a[end] = tmp;
                start++;
                end--;
            }
          
        }

        // pivot요소를 설정
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
