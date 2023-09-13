import java.util.ArrayList;
import java.util.List;

public class ArrayListTest4 {
	static void print(List<Integer> list) {
		for(Integer n: list) {
			System.out.print(n+",");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>(10);
		list1.add(5);
		list1.add(4);
		list1.add(2);
		list1.add(0);
		list1.add(1);
		list1.add(3);
		
		List<Integer> list2 = list1.subList(1, 4);
		print(list1);
		print(list2);
		System.out.println(list1.containsAll(list2));
		System.out.println("retainAll------------------------------");
		
		list1.retainAll(list2);
		print(list1);
		System.out.println("add----------------------------");
		list1.add(0,6); // insert index 0 번째 6 추가
		print(list1);
		System.out.println("set------------------------------");
		list1.set(0, 7); // 0번째 데이터를 7로 변경
		print(list1);
		System.out.println("remove------------------------------");
		list1.add(7);
		list1.add(7);
		list1.add(7);
		list1.add(10);
		list1.add(11);
//		list1.remove(new Integer(7)); // 앞에 7이 삭제됨
		list1.remove(7); // index 7이 삭제됨
		print(list1);
	}

}
