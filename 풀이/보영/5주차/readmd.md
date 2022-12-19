
## 01 게임 맵 최단거리
- 완전탐색 문제 (DFS/BFS)
- 이 문제는 DFS 공부를 위해 풀었지만 BFS로 푸는게 효울적이다
- DFS => 시간 소요
- BFS => 얇게 빠르게 가능 

### 참고할만한 문제와 개념
https://continuous-development.tistory.com/176

### 코드 01
```java
import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int[][] move ={{0,1},{0,-1},{1,0},{-1,0}};
        Queue<Position> que =new LinkedList();
        int[][] count =new int[maps.length][maps[0].length];
        
        que.add(new Position(0,0));
        count[0][0]=1;
        
        while(!que.isEmpty()){
            Position cur =que.poll();
            int curcount = count[cur.y][cur.x];
            for(int i=0;i<4;i++){
            Position p = new Position(cur.x+move[i][0],cur.y+move[i][1]);
            //맵밖으로 나갈때
            if(p.x<0||p.y<0||p.x==maps[0].length||p.y==maps.length){
                continue;
            }
            //벽에 부딪힐때
            if(maps[p.y][p.x]==0){
                continue;
            }
            count[p.y][p.x]=curcount+1;
            //이미 지난길은 벽으로 만들어버리기
            maps[p.y][p.x]=0;
            que.add(p);
            }
        }
        answer=count[maps.length-1][maps[0].length-1];
        if(answer==0){
            return -1;
        }
        return answer;
    }
}
 
class Position {
    int x,y;
    
    public Position(int x, int y){
        this.x=x;
        this.y=y;
    }
}
```
- 벽 부딪히거나 범위 넘어가는 경우는 제외한다
- 지나갈 때마다 count 셈
- 탐색 완료후에도 목적지 못찾으면 return -1

###  🐞 프로그래머스에 올라온 잘 짠것 같다고 나혼자 느낀 누군가의 코드 
```java
import java.util.LinkedList;
class Solution
{
    final int[][] movement = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int solution(int[][] maps) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        LinkedList<Integer> route = new LinkedList<Integer>();
        int mrow = maps.length, mcol = maps[0].length;
        boolean[][] visited = new boolean[mrow][mcol];
        queue.add(0);
        route.add(1);
        visited[0][0] = true;
        while(!queue.isEmpty())
        {
            int code = queue.remove(), nowRoute = route.remove();
            int row = code / mcol, col = code % mcol;
            for(int i=0; i<movement.length; ++i)
            {
                int nrow = row + movement[i][0], ncol = col + movement[i][1];
                if(nrow == mrow-1 && ncol == mcol-1)
                    return ++nowRoute;
                if(nrow >= 0 && nrow < mrow && ncol >= 0 && ncol < mcol && maps[nrow][ncol] == 1 && !visited[nrow][ncol])
                {
                    queue.add(nrow * mcol + ncol);
                    route.add(nowRoute+1);
                    visited[nrow][ncol] = true;
                }
            }
        }
        return -1;
    }
}
```

