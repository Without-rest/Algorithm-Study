import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //자기자신 경우의 수 미리넣고 초기화
        int count = 1;
        int start_idx = 1;
        int end_idx = 1;
        int sum = 1;

        while(end_idx != N) {
            if (sum == N) { //현재 연속된 합이 N과 같다
                count++;
                end_idx++;
                sum += end_idx;
            } else if (sum > N) { //현재 연속된 합이 N보다 크다
                sum -= start_idx;
                start_idx++;
            } else { //현재 연속된 합이 N보다 작다
                end_idx++;
                sum += end_idx;
            }
        }
            System.out.println(count);
        }
    }
