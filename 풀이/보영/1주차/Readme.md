Mo
## 알고리즘 스터디 1주차

### 백준 11730번
![image](https://user-images.githubusercontent.com/49936027/203457784-4d09780f-44af-4d25-8aa1-210d51a6d57c.png)

#### 풀이
```
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {		
		Scanner in = new Scanner(System.in);
 
		int N = in.nextInt();
		String a = in.next();
		in.close();
		
		int sum = 0;
        
		for(int i = 0; i < N; i++) {
			sum += a.charAt(i)-'0';
		}
		System.out.print(sum);
	}
}
```

#### 참고
[charAt 함수] (https://colossus-java-practice.tistory.com/31)
- chatAt 함수 반드시 알고 넘어가기
- charArrary 도 알고 가면 좋음!

### 백준 1546번
![image](https://user-images.githubusercontent.com/49936027/203458080-490856eb-dde9-4ea6-bfe8-93f3f0ff4e48.png)

```
import java.io.*;
import java.util.*;

```
- int / int 하면 2도 int라서 int로 (소숫점이 버려짐)
- int / double로 하면 doible

### 백준 11659번
![image](https://user-images.githubusercontent.com/49936027/203458160-904b4ce9-6f95-4de7-be22-99d2109411c9.png)

- 뺄셈 / 이중 for문 outoflange뜨니 주의


