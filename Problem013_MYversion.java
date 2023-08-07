import java.io.*;
import java.util.*;

public class Problem013_MYversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            q.poll();
            q.offer(q.poll());

            if (q.size() == 1) {
                System.out.println(q.poll());
                break;
            }
        }
    }
}
