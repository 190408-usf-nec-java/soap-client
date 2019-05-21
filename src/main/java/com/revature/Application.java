package com.revature;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.revature.clients.SuperHeroClient;
import com.revature.models.generated.GetHeroResponse;

@SpringBootApplication
public class Application {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * Runs when application launches
	 */
	@Bean
	CommandLineRunner lookup(SuperHeroClient client) {
		return args -> {
			String name = "professorX";
			System.err.println(name);

			// Will send request to SOAP server, getting response as GetHeroResponse
			GetHeroResponse response = client.getHero(name);
			System.err.println(response.getSuperHero().getSuperPower());
		};
	}
}
