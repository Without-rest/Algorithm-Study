## DFS  
[DFS 정리](https://codingnojam.tistory.com/44)  

1. 재귀를 이용한 구현  


```
public class Study_DFS_Recursion {

	// 방문처리에 사용 할 배열선언
	static boolean[] vistied = new boolean[9];
	
	// 그림예시 그래프의 연결상태를 2차원 배열로 표현
	// 인덱스가 각각의 노드번호가 될 수 있게 0번인덱스는 아무것도 없는 상태라고 생각하시면됩니다.
	static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
	
	public static void main(String[] args) {
		dfs(1);
	}
	
	static void dfs(int nodeIndex) {
		// 방문 처리
		vistied[nodeIndex] = true;
		
		// 방문 노드 출력
		System.out.print(nodeIndex + " -> ");
		
		// 방문한 노드에 인접한 노드 찾기
		for (int node : graph[nodeIndex]) {
			// 인접한 노드가 방문한 적이 없다면 DFS 수행
			if(!vistied[node]) {
				dfs(node);
			}
		}
	}
}
```

2. Stack을 이용한 구현  
  
```
import java.util.Stack;

public class Study_DFS_stack {

	// 방문처리에 사용 할 배열선언
	static boolean[] vistied = new boolean[9];
	
	// 그림예시 그래프의 연결상태를 2차원 배열로 표현
	// 인덱스가 각각의 노드번호가 될 수 있게 0번인덱스는 아무것도 없는 상태라고 생각하시면됩니다.
	static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
	
	// DFS 사용 할 스택
	static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) {
		
		// 시작 노드를 스택에 넣어줍니다.
		stack.push(1);
		// 시작 노드 방문처리
		vistied[1] = true;
		
		// 스택이 비어있지 않으면 계속 반복
		while(!stack.isEmpty()) {
			
			// 스택에서 하나를 꺼냅니다.
			int nodeIndex = stack.pop();
			
			// 방문 노드 출력
			System.out.print(nodeIndex + " -> ");
			
			// 꺼낸 노드와 인접한 노드 찾기
			for (int LinkedNode : graph[nodeIndex]) {
				// 인접한 노드를 방문하지 않았을 경우에 스택에 넣고 방문처리 
				if(!vistied[LinkedNode]) {
					stack.push(LinkedNode);
					vistied[LinkedNode] = true;
				}
			}
		}
	}
}
```

---

  

  
## 풀이
### 001 게임 맵 최단거리


  

    
<br>  

### 002 ABCDE  
```
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] connect;
    static boolean isVisited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        connect = new int[n][n];
        isVisited = new boolean[n];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int sPoint = Integer.parseInt(st.nextToken());
            int ePoint = Integer.parseInt(st.nextToken());

            connect[sPoint][ePoint] = 1;
            connect[ePoint][sPoint] = 1;
        }

        for(int j=0;j<n;j++){
            dfs(j, 0);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(0));
        bw.flush();
        bw.close();

    }

    static void dfs(int idx, int depth) throws IOException {
        if(depth == 4){
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(Integer.toString(1));
            bw.flush();
            bw.close();
            System.exit(0);
        }

        isVisited[idx] = true;

        for(int i=0;i<connect[idx].length;i++){
            if(connect[idx][i]==1&&!isVisited[i]){
                isVisited[i] = true;
                dfs(i, depth+1);
                isVisited[i] = false;
            }
        }
        isVisited[idx] = false;
    }
}
```
=> 시간 초과  
=> 어떻게 해결하지 ?  

<br>  

### 003 바이러스  
node 1 컴퓨터가 감염됐을 때 감염되는 컴퓨터 수 구하기  
=> birusCnt 전역변수로 선언 후, dfs 메소드 돌때마다 +1  
