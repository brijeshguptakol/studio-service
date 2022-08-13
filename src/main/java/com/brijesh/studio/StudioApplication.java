package com.brijesh.studio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudioApplication {

	public static void main(String[] args) {
		try{
			SpringApplication.run(StudioApplication.class, args);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
