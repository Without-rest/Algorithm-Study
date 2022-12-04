import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1940 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //재료의 개수 받기
        int N = Integer.parseInt(br.readLine());

        // 갑옷이 완성되는 번호의 합
        int M = Integer.parseInt(br.readLine());

        //배열 생성
        int[] A = new int[N];

        //StringTokenizer 사용
        StringTokenizer st = new StringTokenizer(br.readLine());

        //배열 받기
        for (int i=0; i< N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        //배열 오름차순으로 정렬
        Arrays.sort(A);

        //count, start_idx, end_idx
        int count = 0; //count 개수 세기
        int i = 0;    //start
        int j = N-1; // index니깐 하나 빼기

        while( i < j) {
            int sum = A[i] + A[j];
            //투 포인터 쓰기
            if(sum == M) {
                i++;
                j--;
                count ++;
            }else if(sum < M) {
                i++;
            }else if(sum > M) {
                j--;
            }
        }
        System.out.println(count);
        br.close();
    }
}
