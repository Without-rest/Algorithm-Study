import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1654 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //가지고있는 개수 받기
        int K = Integer.parseInt(st.nextToken());

        //만들 수 있는 랜선 개수
        int N = Integer.parseInt(st.nextToken());

        int[] A = new int[K];
        for(int i =0; i<N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        
        //정렬
        Arrays.sort(A);
      
        //...이진탐색..이해 불가..
      

    }
}
