import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1874
// 스택 수열 실버3
public class P011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        boolean isSuccess = true;
        Stack<Integer> stack = new Stack<>();
        int stackNum = 0; // 최근에 스택에 들어간 수
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            while (true) {
                if (stack.isEmpty()) { // 비었을 경우
                    // 스택에 수 넣기
                    if (stackNum + 1 > n) { // 스택에 더이상 넣을 수가 없을 경우
                        isSuccess = false;
                        break;
                    } else {
                        stackNum++;
                        stack.push(stackNum);
                        sb.append("+\n");
                    }
                } else if (stack.peek() == num) { // 꺼낼 수 있는 경우
                    stack.pop();
                    sb.append("-\n");
                    break;
                } else { // 꺼낼 수 없는 경우
                    // 스택에 수 넣기
                    if (stackNum + 1 > n) { // 스택에 더이상 넣을 수가 없을 경우
                        isSuccess = false;
                        break;
                    } else {
                        stackNum++;
                        stack.push(stackNum);
                        sb.append("+\n");
                    }
                }
            }

            if (!isSuccess) { // 실패했을 경우
                break;
            }
        }

        if (isSuccess) {
            bw.write(sb.toString());
            bw.flush();
        } else {
            bw.write("NO");
            bw.flush();
        }
    }
}
