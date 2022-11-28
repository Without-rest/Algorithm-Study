import java.util.Scanner;

public class Ex006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sIdx = 1;
        int eIdx = 1;
        int sum = 1;
        int cnt = 0;
        int idx = 0;

        while (true) {
            idx++;
            if (sum < N) {
                eIdx++;
                sum += eIdx;
            } else if (sum == N) {
                cnt++;
                sIdx++;
                eIdx++;
                sum -= sIdx - 1;
                sum += eIdx;
            } else if (sum > N) {
                sIdx++;
                sum -= sIdx - 1;
            }
            if (sIdx > N) {
                break;
            }
        }

        System.out.println(cnt);



    }
}
