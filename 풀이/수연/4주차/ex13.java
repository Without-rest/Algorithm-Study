import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1;i<=n;i++){
            queue.add(i);
        }

        boolean onOff = true;
        int endNum=1;
        while(!queue.isEmpty()){
            int num = queue.poll();
            endNum = num;
            if(onOff){
                /*버리기*/
                onOff = false;
            }else{
                /*다시넣기*/
                queue.add(num);
                onOff = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(endNum);
        System.out.println(sb);
    }
}
