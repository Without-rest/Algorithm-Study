import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_11659 {
    public static void main(String[] args) {
        //1. 초기 코드
        //데이터의 개수, 질의 개수 받기

        Scanner sc = new Scanner(System.in);

        //배열 데이터, 횟수 개수
        int N = sc.nextInt();
        int M = sc.nextInt();

        //배열 선언
        int Num[] = new int[N];
        
        //0번째 값 먼저 받기
        Num[0] = sc.nextInt();

        //합 배열 값 받기
        for(int i=1; i<N; i++) {
            //합 배열 공식 S[i] = S[i-1] + A[i]
            Num[i] = Num[i - 1] + sc.nextInt();
        }

        // 구간 M 개수대로 받기
        for(int q = 0; q <M; q++) {
            int start = sc.nextInt() -1;
            int end = sc.nextInt() -1 ;

            int sum = 0;

            if(start == 0) {
                sum = Num[end];
            }else {
                //구간 합 공식 : S[j] - S[i-1]
                sum = Num[end] - Num[start-1];
            }
            System.out.println(sum);
        }
    }

}
