import java.util.ArrayList;

class Person implements Comparable<Person>{
	String name;
	int age;
	Person() {}
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "(" + name + "," + age + ")";
	}
	@Override
	public int compareTo(Person o) {
//		return age - o.age;
		return name.compareTo(o.name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Person)) return false;
		Person p = (Person)obj;
		return name.equals(p.name) && age == p.age;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}
}
public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add(100);
		int n = (Integer)al.get(0);
		
		ArrayList al2 = new ArrayList();
		al2.add(new Person());
		Person p = (Person)al2.get(0);
		
		ArrayList<Person> al3 = new ArrayList<>();
		al3.add(new Person());
		Person p2 = al3.get(0);
		System.out.println(p);
		}
}
