package baekjoon;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/12891
// DNA 비밀번호 실버2
// 문자열 길이 모든 경우의 수 다 했다..
public class P009_2 {
    static char[] g_DNA = new char[] {'A', 'C', 'G', 'T'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        String STR = br.readLine();

        st = new StringTokenizer(br.readLine());
        int[] REQS = new int[4]; // 최소개수
        int[] reqs = new int[4]; // 남아있는 각각 dna 최소개수 (해당될 때마다 하나씩 감소)
        int REQS_LENGTH = 0; // 최소 값들 총 길이
        for (int i = 0; i < REQS.length; i++) {
            reqs[i] = Integer.parseInt(st.nextToken());
            REQS_LENGTH += REQS[i];
        }
        int answer = 0;
        int sIdx = 0;
        int eIdx = 0;
        boolean isAnswer = check(STR.charAt(eIdx), reqs);
        while (sIdx + REQS_LENGTH <= STR.length()) {
            // 정답 체크
            if (isAnswer) {
                System.out.println("sIdx: " + sIdx + ", eIdx: " + eIdx);
                answer += STR.length() - eIdx; // 정답에서 eIdx 큰 모든 것들 정답처리
                System.out.println("answer: " + answer);
                isAnswer = check(STR.charAt(sIdx), reqs, true); // 정답 체크
                sIdx++;
            } else { // 정답이 아니라면
                if (eIdx < STR.length() - 1) {
                    eIdx++;
                    isAnswer = check(STR.charAt(eIdx), reqs);
                } else {
                    break;
                }
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
            System.out.println("reqs[i]: " + reqs[i]);
        }
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
