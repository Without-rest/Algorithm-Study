import java.util.Scanner;
public class Backjoon_11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();

        String num = sc.next();

        char[] cNum = num.toCharArray();

        int sum = 0;

        for(int i =0; i<cNum.length; i++) {
            sum += cNum[i] - '0';
        }
        System.out.print(sum);
    }
}
