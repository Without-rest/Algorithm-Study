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

        //배열 값 받기
        for(int i=0; i<N; i++) {
            Num[i] = sc.nextInt();
        }

        // 구간 M 개수대로 받기
        for(int q = 0; q <M; q++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
        }

        System.out.println(Arrays.toString(Num));
    }

}
