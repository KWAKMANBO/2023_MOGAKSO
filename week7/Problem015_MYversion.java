import java.util.*;
import java.io.*;

public class Problem015_MYversion {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                // swap
                if (A[j] > A[j + 1]) {
                    int tmp = A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = tmp;
                }
            }
        }

        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }
}
