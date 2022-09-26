package com.example.ObLaptopexercise;

import com.example.ObLaptopexercise.entities.Laptop;
import com.example.ObLaptopexercise.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObLaptopExerciseApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObLaptopExerciseApplication.class, args);

		LaptopRepository repository = context.getBean(LaptopRepository.class);
		System.out.println( "The number of Laptop in the Database is: " + repository.count());

		Laptop laptop = new Laptop(null, "Apple", 16, 500, "Mac");
		Laptop laptop1 = new Laptop(null, "Dell", 18, 250, "Linux");

		repository.save(laptop);
		repository.save(laptop1);
		System.out.println("The number of Laptop in the Database is currently: " + repository.count());
	}

}
