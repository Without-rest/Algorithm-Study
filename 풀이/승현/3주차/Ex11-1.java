import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon_1874 {
    public static void main(String[] args) throws IOException {
      
      /*풀다 만 풀이*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //수열의 값 받기
        int N = Integer.parseInt(br.readLine());

        //수열 배열
        int[] a = new int[N];

        //배열 값 받기
        for(int i=0; i< N; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        //스택 선언
        Stack<Integer> st = new Stack<>();

        StringBuffer sb = new StringBuffer();

        int num = 1; //오름차순 순
        boolean result = true;



    }
}
