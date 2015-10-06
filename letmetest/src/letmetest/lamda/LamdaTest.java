package letmetest.lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

public class LamdaTest {
	
	public static void main(String[] args) {
		lamdaTest();
		lamdaObjectTest();
		//lamdaThread();
		
		mapreduce();
	}
	
	public static void mapreduce() {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
		 list.stream().map(x -> x*x).forEach(a->System.out.println(a));;
		int sum = list.stream().map(x -> x*x).reduce((x,y) -> x + y).get();
		System.out.println(sum);		
	}

	public static void lamdaThread() {
		Executors.newSingleThreadExecutor().execute(()-> {
			System.out.println("HELLO");
		});
	}

	public static void lamdaTest() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		
		list.forEach(n -> System.out.println(n));
	}
	
	public static void lamdaObjectTest(){
		List<Person> list = new ArrayList<Person>();
		
		Person p = new Person(1, "DELHI");
		list.add(p);
		list.add(p);
		list.add(p);
		list.add(p);
		list.add(p);
		
		list.forEach(pref -> System.out.println(pref.getName()));
	}

}
