import java.util.*;
import java.io.*;

public class Problem021_MYversion {
    static int[] sorted;
    static long cnt = 0;

    public static void mergesort(int[] a, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;

        mergesort(a, left, mid);
        mergesort(a, mid + 1, right);

        merge(a, left, mid, right);
    }

    
    public static void merge(int[] a, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;

        while (l <= mid && r <= right) {
            
            if (a[l] > a[r]) {
                sorted[idx++] = a[r++];
                cnt += (mid+1 -l);
            } else {
                // 병합 해야될 리스트에서 a[l]이 a[l]보다 큰경우에
                // 그 인덱스 차이만큼을 카운트 해주면됨
                sorted[idx++] = a[l++];
            }
        }

            while (r <= right) {
                sorted[idx++] = a[r++];
            }

            while (l <= mid) {
                sorted[idx++] = a[l++];
            }

        for (int i = left; i <= right; i++) {
            a[i] = sorted[i];
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int A[] = new int[n];
        sorted = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        mergesort(A, 0, A.length - 1);

      System.out.println(cnt);

    }

}
