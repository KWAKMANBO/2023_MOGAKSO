import java.util.*;
import java.io.*;

public class Problme017_Answer {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        int[] A = new int[str.length()];

        for(int i=0; i <  str.length(); i++){
            A[i] =  Integer.parseInt(str.substring(i, i+1)); // 한글자씩 반환 
            // substirng은 마지막 index는 반환x
        }

        for(int i =0; i < str.length(); i++){
            int max =i; //max에는 value가 아닌 index를 저장

            for(int j=i+1; j < str.length(); j++){
                if(A[j] > A[max]){
                    max =j;
                }
            }

            if(A[i] < A[max]){
                int temp = A[i];
                A[i] = A[max];
                A[max] = temp;
            }
        }

        for(int i=0; i < A.length; i++){
            System.out.print(A[i]);
        }

    }
}

// substring이란?
// String substring(int beginindex, int endindex) 형식으로 사용
// 입력 인자 값은 2개 beginindex, endindex
// beginindex는 가져올 문자의 시작 부분을 지정
// endindex는 가져올 문자열의 끝 부분을 지정 endindex전까지의 index를 반환 --> endindex를 포함 x

