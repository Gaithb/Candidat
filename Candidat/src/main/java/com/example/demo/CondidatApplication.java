package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import com.example.demo.Repositories.CandidatRepository;
import com.example.demo.entites.Condidat;
@EnableEurekaServer
@SpringBootApplication
public class CondidatApplication {

	public static void main(String[] args) {
		SpringApplication.run(CondidatApplication.class, args);
	}
	@Autowired
	private CandidatRepository repository ;
	@Bean
	ApplicationRunner init(){
		return (args -> {
			repository.save(new Condidat("candidat1" , "CH" , "c1@esprit.tn"));
			repository.save(new Condidat("candidat2" , "CH2" , "c2@esprit.tn"));
			repository.save(new Condidat("candidat3" , "CH3" , "c3@esprit.tn"));
			repository.findAll().forEach(System.out::println);
		}) ;
	}
}
