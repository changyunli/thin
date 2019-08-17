package com.sunion.sboot.thin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.sunion.sboot.thin.dao")
public class ThinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThinApplication.class, args);
	}

}
