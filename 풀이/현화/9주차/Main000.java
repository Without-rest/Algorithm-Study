import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

class Main000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int zeroCnt = 0;
        int result = 0;

        PriorityQueue<Integer> plusQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusQ = new PriorityQueue<>();

        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            if(num<0){
                minusQ.offer(num);
            }else if(num>0){
                plusQ.offer(num);
            }else{
                zeroCnt++;
            }
        }

        while(!plusQ.isEmpty()){
            int num1=0;
            int num2=0;
            num1 = plusQ.poll();
            if(!plusQ.isEmpty()){
                num2 = plusQ.poll();
            }

            if (num2 != 0) {
                if(num1==1 || num2==1){
                    result+=(num1+num2);
                }else {
                    result += (num1 * num2);
                }
            } else {
                result += num1;
            }

        }

        while(!minusQ.isEmpty()){
            int num1=0;
            int num2=0;
            num1=minusQ.poll();
            if(!minusQ.isEmpty()){
                num2=minusQ.poll();
            }
            if(num2!=0){
                result+=(num1*num2);
            }else{
                if(zeroCnt>0){

                }else{
                    result+=num1;
                }
            }
        }

        System.out.println(result);

    }
}
