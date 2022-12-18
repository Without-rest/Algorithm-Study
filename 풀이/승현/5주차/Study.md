## 친구 관계 파악하기 👩🏼‍🤝‍👩🏻

**1) 문제 파악**

A-B ,B-C , C-D, D-E : 일직선으로 연결된 노드가 5개

→ A-B-C-D-E 일직선 상이 아님(모든 노드가 일직선에 있는 것이 아니다.)

**2)방문 배열 설정**

0 → 1번 → 2번 노드까지 완료

visited[0] = visited[1] = visited[2] = true이다.

→ 더 갈 곳이 없으면 방문 배열 모두 false로 변환

**3) Depth 5인이유**

5개의 이어진 노드를 찾아야함

0~N-1번에서 시작하는 DFS 탐색을 각각한다. 

depth가 5가 될 때 답을 저장 & 출력

설명 블로그 참조 → [https://minhamina.tistory.com/50](https://minhamina.tistory.com/50)
