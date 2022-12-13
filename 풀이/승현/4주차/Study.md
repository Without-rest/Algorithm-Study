BufferWriter: 버퍼를 이용한 출력

```java
BufferWriter bw = new BufferWriter(new OutputStreamWriter(System.out);
bw.write();
```

출력하기 위해서는 **String형으로의 변환이 필요**

bw.flush() : 내부 버퍼의 내용을 파일에 writer 한다. flush()를 호출하지 않는다면 내용이 버퍼에만 남고 파일에는 쓰이지 않는 상황이 나올 수 있다.

bw.close() : 스트림을 이용하여 파일의 내용을 읽어드린다. close()를 호출하여 스트림을 닫으면 그 스트림을 다시 이용하여 파일에 쓰는것이 불가능하다. 스트림을 닫아 종료된 작업에 대한 메모리를 확보해야 한다.

*우선순위 큐

: 값이 들어가는 순서와 상관 없이 우선순위가 높은 데이터가 먼저 나오는 자료구조

큐 설정에 따라 front에 항상 최댓값 또는 최솟값이 위치

→ **heap을 이용해 구현(가장 효율적)**

(배열, 연결리스트, 힙으로 구현이 가능)

### 힙(Heap)

: 완전 이진 트리의 일종(부모 노드를 시작으로 좌측에서 채워져 있는 구조의 이진 트리)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b1c6950d-0b8a-4918-b4f5-278060233263/Untitled.png)

출처 : [https://abcdefgh123123.tistory.com/353](https://abcdefgh123123.tistory.com/353)

→ 우선순위 큐를 이용하여 만들어진 자료구조

여러 개의 값들 중에서 **최댓값이나 최솟값을 빠르게 찾아내**도록 만들어진 자료구조

**반정렬 상태**(느슨한 정렬 상태)

큰 값이 상위 레벨에 있고 작은 값이 하위 레벨에 있다. ⇒ 부모 노드의 키 값이 자식 노드의 키 값보다 항장 큰(작은) 이진트리

- **최대 힙**
    
    : 부모 노드의 키 값 ≥ 자식 노드의 키 값
    
- **최소 힙**
    
    : 부모 노드의 키 값 ≤ 자식 노드의 키 값
    

→ **중복 허용**( 이진 탐색 트리에서는 중복된 값 허용 x)

**시간 복잡도**

1. 삽입, 삭제 **O(longn)**

## 힙(Heap)의 구현

- 힙을 저장하는 표준적인 자료구조는 **배열**
- 구현을 쉽게 하기 위해 배열의 첫번째 index인 0은 사용하지 않는다.
- 특정 위치의 노드 번호는 새로운 노드가 추가되어도 변하지 않는다.

    → 루트 노드의 오른쪽 노드의 번호는 항상 3이다.
    
    ![Untitled](https://user-images.githubusercontent.com/79103761/207066770-181f99e3-f523-4fc2-bb5a-5d65d4886ecd.png)

**힙에서의 부모 노드와 자식 노드의 관계**

- 왼쪽 자식의 인덱스 = (부모의 index) * 2
- 오른쪽 자식의 인덱스 = (부모의 index) * 2 +1
- 부모의 인덱스 = (자식의 인덱스) / 2

### 힙의 삽입

1. 힙의 새로운 요소가 들어오면, 새로운 노드를 힙의 마지막 노드에 이어서 삽입.
2. 새로운 노드를 부모 노드들과 교환해서 힙의 성질을 만족시킨다.

### 힙의 삭제

1. 최대 힙에서 **최대값은 루트 노드**
    
    → 루트 노드 삭제
    
2. 삭제된 루트 노드에는 힙의 마지막 노드를 가져온다.
3. 힙을 **재구성**

설명 출처 : [https://gmlwjd9405.github.io/2018/05/10/data-structure-heap.html](https://gmlwjd9405.github.io/2018/05/10/data-structure-heap.html)

## Priority Queue 선언

```java
import java.util.PriorityQueue;
import java.util.Collections;

//낮은 숫자가 우선 순위인 int 형 우선순위 큐 선언
PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<>();

//높은 숫자가 우선 순위인 int 형 우선순위 큐 선언
PriorityQueue<Integer> priorityQueueHighest = new PriorityQueue<>(Collections.reverseOrder());
```

```java
priorityQueueLowest.add(); 

//첫번째 값을 반환하고 제거, 비어있다면 null
priorityQueueLowest.poll()

// 첫번째 값 제거 비어있다면 예외 발생
priorityQueueLowest.remove(); 

// 첫번째 값을 반환만 하고 제거 하지는 않는다.
// 큐가 비어있다면 null을 반환
priorityQueueLowest.peek();

// 첫번째 값을 반환만 하고 제거 하지는 않는다.
// 큐가 비어있다면 예외 발생
priorityQueueLowest.element();

// 초기화
priorityQueueLowest.clear();
```

### Comparator

: 객체를 정렬하는데 필요한 메소드를 정의한 인터페이스.

→ 인터페이스이므로 인터페이스 내에 선언된 메소드를 무조건 구현해야한다.(compare)

파라미터로 들어온 두 객체를 비교

```java
Comparator<T> c = new Comparator<T>() {
    @Override
    public int compare(T o1, T o2) {
        return 0;
    }
};
```

### compare()

2개의 파라미터를 비교하여, 결과를 int형으로 반환

```java
Comparator<T> c = new Comparator<T>() {
    @Override
    
    public int compare(T o1, T o2) {
    	if( o1 > o2){
        	return 1; 
        } else if ( o1 < o2){
        	return -1;
        }else {
		return 0;        
        }   
    }
    
};
```
## DFS(깊이 우선 탐색 기법)

그래프 완전 탐색 기법 중 하나

그래프의 시작 노드에서 출발하여 탐색할 한 쪽 분기를 정하여 최대 깊이까지 탐색을 마친 후 다른 쪽 분기로 이동하여 다시 탐색을 수행하는 알고리즘

특징 : **재귀 함수로 구현**, **스택 자료구조** 이용

시간 복잡도 : O(V+E) 노드 수 : V, 에지 수 : E

**인접 행렬**(Adjacency Matrix) : 2차원 배열로 그래프의 연결 관계를 표현하는 방식

**인접 리스트**(Adjacency List) : 리스트로 그래프의 연결 관계를 표현하는 방식

 - ‘연결 리스트’ 자료구조 이용

한번 방문한 노드를 다시 방문하면 안됨 → 노드 방문 여부를 체크할 배열 필요

1. 그래프 : 인접 리스트로 표현
2. 방문 배열 초기화 하기 
3. 시작 노드 스택에 삽입
4. pop을 수행하여 노드 꺼냄
5. 꺼낸 노드를 탐색 순서에 기입,
6. 인접 리스트의 인접 노드를 스택에 삽입
7. 방문 배열 체크

```java
//ArrayList선언
ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n];

//방문배열 선언
Boolean[] visited = new Boolean[];
```

방향이 없는 그래프 → **양쪽 방향**으로 **에지를 모두 저장**
