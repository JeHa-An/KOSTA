import java.util.Arrays;
import java.util.HashSet;

public class HashSetTest {

	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<>(); // 중복허용 X(set), 저장순서 X(Hash)
		hs.add(234);
		hs.add(14);
		hs.add(45);
		hs.add(8);
		hs.add(11);
		hs.add(45);
		for(Integer n : hs) {
			System.out.print(n + ",");
		}
		System.out.println();
		HashSet<Person> ahs = new HashSet<>();
		ahs.add(new Person("홍길동", 23));
		ahs.add(new Person("홍길동", 30));
		ahs.add(new Person("고길동", 33));
		ahs.add(new Person("하길동", 40));
		ahs.add(new Person("고길동", 33));

		for(Person p : ahs) {
			System.out.println(p);
		}
		
	}
	
}
