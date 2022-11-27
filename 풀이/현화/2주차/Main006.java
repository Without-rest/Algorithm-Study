import java.util.Scanner;

public class Main006 {
    static int count=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();//입력된 수
        for(int i=0;i<(N/2);i++){   //해당 수의 절반 이상 넘어가면 어차피 그 이상 넘어가기 때문에 계산 안함
            sumCal(i,N,0);
        }

        System.out.println(count+1);
    }

    /*
    n : 자연수를 하나씩 더해가기 위함
    goal : 더해서 나오게 할 수 (N)
    result : 반복문에서 자연수가 어디까지 더해졌는지 결과를 보기 위함
     */
    public static void sumCal(int n, int goal, int result){
        while(result<goal){//계속 더하다가 자연수가 목표수를 넘으면 반복문 중단
            int next = ++n;//변수에 n을 1 더해서 넣어줌
            result += next;//result에 next변수를 더해서 초기화함
        }
        if(result==goal) {
            count++;
        }
    }
}