import com.example.service.CustomerService;
import com.example.service.CustomerServiceImplem;


public class Application {
	public static void main(String[] args) {
		CustomerService cservice = new CustomerServiceImplem();
		System.out.println(cservice.findAll().get(0).getFirstname());
	}
}
