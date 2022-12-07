import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); /*문자열 길이*/
        int m = Integer.parseInt(st.nextToken()); /*부분문자열 길이*/

        st = new StringTokenizer(br.readLine());
        String str = st.nextToken(); /*문자열*/

        st = new StringTokenizer(br.readLine());
        int minArr[] = new int[4]; /*'A','C','G','T' 각문자 최소 갯수 배열*/
        for(int i=0;i<minArr.length;i++){
            minArr[i] = Integer.parseInt(st.nextToken());
        }

        int sIdx = 0; /*시작 index*/
        int eIdx = m; /*끝 index +1*/
        int total = 0; /*만족하는 부분문자열 갯수*/
        int count[] = new int[4]; /*부분문자열에서 사용한 각 문자의 갯수*/

        while(eIdx < n+1){
            /*마지막 index가 n보다 작을때 까지*/
          
            /*부분문자열 각 문자 갯수 구하기*/
            if(sIdx == 0) {
                String subStr = str.substring(sIdx,eIdx); /*부분문자열*/
                for (int j = 0; j < subStr.length(); j++) {
                    char c = subStr.charAt(j);
                    switch (c) {
                        case 'A':
                            count[0]++;
                            break;
                        case 'C':
                            count[1]++;
                            break;
                        case 'G':
                            count[2]++;
                            break;
                        case 'T':
                            count[3]++;
                            break;
                        default:
                            break;
                    }
                }
            }else{
                char msChar = str.charAt((sIdx-1));
                char psChar = str.charAt((eIdx-1));
                switch (msChar) {
                    case 'A':
                        count[0]--;
                        break;
                    case 'C':
                        count[1]--;
                        break;
                    case 'G':
                        count[2]--;
                        break;
                    case 'T':
                        count[3]--;
                        break;
                    default:
                        break;
                }

                switch (psChar) {
                    case 'A':
                        count[0]++;
                        break;
                    case 'C':
                        count[1]++;
                        break;
                    case 'G':
                        count[2]++;
                        break;
                    case 'T':
                        count[3]++;
                        break;
                    default:
                        break;
                }
            }
            /*각문자 최소갯수 check*/
            boolean isEnable = true;
            for(int i=0;i<count.length;i++){
                if(minArr[i]>count[i]){
                    isEnable = false;
                    break;
                }
            }

            if(isEnable) total++;

            sIdx++;
            eIdx++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(total);
        System.out.println(sb);
    }
}
