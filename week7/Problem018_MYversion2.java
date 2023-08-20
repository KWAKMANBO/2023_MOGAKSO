import java.util.*;
import java.io.*;

public class Problem018_MYversion2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] s = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        s[0] = a[0];
        int sum = s[0];

        for (int i = 1; i < a.length; i++) {
            s[i] = s[i - 1] + a[i];
            sum += s[i];
        }

        System.out.println(sum);
    }
}
