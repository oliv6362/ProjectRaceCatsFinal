package UI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringBootEksempelApplication {

	public static void main(String[] args) {
		System.out.println("i start here");
		/*
		TESTING testdemo = new TESTING();
		testdemo.demotesting();

		UseCase u = new UseCase();
		DBcontroller dbc = new DBcontroller();
		dbc.addUser(
				u.buildUser("Frede", "cool", "laumail@gmail.com", "1234", 12345678));

		 */

		SpringApplication.run(DemoSpringBootEksempelApplication.class, args);
	}
}