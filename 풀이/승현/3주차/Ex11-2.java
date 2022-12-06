import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Baekjoon_1874_2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        //스택 선언
        Stack<Integer> stack = new Stack<>();

        // + ,- 담을 ArrayList 리스트 생성
        ArrayList<String> arr = new ArrayList();

        //수열 개수 받기
        int N = sc.nextInt();

        //1~N까지 들어갈 배열
        int[] num = new int[N];
        for(int i =0; i<N; i++) {
            num[i] = sc.nextInt();
        }

        //수열 index
        int idx = 0;

        for(int i =1; i<=N; i++) {
            stack.push(i);
            arr.add("+" + "\n");
            while (!stack.isEmpty()) {
                //stack에서의 top과 num의 숫자가 같을 경우
                if (stack.peek() == num[idx]) {
                    stack.pop();
                    arr.add("-" + "\n");
                    idx++;
                } else {
                    break;
                }
            }
        }
        //stack이 비어있지 않으면 연산이 제대로 수행되지 못하므로 NO출력
            if(!stack.isEmpty()) {
                System.out.print("NO" );
            }else {
                //아닌경우 arr출력
                for (String st : arr) {
                    System.out.print(st);
                }
            }
        }

    }
