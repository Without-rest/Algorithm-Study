import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int n =Integer.parseInt(st.nextToken());
        int stack_num = 1;
        boolean isEnable = true;

        for(int j=1;j<n+1;j++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            while(stack.isEmpty()||stack.peek()!=num){

                if(stack_num>=n+1){
                    isEnable = false;
                    break;
                }

                stack.push(stack_num++);
                sb.append("+\n");
            }

            if(!isEnable){
                sb = new StringBuilder();
                sb.append("NO");
                break;
            }

            if(stack.peek()==num){
                stack.pop();
                sb.append("-\n");
            }

        }

        System.out.println(sb);
    }
}
