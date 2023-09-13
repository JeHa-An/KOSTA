import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
//		TreeSet<Integer> ts = new TreeSet<>();
//		ts.add(100);
//		ts.add(50);
//		ts.add(10);
//		ts.add(150);
//		
//		System.out.println(ts);
//		
//		TreeSet<Person> tsp = new TreeSet<>(new Comparator<Person>() {
//		@Override
//		public int compare(Person o1, Person o2) {
//			return o1.age - o2.age;
//		}
//		});
//		tsp.add(new Person("hong",20));
//		tsp.add(new Person("aong",60));
//		tsp.add(new Person("kong",20));
//		tsp.add(new Person("zong",70));
//		tsp.add(new Person("song",10));
//		tsp.add(new Person("gong",50));
//		tsp.add(new Person("tong",30));
//		tsp.add(new Person("pong",40));
//		System.out.println(tsp);
//		SortedSet<Person> subList = tsp.subSet(new Person("", 20), new Person("", 60)); // 마지막 미포함
//		System.out.println(subList);
		
		TreeSet<Integer> tsts = new TreeSet<>(new Comparator<Integer>(){
			@Override
			public int compare(Integer n1, Integer n2) {
				return n1-n2;
			}
		});
		tsts.add(10);
		tsts.add(20);
		tsts.add(30);
		tsts.add(40);
		System.out.println(tsts);
	}
}
