package com.ksnx3684.boot3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableAspectJAutoProxy
//@EnableTransactionManagement
@SpringBootApplication
public class Boot3Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot3Application.class, args);
	}

}
