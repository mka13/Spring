package com.sda.javapoz11.hellospring.hellospring;

import com.sda.javapoz11.hellospring.hellospring.Service.BigNumbersGenerator;
import com.sda.javapoz11.hellospring.hellospring.Service.RandomGenerator;
import com.sda.javapoz11.hellospring.hellospring.Service.SmallNumberGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class HellospringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellospringApplication.class, args);
	}

 // adnotacja mówiąca o wyższości tego beana nad pozostałymi potencjalnie dostępnymi
@Bean // annotacja na METODZIE mówiąca springowi że ma tą metodę wywołać i jej wynik zapisać w kontekście
public RandomGenerator smallNumbersGenerator()
{
	return  new SmallNumberGenerator();
}
@Profile("!Prod")
@Primary
@Bean
	public RandomGenerator bigNumbersGenerator()
	{
		return  new BigNumbersGenerator();
	}

	@Profile("prod")
	@Primary
	@Bean
	public RandomGenerator myBigNumbersGenerator (){
		return new BigNumbersGenerator();
	}

}
