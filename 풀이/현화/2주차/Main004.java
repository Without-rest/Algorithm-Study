import java.util.Scanner;

public class Main004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //표의 크기
        int M = sc.nextInt(); //합을 구해야하는 횟수
        int[][] arr = new int[N][N];
        int[] result = new int[M];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        for(int k=0;k<M;k++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for(int y=y1-1;y<y2;y++){
                for(int x=x1-1;x<x2;x++){
                    result[k]+=arr[x][y];
                }
            }
        }

        for(int n : result){
            System.out.println(n);
        }
    }
}