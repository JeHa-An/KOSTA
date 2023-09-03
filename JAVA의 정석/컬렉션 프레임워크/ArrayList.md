# ArrayList
  &nbsp;List 인터페이스의 특징(순서유지, 중복허용)을 가지며, 기존 Vector의 구현원리와 기능적인 측면에서 동일하다고 할 수 있다. Vector는 기존에 작성된 소스와의 호환성을 위해 있을 뿐 가능하면 ArrayList 사용. <br>
  &nbsp;Object 배열을 이용해 데이터를 순차적으로 저장되며, 더 이상 저장할 공간이 부족하면 보다 큰 새로운 배열을 생성해 복사한 다음 저장한다. (Object[]을 멤버변수로 선언해 모든 종류의 객체를 담을 수 있다.)

  - List 인터페이스의 특징(순서유지, 중복허용)을 가진다.
  - 기존 Vector의 구현원리와 기능적인 측면에서 동일하다고 할 수 있다. (ArrayList 사용)
  - 


## 메서드 `Collection은 인터페이스이고, Collections는 클래스이다`
`선언 전 import java.util.ArrayList `
- ArrayList()
```java
  ArrayList list1 = new ArrayList(10); // 크기가 10인 ArrayList 생성 
```

- Boolean add(Object o), void add(int index, Object element)
```java
  list1.add(new Integer(1)); // ArrayList의 마지막에 객체를 추가(성공하면 true)
  list1.add(new Integer(3));
  list1.add(new Integer(0));
  list1.add(3, new Integer(2)); // 지정위치(index)에 객체를 저장
```
- Object remove(int index), Booleam remove(Object o) 객체를 제거
```java
  list1.remove(1); // [1,0,2] // index 1의 객체 3을 삭제
  list1.remove(new Integer(0)); // [1,2] 객체 0을 삭제 후, true or false로 반환
```

- Object get(int index) 지정된 위치(index)에 저장된 객체를 반환한다.
```java
  list1.get(1); // 3
```
- int size() ArrayList에 저장된 객체의 개수를 반환한다.
```java
  list1.size(); // 4
```
- List subList(int fromIndex, int toIndex) from 부터 to 사이에 저장된 객체를 반환
```java
  // list1 : [1,3,0,2]
  ArrayList list2 = new ArrayList(list1.subList(0, 2)); // [1,3]
```

- void sort(Comparator c) 지정된 비교자(comparator)로 ArrayList를 정렬
```java
Collections.sort(list1);
  // list1 : [0,1,2,3]
  // list2 : [1,3]
```

- boolean contains(Object o) 지정된 객체(o)가 ArrayList에 포함되어 있는지 확인
```java
  list1.contains(list2); // false
  list1.contains(new Integer(2)); // true
  list1.containsAll(list2) // true, containsAll 사용해 list1이 list2의 모든 요소를 포함하고 있을때 true
```

- boolean retainAll(Collection c) ArrayList에 저장된 객체 중 주어진 컬렉션과 공통된 것들만 남기고 나머지는 삭제
```java
// list1 : [0,1,2,3] , list2 : [3,0]
list1.retainAll(list2) // list1 : [0,3], list2 : [3,0] 
```
## ArrayList의 추가와 삭제
&nbsp;**ArrrayList의 객체를 삭제하는 경우**, 삭제할 객체의 바로 아래에 있는 데이터를 한 칸씩 위로 복사해 삭제할 객체를 덮어쓰는 방식으로 처리한다. 마지막 데이터를 삭제할 경우 복사할 필요 없이 단순히 null로 변경한다.<br>
&nbsp;배열의 중간 위치한 객체를 추가하거나 삭제하는 경우 다른 데이터의 위치를 이동시켜 줘야 하기 때문에 다루는 데이터의 개수가 많을수록 작업시간이 오래 걸린다.

- 크기를 변경하는 경우 새로운 배열을 생성하고 복사한다.
- 데이터를 추가 또는 삭제를 위해 시간이 많이 걸린다. 마지막에 데이터를 추가하거나 삭제하는 것은 빠르다.