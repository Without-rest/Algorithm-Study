import java.util.*;

public class Main_001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String numStr = sc.next();
        int sum = 0;
        for (int NIdx = 0; NIdx < N; NIdx++) {
            sum += (numStr.charAt(NIdx) - '0');
        }
        System.out.println(sum);
    }
}
