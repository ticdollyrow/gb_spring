package ru.spring.spring_lesson3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@Import(AppConfig.class)
@ComponentScan("ru.spring.spring_lesson3")
public class SpringLesson3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringLesson3Application.class, args);
	}

}
