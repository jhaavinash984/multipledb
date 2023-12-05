package com.cisco.renewalsatrload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableEncryptableProperties
public class RenewalsAtrLoadApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RenewalsAtrLoadApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(RenewalsAtrLoadApplication.class, args);
	}

}
