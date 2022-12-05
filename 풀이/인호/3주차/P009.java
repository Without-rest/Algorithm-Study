package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/12891
// DNA 비밀번호 실버2
public class P009 {
    static char[] g_DNA = new char[] {'A', 'C', 'G', 'T'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String STR = br.readLine();

        st = new StringTokenizer(br.readLine());
        int[] reqs = new int[4]; // 남아있는 각각 dna 최소개수 (해당될 때마다 하나씩 감소)
        for (int i = 0; i < reqs.length; i++) {
            reqs[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        int sIdx = 0;
        int eIdx = P - 1;
        boolean isAnswer = false;
        for (int i = 0; i < P; i++) {
            isAnswer = check(STR.charAt(sIdx + i), reqs);
        }
        while (true) {
            // 정답 체크
            if (isAnswer) {
                answer++;
            }
            if (eIdx + 1 < STR.length()) {
                isAnswer = check(STR.charAt(sIdx), reqs, true);
                sIdx++;
                eIdx++;
                isAnswer = check(STR.charAt(eIdx), reqs);
            } else {
                break;
            }
        }
        bw.write(Integer.toString(answer));
        bw.flush();
    }

    /**
     * 모두 만족하게 됐는지 체크
     * @param ch
     * @param reqs
     * @param isPlus 더하는지
     * @return
     */
    public static boolean check(char ch, int[] reqs, boolean isPlus) {
        for (int i = 0; i < g_DNA.length; i++) {
            if (ch == g_DNA[i]) { // 글자 찾았으면
                if (!isPlus) { // 빼는 거라면
                    reqs[i]--;
                    break;
                } else { // 더하는 거라면
                    reqs[i]++;
                    break;
                }
            }
        }

        // 정답 체크
        for (int i = 0; i < reqs.length; i++) {
            if (reqs[i] > 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean check(char ch, int[] reqs) {
        return check(ch, reqs, false);
    }
}
