class Data<T> {
	T data;
	void setData(T data) {
		this.data = data;
	}
	T getDate() {
		return data;
	}
}
public class GenericTest {

	public static void main(String[] args) {
		Data<String> d = new Data<>();
		d.setData("Hong");
		String s = d.getDate();
		System.out.println(s);
		
		Data<Integer> d2 = new Data<>();
		d2.setData(200);
		int n = d2.getDate();
		System.out.println(n);
		
		Data<Person> d3 = new Data<>();
		d3.setData(new Person("james", 30));
		Person p = d3.getDate();
		System.out.println(p);
		
		// d2 = d; 다른 타입으로 생성된 제너릭 객체는 동일한 클래스가 아니다. (상속관계가 아니다)
		
		Data<Person> d4 = new Data<>();
		// d3 = d4; 같은 타입으로 생성된 제너릭 객체는 동일한 클래스다.
	}

}
