# 이진 탐색(Binary Search)  

1. 정렬된 배열 안에서 특정 원소를 찾을 때 인덱스 i부터 j의 중간값을 비교
2. 중간값이 찾는 원소가 아니라면 인덱스 i와 j를 조정
3. 인덱스 i와 j를 조정할 때마다 탐색 범위가 반으로 줄어든다.


### 구현 방법
1. 처음 범위는 인덱스 0부터 끝까지, 이 때 중간 인덱스 값을 mid라 한다.  
2. mid의 값과 찾는 원소를 비교한다.  
  2-1. 찾는 원소와 mid의 값이 같다면 탐색 종료.  
  2-2. mid의 값 < 찾는 원소이면, left는 mid+1로 하여 2를 반복한다.  
  2-3. mid의 값 > 찾는 원소이면, right는 mid-1로 하여 2를 반복한다.  
3. 만약 right>left가 된다면 해당 배열에는 찾는 원소가 없다.  
  
  
  
##### 반복문으로 구현

```
public static boolean BSearch(int[] arr, int n) {
		int left = 0;
		int right = arr.length - 1;
		int mid;

		while (left <= right) {
			mid = (left + right) / 2;
			if (arr[mid] < n) left = mid + 1;
			else if (arr[mid] > n) right = mid - 1;
			else return true;
		}
		return false;
	}

```


##### 재귀로 구현

```
public static boolean BSearchRecursive(int[] arr, int n, int left, int right) {
		if(left > right) return false;
		
		int mid = (left + right) / 2;
        
		if (arr[mid] < n) 
        	return BSearchRecursive(arr, n, mid +1, right);
		else if (arr[mid] > n) 
        	return BSearchRecursive(arr, n, left, mid - 1);
		else 
        	return true;
		
	}
```


### 시간복잡도   
- 순차적 탐색 : 최악의 경우 배열 끝까지 탐색해야한다. -> O(n)  
- 이진 탐색 : 범위를 새로 정할 때 마다 탐색 범위가 1/2로 줄어든다. -> O(log n)  





  
*** 

### 풀이  
##### 1920. 수 찾기  
1. 순차 탐색할 경우, 시간 복잡도 O(N)  
자연수 N(1<=N<=100,000)개의 배열에서 M(1<=M<=100,000)개의 수들이 모두 있는 지 탐색  
- 한개의 수를 N개의 배열에 있는 지 탐색하는 데 걸리는 시간 : O(N) = 100,000  
- 이 것을 M번 => 100,000 * 100,000 = 10,000,000,000(100억번)  
  
1억 -> 1초  
100억 -> 100초 ..   
시간 제한  
  
2. 이진 탐색 사용할 경우, 시간 복잡도 O(log N)  
M* O(log N) = 100,000 * log 10^5 = 500,000   
- 시간 제한 : 1초 -> 1억이내면 가능  
-> 이진 탐색 사용하자 !  
  

