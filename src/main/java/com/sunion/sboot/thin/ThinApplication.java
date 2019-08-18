package com.sunion.sboot.thin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.sunion.sboot.thin.dao")
@ComponentScan(basePackages ={ "com.sunion.sboot.thin"})
public class ThinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThinApplication.class, args);
	}

}
