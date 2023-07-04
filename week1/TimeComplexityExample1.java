public class TimeComplexityExample1{
    public static void main(String[] args){
        // 1~100 사이의 난수를 생성
        int findNumber = (int)(Math.random()*100);
        for(int i = 0; i < 100; i++){
            if( i == findNumber){
                System.out.println(i);
                break;
            }
        }
    }
}

//  0~99 사이의 무작윗 값을 출력하는 코드
// 빅 오메가(Ω(n)) 표기법으로는 1
// 빅 세타 표기법으로는 N/2
// 빅 오 표기법으로는 N