## BFS(너비 우선 탐색 기법)

: 시작노드를 기준으로 가까운 노드를 먼저 방문하면서 탐색하는 알고리즘

**특징**

: FIFO 이용. Queue 자료구조 이용

**시간복잡도**

O(V+E)

→ 목표 노드에 도착하는 경로가 여러 개 일때 최단 경로를 보장

<BFS 시작하는 방법>

1. 그래프를 인접리스트로 표현, 방문배열 선언(DFS와 같다)
2. 큐에서 노드를 꺼내면서 인접 노드를 큐에 삽입, 큐에서 꺼낸 노드는 탐색 순서에 기록(이미 방문한 노드는 큐에 삽입하지 않는다.)
3. 큐 자료구조에 값이 없을 때 까지 반복하기

```java
class Graph {
	private int V;
	private LinkedList<Integer> adj[]; //인접리스트

Graph(int v) {
 V = v;
adj = new LinkedList[v];
for(int i=0; i<v; ++i) {
//인접리스트 초기화
	adj[i] = new LinkedList();
}

//노드 연결
void addEdge(int v, int w) {
	adj[v].add(w);
}

//s를 시작 노드로 한 BFS로 탐색, 탐색한 노드들 출력
	boolean visited[] = new boolean[V];
	
	LinkedList<Integer> queue = new LinkedList<Integer>();
//현재 노드를 방문한 것으로 표시하고 큐에 정렬(enqueue)

visited[s] = true;
queue.add(s);

//큐가 empty때까지 반복
while(queue.size() != 0 ) {
 //방문한 노드를 큐에서 추출(dequeue)하고 값을 출력
s= queue.poll();
System.out.print(s+ " ");

//방문한 노드와 인접한 모든 노드를 가져온다.
Iterator<Integer> i = adj[s].listIterator();
while(i.hasNext()) {
	int n = i.next();

//방문하지 않은 노드면 방문한 것으로 표시하고 큐에 삽입(enqueue)

if(!visited[n]) {
	visisted[n] = true;
	queue.add(n);
	}
 }
}
}
}
```
