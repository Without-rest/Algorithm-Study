import java.io.*;

public class Baekjoon_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int answer = 0;
        //String배열 선언
        //-에서 잘라주기
        String[] num = str.split("-");
        for (int i = 0; i < num.length; i++) {
            int temp = mySum(num[i]); //결과값 sum함수 수행
            if (i == 0) {
                answer = answer + temp; //가장 앞에 있는 값만 더함
            } else {
                answer = answer - temp; //뒷 부분들은 빼기
            }
        }
            bw.write(Integer.toString(answer));
            bw.flush();
            bw.close();
    }
        static int mySum(String a) {
            int sum = 0;
            String temp[] = a.split("[+]");
            for(int i=0; i<temp.length;i++) {
                sum += Integer.parseInt(temp[i]);
            }
        return sum;
    }
}
