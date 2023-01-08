import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String s = "";
        int ans = 0;
        boolean onOff = false;
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c!='-'&&c!='+'){
                s+=c;
            }else{
                if(onOff){
                    stack.push(Integer.parseInt(s));
                    s = "";
                }else{
                    ans += Integer.parseInt(s);
                    s = "";
                }

                if(c=='-'){
                    onOff = true;
                }
            }
        }

        if(onOff){
            stack.push(Integer.parseInt(s));
        }else{
            ans += Integer.parseInt(s);
        }

        while(!stack.isEmpty()){
            int num = stack.pop();
            ans -= num;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ans);
        System.out.println(sb);
    }
}
