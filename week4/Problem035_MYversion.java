import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class time {
    private int start;
    private int end;

    public time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public time() {
        this.start = 0;
        this.end = 0;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}

public class Problem035_MYversion {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        ArrayList<time> time_list = new ArrayList<>();
        ;

        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            time_list.add(new time(start, end));
        }

        // 시작 시간순서로 정렬
        Collections.sort(time_list, new Comparator<time>() {
            @Override
            public int compare(time t1, time t2) {
                return Integer.compare(t1.getEnd(), t2.getEnd());
            }
        });

        int cnt = 1;
        int start_time = time_list.get(0).getEnd();

        for (int i = 1; i < N; i++) {
            if (time_list.get(i).getStart() > start_time) {
                start_time = time_list.get(i).getEnd();
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
// Collection이란?
// Collection객체는 여러 원소들을 담을 수 있는 자료구조
// 배열과의 차이점 동적 메모리 할당을 할 수 있음 --> 공간이 계속 필요한 만큼 추가할 수 있음
// Collection은 인터페이스임 즉 상속받아 구현해야됨

// Comparator와 Comparable란?
// 둘다 모두 객체간 값의 비교를 위해서 필요한 메서드를 정리해놓은 인터페이스임
// Primitive(byte, short, int, long, float, double, char, boolean, )와
// 각 primitive 유형에 해당하는 래퍼 클래스 (Integer, Double, Character등을 제공함
// Comparator와 Comparable은 사용자 정의 객체를 사용 하거나 class내에서 특수한 상황속에서
// 비교 메서드가 구현할 필요가 있는 경우 사용할 수 있고
// 또는 기존의 비교 방식이 아닌 다른 방식의 비교를 사용하고 싶을 때 사용할 수 있음

// Compartor 인터페이스를 기반으로 비교 메소드를 정의하기 위해서는 반드시 compare함수를 override 해줘야함
// 이 경우 Compare함수는 2개의 인자를 받게되고 이를 대소비교 하여 크기를 비교함

// Comparable 인터페이스를 사용하기 위해서는 compareTo메소드를 override 해줘야함
// Comparable은 자기자신과 입력받은 인자를 서로 비교하여 크기비교를 함
