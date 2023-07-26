import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Problem035_Answer {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int A[][] = new int[N][2];

        for (int i = 0; i < N; i++) {
            A[i][0] = sc.nextInt();
            A[i][1] = sc.nextInt();
        }

        Arrays.sort(A, new Comparator<int[]>() { // return 값을 기준으로 값을 변경함
            @Override
            public int compare(int S[], int E[]) {//
                if (S[1] == E[1]) {
                    return S[0] - E[0];
                }
                return S[1] - E[1];
            }
        });

        int count = 0;
        int end = -1;
        for (int i = 0; i < N; i++) {
            if (A[i][0] >= end) {
                end = A[i][1];
                count++;
            }
        }
        System.out.println(count);

    }
}
