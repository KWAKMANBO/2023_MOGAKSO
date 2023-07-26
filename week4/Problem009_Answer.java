import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Problem009_Answer  {
    static int checkArr[]; // 각 DNA의 필요한 기준의 갯수를 저장할 배열
    static int myArr[]; // 부분 문자열에 존재하는 각 DNA의 갯수를 저장할 배열
    static int checkSecret; // 충족한 기준의 갯수를 저장
    
    private static void Add(char c){ // myArr을 갱신하는 함수
        switch(c){
            case 'A': 
                myArr[0]++;
                if(myArr[0]==checkArr[0]){
                    checkSecret++; 
                }
                break;
            case 'C':
                myArr[1]++;
                if(myArr[1] == checkArr[1]){
                    checkSecret++;
                }
                break;
            case 'G':
                myArr[2]++;
                if(myArr[2] == checkArr[2]){
                    checkSecret++;
                }
                break;
            case 'T':
                myArr[3]++;
                if(myArr[3] == checkArr[3]){
                    checkSecret++;
                }
                break;
        }
    }

    private static void Remove(char c){//제거되는 문자를 처리하는 함수
        switch(c){
            case 'A':
                if(myArr[0] == checkArr[0]){
                    checkSecret--;
                }
                myArr[0]--;
                break;
            case 'C':
                if(myArr[1] == checkArr[1]){
                    checkSecret--;
                }
                myArr[1]--;
                break;
            case 'G':
                if(myArr[2] == checkArr[2]){
                    checkSecret--;
                }
                myArr[2]--;
                break;
            case 'T':
                if(myArr[3] == checkArr[3]){
                    checkSecret--;
                }
                myArr[3]--;
                break;
        }
    }
    public static void main(String args[])throws NumberFormatException, IOException{
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int S = Integer.parseInt(st.nextToken()); // 전체 문자열의 길이
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열의 길이
        int Result = 0; 

        char A[] = new char[S]; // 문자형으로 S개만큼 선언
        checkArr = new int[4]; // 기준 배열을 선언
        myArr = new int[4]; // 문자열의 DNA개수 정보를담을 배열 크기를 선언
        checkSecret =0; // 충족한 기준의 개수를 저장

        A = bf.readLine().toCharArray(); // line을 읽어서 문자열을 문자 배열로 변환
       
        st = new StringTokenizer(bf.readLine()); // 

        for(int i =0; i < 4; i++){ // DNA 기준을 선언
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0)checkSecret++;
        }

        for(int i=0; i<P; i++){ // 첫번쨰 부분 문자열을 Add함수를 통해 myArr에 추가하고 checkArr과 비교해서 유효성 검증
            Add(A[i]);
        }   

        for (int i =P; i < S; i++){ // 두번쨰 문자열부터시작
            int j = i-P; // 삭제되는 인덱스
            Add(A[i]); // 추가되는 인덱스
            Remove(A[j]);
            if(checkSecret == 4){ //유효성이 타당하다면
                Result++;
            }
        }
        System.out.println(Result);
        bf.close();
     }
}
