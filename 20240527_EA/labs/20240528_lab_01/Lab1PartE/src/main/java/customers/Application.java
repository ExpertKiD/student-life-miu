package customers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");

		CustomerService customerService = context.getBean("customerService",
				CustomerService.class);

		customerService.addCustomer("Frank Brown", "fbrown@acme.com",
				"mainstreet 5", "Chicago", "60613");

		ProductService productService = context.getBean("productService", ProductService.class);

		productService.addProduct("fbrown@acme.com", "Hair Oil", 2.99);

	}
}

