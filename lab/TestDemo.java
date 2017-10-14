class Base {

	public Base() {

		System.out.print("C");

	}

}

class Base2 extends Base {

	public Base2() {

		System.out.print("B");

	}

}

public class TestDemo extends Base2 {

	int m = 1;

	public TestDemo() {

		System.out.println("A");

	}

	public static void main(String args[]) {

		TestDemo t = new TestDemo();

	}

}