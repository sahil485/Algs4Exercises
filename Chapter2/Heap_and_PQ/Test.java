package Heap_and_PQ;

public class Test {

	public static void main(String[] args) 
	{
		Heap test = new Heap();
		test.insert("A");
		test.insert("X");
		test.insert("B");
		test.insert("F");
		test.insert("H");
		test.insert("Z");
		test.insert("a");
		test.insert("Z");
		test.insert("W");
		test.insert("C");
		test.insert("E");
		test.insert("D");
		System.out.println(test.getSize());
		test.sort();
	}

}
