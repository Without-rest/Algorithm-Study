import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();//과정을 담을 스택
        Queue<Integer> q = new LinkedList<>();//입력값들을 받는 큐

        ArrayList<String> answer = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());//입력
        for(int i=0;i<n;i++){
            q.add(Integer.parseInt(br.readLine()));
        }

        int idx=1;//스택에 초기값 하나 넣어줌
        stack.add(idx);
        answer.add("+");

        while(!q.isEmpty()){    //입력값들을 모두 비교할때까지
            int num = q.peek();//입력값 하나 뺌(삭제X)

            if(idx>n){ //스택에 담을 값이 입력값보다 커지면 반복문 종료함
                answer.clear();
                answer.add("NO");
                break;
            }

            if(stack.isEmpty()){    //스택이 빈 상태이면
                stack.add(++idx);//스택에 값 하나 넣어줌
                answer.add("+");
            }else {//빈 상태 아니라면
                //스택에서 하나 뺀 값과 입력값(queue에서 하나 뺸 값)을 비교함
                if (stack.peek().intValue() == num) {//두 개의 값이 같으면
                    stack.pop();//스택에서 하나 뺀 후 삭제
                    q.poll();//입력된 값도 매칭되었으니 삭제
                    answer.add("-");
                } else {//두개 값이 같지 않다면 다음 값을 스택에 넣어줌
                    stack.add(++idx);
                    answer.add("+");
                }
            }
        }

        for(String str : answer){
            System.out.println(str);
        }
    }
}
