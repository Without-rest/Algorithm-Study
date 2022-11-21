import java.util.Scanner;

public class Baekjoon_1546 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();

        double score[] = new double[a];

        for(int i = 0; i< a; i++) {
            score[i] = sc.nextInt();
        }

        double sum = 0;
        long max = 0;

        for(int i=0; i<a; i++) {
            if (score[i] > max) {
                max = (long) score[i];
            }
        }
        for(int i=0; i<a; i++) {
            score[i] = score[i] / max * 100.0;
            sum += score[i];
        }

        System.out.println(sum / a);
    }
}
