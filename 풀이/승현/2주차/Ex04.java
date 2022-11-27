import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11660 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //N(배열 크기) M(구간 합 개수) 받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //합 배열 받기
        int Num[][] = new int[N+1][N+1];
        for( int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
           for (int j =1; j <= N; j++) {
               Num[i][j] = Integer.parseInt(st.nextToken());
           }
        }

        //구간 합 배열 선언
        int D[][] = new int[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            for( int j =1; j <= N; j++) {

                //구간 합 받기
                D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + Num[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();

        for ( int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            // 자리 값 받기
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            //횟수대로 구간 합
            int result = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1];
            sb.append(result+"\n");
        }
        System.out.println(sb);
    }
}
