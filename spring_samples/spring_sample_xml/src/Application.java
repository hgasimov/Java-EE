import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.service.CustomerService;
import com.example.service.CustomerServiceImplem;


public class Application {
	public static void main(String[] args) {
		//CustomerService cservice = new CustomerServiceImplem();
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//CustomerService cservice = appContext.getBean("customerService", CustomerService.class);
		CustomerService cservice = appContext.getBean("customerService2", CustomerService.class);
		
		System.out.println("Checking scope ...");
		System.out.println(cservice);
		CustomerService cservice2 = appContext.getBean("customerService2", CustomerService.class);
		System.out.println(cservice2);
		System.out.println("--------------------");
		
		
		System.out.println(cservice.findAll().get(0).getFirstname());
	}
}
