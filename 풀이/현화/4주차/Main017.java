import java.io.*;
import java.util.*;

public class Main017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> plusPq = new PriorityQueue<>();
        PriorityQueue<Integer> minusPq = new PriorityQueue<>(Collections.reverseOrder());

        ArrayList<Integer> answer = new ArrayList<>();

        for(int i=0;i<N;i++){
            int x = Integer.parseInt(br.readLine());

            if(x<0){
                minusPq.offer(x);
            }else if(x>0){
                plusPq.offer(x);
            }else{
                if(plusPq.isEmpty() && minusPq.isEmpty()){
                    answer.add(0);
                    continue;
                }

                if(plusPq.isEmpty()){
                    answer.add(minusPq.poll());
                }else if(minusPq.isEmpty()){
                    answer.add(plusPq.poll());
                }else{
                    int nega = minusPq.peek();
                    int posi = plusPq.peek();
                    answer.add(Math.abs(nega)>Math.abs(posi)?plusPq.poll():minusPq.poll());
                }
            }
        }

        for(int n : answer){
            System.out.println(n);
        }
    }
}
