# 3주차

- 주제: 자료구조

## 공부 정리
- [수연](../../풀이/수연/3주차/풀이.md)
- [승현](../../풀이/승현/3주차/study.md)

## 007 주몽의 명령

### 문제 링크
- 백준) https://www.acmicpc.net/problem/1940 (주몽 - 실버4)
- 책) 'Do it! 알고리즘 코딩테스트 - 자바편' 59p 

### 문제
주몽은 철기군을 양성하기 위한 프로젝트에 나섰다. 그래서 야철대장을 통해 철기군이 입을 갑옷을 만들게 하였다.  
야철대장은 주몽의 명에 따르기 위하여 연구에 착수하던 중 아래와 같은 사실을 발견하게 되었다.  
갑옷을 만드는 재료들은 각각 고유한 번호를 가지고 있다. 
갑옷은 두 개의 재료로 만드는데 두 재료의 고유한 번호를 합쳐서 M(1 ≤ M ≤ 10,000,000)이 되면 갑옷이 만들어 지게 된다.   
야철대장은 자신이 만들고 있는 재료를 가지고 갑옷을 몇 개나 만들 수 있는지 궁금해졌다.  
이러한 궁금증을 풀어 주기 위하여 N(1 ≤ N ≤ 15,000) 개의 재료와 M이 주어졌을 때 몇 개의 갑옷을 만들 수 있는지를 구하는 프로그램을 작성하시오.  


### 풀이
  - [보영](./README.md)
  - [수연](../../풀이/수연/3주차/Ex07.java)
  - [승현](../../풀이/승현/3주차/Ex07.java)
  - [인호](../../풀이/인호/3주차/P007.java)
  - [현화](../../풀이/현화/3주차/Main007.java)



## 009 DNA 비밀번호

### 문제 링크
- 백준) https://www.acmicpc.net/problem/12891 (DNA 비밀번호 - 실버2)
- 책) 'Do it! 알고리즘 코딩테스트 - 자바편' 67p

### 문제
평소에 문자열을 가지고 노는 것을 좋아하는 민호는 DNA 문자열을 알게 되었다. DNA 문자열은 모든 문자열에 등장하는 문자가 {‘A’, ‘C’, ‘G’, ‘T’} 인 문자열을 말한다.   
예를 들어 “ACKA”는 DNA 문자열이 아니지만 “ACCA”는 DNA 문자열이다. 이런 신비한 문자열에 완전히 매료된 민호는 임의의 DNA 문자열을 만들고 만들어진 DNA 문자열의 부분문자열을 비밀번호로 사용하기로 마음먹었다.  
하지만 민호는 이러한 방법에는 큰 문제가 있다는 것을 발견했다. 임의의 DNA 문자열의 부분문자열을 뽑았을 때 “AAAA”와 같이 보안에 취약한 비밀번호가 만들어 질 수 있기 때문이다.  
그래서 민호는 부분문자열에서 등장하는 문자의 개수가 특정 개수 이상이여야 비밀번호로 사용할 수 있다는 규칙을 만들었다.  
  
임의의 DNA문자열이 “AAACCTGCCAA” 이고 민호가 뽑을 부분문자열의 길이를 4라고 하자. 그리고 부분문자열에 ‘A’ 는 1개 이상, ‘C’는 1개 이상, ‘G’는 1개 이상, ‘T’는 0개 이상이 등장해야 비밀번호로 사용할 수 있다고 하자.  
이때 “ACCT” 는 ‘G’ 가 1 개 이상 등장해야 한다는 조건을 만족하지 못해 비밀번호로 사용하지 못한다. 하지만 “GCCA” 은 모든 조건을 만족하기 때문에 비밀번호로 사용할 수 있다. 
  
민호가 만든 임의의 DNA 문자열과 비밀번호로 사용할 부분분자열의 길이, 그리고 {‘A’, ‘C’, ‘G’, ‘T’} 가 각각 몇번 이상 등장해야 비밀번호로 사용할 수 있는지 순서대로 주어졌을 때 민호가 만들 수 있는 비밀번호의 종류의 수를 구하는 프로그램을 작성하자.  
단 부분문자열이 등장하는 위치가 다르다면 부분문자열이 같다고 하더라도 다른 문자열로 취급한다.
  
### 풀이
  - [보영](./README.md)
  - [수연](../../풀이/수연/3주차/Ex09.java)
  - [승현](./README.md)
  - [인호](../../풀이/인호/3주차/P009.java)
  - [현화](../../풀이/현화/3주차/Main009.java)






## 011 스택으로 오름차순 수열 만들기

### 문제 링크
- 백준) https://www.acmicpc.net/problem/1874 (스택 수열 - 실버3)
- 책) 'Do it! 알고리즘 코딩테스트 - 자바편' 83p
- 
### 문제
스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다. 
스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.  
  
1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 
임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다.  
이를 계산하는 프로그램을 작성하라.
  
### 풀이
  - [보영](../../풀이/보영/3주차/011.java )
  - [수연](../../풀이/수연/3주차/Ex11.java)
  - [승현](../../풀이/승현/3주차/Ex11-2.java)
  - [인호](../../풀이/인호/3주차/P011.java)
  - [현화](../../풀이/현화/3주차/Main011.java)
