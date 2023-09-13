# TreeSet
> 이진 탐색 트리(binary seaarch tree)라는 자료구조의 형태로 데이터를 저장하는 컬렉션 클래스.

## 이진 탐색 트리

## 메서드

### TreeSet()
```java
TreeSet<Integer> ts = new TreeSet<>();
```

### add()
```java
TreeSet<Integer> ts = new TreeSet<>();
ts.add(10);
ts.add(20);
System.out.println(ts) // [10,20]
```
### TreeSet(Comparator comp)
주어진 정렬조건으로 정렬하는 TreeSet을 생성
```java
TreeSet<Integer> tsc = new TreeSet<>(new Comparator<Integer>(){
@Override
public int compare(Integer n1, Integer n2){
  return n1 - n2;
});
```
