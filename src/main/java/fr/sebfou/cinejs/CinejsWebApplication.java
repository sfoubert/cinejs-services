package fr.sebfou.cinejs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan({"fr.sebfou.cinejs"})
public class CinejsWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinejsWebApplication.class, args);
	}

}
