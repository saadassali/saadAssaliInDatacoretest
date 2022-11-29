package com.indatacore.indatacoretest;

import com.indatacore.indatacoretest.service.MyService;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.StandardEnvironment;

import java.io.FileReader;

@SpringBootApplication
public class IndatacoretestApplication {


	@Autowired
	MyService service;
	public static void main(String[] args) {



		SpringApplication.run(IndatacoretestApplication.class, args);
	}


	@Bean
	public CommandLineRunner command()
	{
		return args -> {
			service.saveCsvFileDataInDataBase();


		};
	}


}
