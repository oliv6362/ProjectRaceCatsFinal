package com.example.demo;

import DB.DBcontroller;
import DB.TEST;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;

@SpringBootApplication
public class DemoSpringBootEksempelApplication {

	public static void main(String[] args) {

		TESTING testdemo = new TESTING();
		testdemo.demotesting();

		//SpringApplication.run(DemoSpringBootEksempelApplication.class, args);
	}

}