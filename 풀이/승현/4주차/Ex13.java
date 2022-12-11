import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Baekjoon_2164 {
    public static void main(String[] args) throws IOException {

        //카드의 개수 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //카드 큐 선언
        Queue<Integer> card = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            //카드에 자연수 값 넣기
            card.add(i);
        }
        //카드의 크기가 1일 될 때 남은 원소 출력
        while (card.size() > 1) {
            card.poll(); //card 위에 있는 값을 버림
            card.add(card.poll());  // card에 위에 있는 값 add해줘서 마지막으로 넣어주기
        }

        //출력하기
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(card.poll())); //남아있는 카드 출력해주기(bufferwriter toString으로 형변환)
        bw.flush(); //flush 해줘야 콘솔창에 보여줌
        bw.close();

    }

}
