import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11660
// 구간 합 구하기 5 실버 1
// Scanner로 입력 받으니 시간초과 발생해서 BufferedReader 사용
public class Main_221128_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] sumMap = new int[N + 1][N + 1]; // (0,0)부터의 합
        sumMap[1][1] = map[1][1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sumMap[i][j] = sumMap[i][j - 1] + sumMap[i - 1][j]
                             - sumMap[i - 1][j - 1] +map[i][j];
            }
        }

        // 정답 구하기
        for (int M_i = 0; M_i < M; M_i++) {
            st = new StringTokenizer(br.readLine());
            int a_i = Integer.parseInt(st.nextToken());
            int a_j = Integer.parseInt(st.nextToken());
            int b_i = Integer.parseInt(st.nextToken());
            int b_j = Integer.parseInt(st.nextToken());
            int answer = sumMap[b_i][b_j]
                       - sumMap[a_i - 1][b_j]
                       - sumMap[b_i][a_j - 1]
                       + sumMap[a_i - 1][a_j - 1];
            System.out.println(answer);
        }
    }
}
