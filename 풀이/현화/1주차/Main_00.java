import java.util.*;

public class Main_00 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.nextInt();//숫자의 개수
        int result=0;   //결과값

        sc.nextLine(); //nextInt와 nextLine 사이 엔터

        String tmp = sc.nextLine(); //공백없이 입력할 N개의 숫자

        for(char s: tmp.toCharArray()){ //tmp를 char 배열로 받아 하나씩 더해줌
            result+=Integer.parseInt(String.valueOf(s));
        }

        System.out.println(result);
    }
}