package com.world.beauty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.world.beauty.entity.Servico;
import com.world.beauty.repository.ServicoRepository;

@SpringBootApplication
public class BeautyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeautyApplication.class, args);
	}

	@Component
	class DemoCommandLineRunner implements CommandLineRunner {
		@Autowired
		private ServicoRepository sr;
//
		@Override
		public void run(String... arg) throws Exception {


		}

	}
}
