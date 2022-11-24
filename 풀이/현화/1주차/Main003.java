import java.util.Scanner;

public class Main003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //수의 개수
        int M = sc.nextInt(); //합을 구해야 하는 횟수
        int[] sumArr = new int[N]; //합 배열
        int[] result = new int[M]; //결과 담을 배열

        sumArr[0]=sc.nextInt();
        for(int i=1;i<N;i++){
            sumArr[i]=sumArr[i-1]+sc.nextInt(); //합배열에 입력된 수들을 담아줌
        }

        int count = 0;//M만큼 반복하도록
        while (count<M){
            int bgn = sc.nextInt(); //구간 합의 시작 인덱스
            int end = sc.nextInt(); //구간 합의 끝 인덱스
            if(bgn==1){ //구할 구간 합의 시작 인덱스가 1일 경우 결과에 끝 인덱스만 넣어줌
                result[count]=sumArr[end-1];
            }else{ // 1이 아닐 경우 끝 인덱스에서 시작 인덱스 '전'의 인덱스를 빼줌(시작 인덱스는 포함 되어야 함)
                result[count]=sumArr[end-1]-sumArr[bgn-2];
            }
            count++;
        }
        for(int n : result){
            System.out.println(n);
        }

    }
}