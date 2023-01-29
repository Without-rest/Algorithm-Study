package baekjoon;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1744
 * 수 묶기 골드4
 *
 * 풀이 230129
 *
 * 아이디어: 가능한 큰 수끼리 곱하면 수가 커질 것이다.
 * 1. 큰 수 순으로 정렬한다.
 * 2. 큰 수부터 차례대로 2개씩 묶어서 곱하고 더한다.
 * 3. 묶어서 곱하는 것은 수가 1이 되기 전까지 시행한다. (1은 곱하는 게 손해이므로 그냥 더해준다.)
 * 4. 0 포함한 음수에 대해서도 처리해줘야된다. 음수는 절대값이 큰 거부터 해서 묶어서 곱하고 더한다.
 *
 * 생각할 케이스:
 * 1. 1은 곱하지 않고 더해야 한다.
 * 2. 음수끼리는 곱한다.
 */
public class P1744_230129 {
    static int N;
    static Integer[] numArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        numArr = new Integer[N];
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numArr, Collections.reverseOrder());

        boolean hasBinding = false; // 두 수를 묶을 때 묶을 첫번째 숫자 가지고 있는지
        int bindingNum = 0; // 두 수를 묶을 때 묶을 첫번째 숫자
        int sum = 0; // 합

        // 양수에 대해서 처리
        for (int i = 0; i < N; i++) {
            if (numArr[i] <= 0) { // 0이하면 묶지 않고 넘기기
                if (hasBinding) { // 묶인 숫자가 있으면 먼저 그 숫자 더하기
                    sum += bindingNum;
                    hasBinding = false;
                }
                break;
            }
            if (numArr[i] == 1) { // 1이면 그냥 더하기
                sum += numArr[i];
                continue;
            }
            if (!hasBinding) { // 묶인 숫자가 없으면
                bindingNum = numArr[i];
                hasBinding = true;
                continue;
            } else { // 묶인 숫자가 있으면
                sum += bindingNum * numArr[i];
                hasBinding = false;
                continue;
            }
        }

        // 0 포함한 음수에 대해서 처리
        for (int i = N - 1; i >= 0; i--) {
            if (numArr[i] > 0) { // 양수이면
                if (hasBinding) { // 묶인 숫자가 있으면 그 숫자 더해주기
                    sum += bindingNum;
                    hasBinding = false;
                }                
                break;
            }
            if (!hasBinding) { // 묶인 숫자가 없으면
                bindingNum = numArr[i];
                hasBinding = true;
                continue;
            } else { // 묶인 숫자가 있으면
                sum += bindingNum * numArr[i];
                hasBinding = false;
                continue;
            }
        }

        if (hasBinding) { // 남아있는 묶인 숫자가 있으면 그 숫자 더해주기
            sum += bindingNum;
        }

        bw.write(Integer.toString(sum));
        bw.flush();
    }
}
