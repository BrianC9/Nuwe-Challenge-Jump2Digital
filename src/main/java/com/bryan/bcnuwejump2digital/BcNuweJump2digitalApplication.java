package com.bryan.bcnuwejump2digital;

import com.bryan.bcnuwejump2digital.model.Company;
import com.bryan.bcnuwejump2digital.repository.CompanyRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class BcNuweJump2digitalApplication {

	public static void main(String[] args) {

		SpringApplication.run(BcNuweJump2digitalApplication.class, args);

	}

	@Bean
	CommandLineRunner commandLineRunner(CompanyRepository companyRepository){
		System.out.println("Inserting companies into de DB");
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Company>> typeReference = new TypeReference<List<Company>>() {};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/companies.json");
			try {
				List<Company> companies = mapper.readValue(inputStream,typeReference);
				companyRepository.saveAll(companies);
				System.out.println("Companies saved successfully!");
			}catch (IOException e){
				System.out.println("Unable to save companies: "+e.getMessage());
			}

		};
	}
}
