package letmetest;

import java.util.Vector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import letme.HelloManager;

public class Hello {
	private static final Logger log = LogManager.getLogger(Hello.class);
	
	
	public static void main(String[] args) {
		log.debug("Hello World DEBUG!!");
		log.info("Hello World INFO!!");
		log.error("Hello World ERROR!!");
		
		
		Vector<String> v1 = new Vector<String>();
		v1.add("a1");
		v1.add("a2");
		v1.add("a3");
		v1.add("a4");
		
		System.out.println("SIZE :: " + v1.size());
		
		for(int i=0; i<v1.size(); i++) {
			System.out.println(v1.get(i));
			v1.remove(v1.get(i));
		}
		
		System.out.println("SIZE :: " + v1.size());
		
		HelloManager.didUTest();
	}

}
