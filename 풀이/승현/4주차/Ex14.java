import java.io.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Baekjoon_11286 {
    public static void main(String[] args) throws IOException {

        //연산의 개수 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //우선 순위 큐 선언
        PriorityQueue<Integer> pr = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            //절대값 비교하기
            public int compare(Integer o1, Integer o2) {
                int first = Math.abs(o1);
                int second = Math.abs(o2);

                if(first > second) {
                    return 1; //우선순위가 올라간다.
                }else if(first == second) {
                    //절대값이 같으면 작은 수 먼저
                    return o1 -o2;
                }else {
                    return -1; //우선순위가 내려간다.
                }
            }
        });
        
        //StringBuilder 사용하여 출력 한꺼번에 나오게
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pr.isEmpty()) {
                    //입력이 0이고 우선순위가 비어있으면 0을 출력
                  sb.append("0").append("\n");
                } else {
                    //비어있지 않으면 큐의 front 출력
//                   System.out.println(pr.poll());
                    sb.append(pr.poll()).append("\n");
                }
            } else {
                //새로운 데이터 우선순위 큐에 더하기
                pr.add(x);
            }
        }
        System.out.println(sb);
        br.close();
    }
}
