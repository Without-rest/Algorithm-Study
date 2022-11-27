## Sting Builder/String Buffer, String

```java
String str = "hello";
str = str + "world";
```

→ 기존에 “hello” 값이 들어가있던 String 클래스의 참조변수 str이 “hello world”라는 값을 가지고

있는 새로운 메모리영역을 가리키게 변경되고 

처음 선언했던 “hello”로 값이 할당되어 있던 메모리 영역은 Garbage로 남아있다가 Garbage Collection에 의해 사라지게 되는 것.

string은 불변하기 때문에 문자열을 수정하는 시점에 새로운 String 인스턴스가 생성된 것.

연산이 많이 일어나는 경우 알고리즘에 String 클래스를 사용하게 되면 **힙 메모리(heap)에 임시 가비지가 생성되어 메모리 부족**으로 Application성능에 영향을 끼친다.

⇒ 가변선을 가지는 StringBuffer/StringBuilder 클래스 도입

.append() , .delete() 

```java
StringBuffer sb = new StringBuffer("hello");
sb.append("world");
```

StringBuffer - String Builder 차이점 → 동기화의 유무

StringBuffer : 동기화 지원x , 멀티쓰레드 환경에서 사용하는 것은 적합하지 않다.

## 구간 합 구하기2

-백준 11660

**풀이 참고**

[https://propercoding.tistory.com/29](https://propercoding.tistory.com/29)

### 다이나익 프로그래밍(DP)로 푸는 문제

개념 **참고 사이트**

[https://propercoding.tistory.com/entry/알고리즘-다이나믹-프로그래밍-Dynamic-Programming](https://propercoding.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D-Dynamic-Programming)

큰 문제를 작은 문제로 쪼개서 푸는 기법.

모든 작은 문제들은 단 한번만 풀어야 한다.

접근 방식 : Bottom-up / Top-down 방식

Bottom-up : 작은 문제부터 구해 나아가서 큰 문제를 해결하는 방법(for 문을 이용)

Top-down : 재귀 함수를 이용해서 큰 문제를 풀 때 작은 문제를 필요로 할 때 문제를 해결.(재귀함수)

- **문제 풀이 1**
    
    행별로 누적 합을 구하는 것
    
- **문제 풀이2**
    
    (1,1)부터 (i,j)까지 누적합을 구해서 푸는 것
