import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<Integer> stack= new Stack(); // List 인터페이스 상속받음 List의 기능을 가지고 있음.
		stack.push(100);
		stack.push(200);
		stack.push(300);
		stack.push(400);
		stack.push(500);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		
	}

}
