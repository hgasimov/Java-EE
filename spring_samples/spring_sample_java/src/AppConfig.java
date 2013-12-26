import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.example.repository.CustomerRepository;
import com.example.repository.HibernateCustomerRepositoryImplem;
import com.example.service.CustomerService;
import com.example.service.CustomerServiceImplem;

@Configuration
@ComponentScan({"com.example"})
@PropertySource("app.properties") // com/example/model/app.properties
public class AppConfig {
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean(name = "customerService")
	@Scope("prototype")
	public CustomerService getCustomerService() {
		CustomerServiceImplem custservice = new CustomerServiceImplem();
		//CustomerServiceImplem custservice = new CustomerServiceImplem(getCustomerRepository());
		//custservice.setCustRepos(getCustomerRepository());
		
		return custservice;
	}
	
/*	@Bean(name = "customerRepository")
	public CustomerRepository getCustomerRepository() {
		return new HibernateCustomerRepositoryImplem();
	}
*/
}
