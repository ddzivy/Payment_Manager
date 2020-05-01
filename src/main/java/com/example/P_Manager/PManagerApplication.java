package com.example.P_Manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.P_Manager.domain.Type;
import com.example.P_Manager.domain.TypeRepository;
import com.example.P_Manager.domain.Person;
import com.example.P_Manager.domain.PersonRepository;
import com.example.P_Manager.domain.Payment;
import com.example.P_Manager.domain.PaymentRepository;

@SpringBootApplication
public class PManagerApplication {
	private static final Logger log = LoggerFactory.getLogger(PManagerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PManagerApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner paymentDemo(PaymentRepository prepository, TypeRepository trepository, PersonRepository urepository) {
		return (args) -> {
			log.info("save a couple of payments");
			
			// Creating and saving new payment types
			trepository.save(new Type("Product"));
			trepository.save(new Type("Service"));
			trepository.save(new Type("Refund")); 
			
			// Creating and saving new payments
			prepository.save(new Payment("Table.oy", "PM0009874321", "245€", "2020-06-01", trepository.findByName("Product").get(0), "No"));
			prepository.save(new Payment("Peter Smith", "PM0005879454", "2500€", "2020-05-27", trepository.findByName("Service").get(0), "No"));
			prepository.save(new Payment("Mary West", "PM0045200148", "750€", "2020-05-10", trepository.findByName("Refund").get(0), "No"));	
			
			// Creating and saving new persons (user/password): secretary/secretary manager/manager boss/boss
			Person user1 = new Person("secretary", "$2a$10$CG7xagtTGnmbd85JWF1IZeLRAGnbUJ1M9TNX2SyRQkzjkrh1wI1RG", "secretary@pm.oy", "USER");
			Person user2 = new Person("manager", "$2a$10$5V7IGDsCaCx6tFzaz84wWu5StIlDdGyMYaW73MHt59M/3JFE6s1vG", "manager@pm.oy", "ADMIN");
			Person user3 = new Person("boss","$2a$10$IxIjuRzI/k6epKZ9cN6bIuFTAVG1IlyWg8OgvJlL/d3sUQaxEcPyy", "boss@pm.oy", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
			
			log.info("fetch all payments");
			for (Payment payment : prepository.findAll()) {
				log.info(payment.toString());
			}

		};
	}
}
