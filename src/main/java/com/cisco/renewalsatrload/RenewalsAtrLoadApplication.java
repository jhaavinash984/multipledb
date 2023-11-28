package com.cisco.renewalsatrload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class RenewalsAtrLoadApplication {

	public static void main(String[] args) {
		SpringApplication.run(RenewalsAtrLoadApplication.class, args);
	}

}
