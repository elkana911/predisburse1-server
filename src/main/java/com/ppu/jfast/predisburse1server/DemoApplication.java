package com.ppu.jfast.predisburse1server;

import com.ppu.jfast.predisburse1server.config.FileStorageProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageProperties.class
})
@EntityScan(basePackages={"com.ppu.jfast.predisburse1server.domain"})
@EnableJpaRepositories(basePackages={"com.ppu.jfast.predisburse1server.repo"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
