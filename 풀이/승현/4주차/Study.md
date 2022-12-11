BufferWriter: 버퍼를 이용한 출력

```java
BufferWriter bw = new BufferWriter(new OutputStreamWriter(System.out);
bw.write();
```

출력하기 위해서는 **String형으로의 변환이 필요**

bw.flush() : 내부 버퍼의 내용을 파일에 writer 한다. flush()를 호출하지 않는다면 내용이 버퍼에만 남고 파일에는 쓰이지 않는 상황이 나올 수 있다.

bw.close() : 스트림을 이용하여 파일의 내용을 읽어드린다. close()를 호출하여 스트림을 닫으면 그 스트림을 다시 이용하여 파일에 쓰는것이 불가능하다. 스트림을 닫아 종료된 작업에 대한 메모리를 확보해야 한다.
