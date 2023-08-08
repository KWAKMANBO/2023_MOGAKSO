package week6;
import java.io.*;
import java.util.*;
// Queue, LinkedList, 사용

public class Problem013_MYversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (q.size() != 1) {
            q.poll();
            q.offer(q.poll());
        }

        System.out.println(q.poll());

    }
}
