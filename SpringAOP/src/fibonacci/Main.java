package fibonacci;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		m.useSpring();
	}	
	
	void useSpring() {
		ConfigurableApplicationContext ap = 
				new ClassPathXmlApplicationContext("fibonacci/spring-context-aspects.xml");

//		Fibonacci fibonacci= ap.getBean("fib", Fibonacci.class);
//		System.out.println(fib.compute());
		Fibonacci fibonacci = new Fibonacci();
		System.out.println(fibonacci.compute());

		ap.close();
	}
}
