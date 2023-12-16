package com.nwaHospitalApi.nwaHospitalApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.nwaHospitalApi.nwaHospitalApi.Entities")
public class NwaHospitalApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NwaHospitalApiApplication.class, args);
	}
}
