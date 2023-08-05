package week5;
import java.util.Stack;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;

public class Problem011_MYversion {
    static ArrayList<Character> ch = new ArrayList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();

        int arr[] = new int[N];

        // stack.push(1);
        // System.out.println(stack.peek());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());

        }
        int num = 1;
        int idx = 0;

        for (int i = 1; i <= arr[idx]; i++) {
            stack.push(i);
            System.out.println('+');
        }

        int sp = 0;

        try {
            while (!stack.isEmpty()) {
                int i = 1;

                if (arr[idx] >= stack.peek()) {
                    while (arr[idx] > stack.peek()) {

                        stack.push(sp + i);
                        ch.add('+');
                        i++;
                    }
                    sp = stack.pop();
                    ch.add('-');
                } else {
                    sp = stack.pop();
                    ch.add('-');
                }
                idx++;
            }
        } catch (Exception e) {

        }

        if (stack.isEmpty()) {
            System.out.println("NO");
        } else {
            for (char c : ch) {
                System.out.println(c);
            }
        }
    }
}
