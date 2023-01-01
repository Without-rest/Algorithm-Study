import java.io.*;
import java.util.*;

class Main1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        Set hs = new HashSet();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            hs.add(num);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int num = Integer.parseInt(st.nextToken());
            boolean isPut = hs.add(num);    //set에 값이 들어가면(true) -> 값이 해당 set에 존재하지 않는다는 의미
                                            //set에 값이 들어가지 않으면(false) -> 값이 해당 set에 존재한다는 의미
            if(isPut){
                arr.add(0);
            }else{
                arr.add(1);
            }
        }

        for(int answer : arr){
            System.out.println(answer);
        }
    }
}
