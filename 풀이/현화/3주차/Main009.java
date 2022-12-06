import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main009 {
    static int S;
    static int P;
    static int answer;
    static String DNA;
    static HashMap<Character,int[]> hm = new HashMap<>();
    static char[] dna = {'A','C','G','T'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        DNA = br.readLine();
        st = new StringTokenizer(br.readLine());


        // HashMap의 구조 : (DNA문자, {현재 카운트, 최소 조건})
        for (char c : dna) {
            hm.put(c, new int[] {0, Integer.parseInt(st.nextToken())});
        }

        // 처음 P만큼 자른 문자열을 카운트하고 조건을 만족하는지 체크
        for (int i = 0; i < P; i++) {
            hm.get(DNA.charAt(i))[0]++;
        }
        if(isFull()) answer ++;

        // 인덱스를 1씩 증가시켜가며 가장 왼쪽 문자 삭제, 가장 오른쪽 문자 추가
        // 카운트를 모두 새로 하는것이 아닌 왼쪽 끝은 -1 오른쪽 끝은 +1한다.
        for (int i = 0; i < S-P; i++) {
            hm.get(DNA.charAt(i))[0] -= 1;
            hm.get(DNA.charAt(i + P))[0] += 1;
            if(isFull()) answer ++;
        }
        System.out.println(answer);

    }
    public static boolean isFull() {
        for (char c : dna) {
            if (hm.get(c)[0] < hm.get(c)[1]) return false;
        }
        return true;

    }


}
