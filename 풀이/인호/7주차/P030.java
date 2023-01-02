import java.util.*;
import java.io.*;

public class P030 {
    static int N, M;
    static int[] nums;
    static int maxNum = Integer.MIN_VALUE; // 최대값
    static int sumNum = 0; // 합계
    static int ans_sIdx, ans_eIdx, ans_mIdx; // 정답 구하기 위한 시작인덱스, 종료인덱스, 중간인덱스
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
            if (num > maxNum) {
                maxNum = num;
            }
            sumNum += num;
        }

        ans_sIdx = maxNum;
        ans_eIdx = sumNum;
        while(true) {
            ans_mIdx = (ans_sIdx + ans_eIdx) / 2;
            boolean isSuccess = true;
            int m = M;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (m == 0) { // 모두 넣기 전에 블루레이 모두 사용하면
                    isSuccess = false;
                    break;
                }
                sum += nums[i];
                if (sum > ans_mIdx) {
                    sum = 0; // 합 초기화
                    i--; // i 위치 되돌리기
                    m--; // 블루레이 개수 감소
                }
            }
            if (isSuccess) { // 이진 탐색
                answer = ans_mIdx;
                ans_eIdx = ans_mIdx - 1;
            } else {
                ans_sIdx = ans_mIdx + 1;
            }

            if (ans_eIdx < ans_sIdx) { // 종료조건
                break;
            }
        }

        bw.write(Integer.toString(answer));
        bw.flush();
    }
}
