import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest6 {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		System.out.println(numbers);
		numbers.removeIf(n -> (n%3) == 0); // numbers의 데이터들을 n에 대입해 조건검사(람다식)
		System.out.println(numbers);
	}

}
