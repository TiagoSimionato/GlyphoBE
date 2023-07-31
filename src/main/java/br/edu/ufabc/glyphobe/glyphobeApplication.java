package br.edu.ufabc.glyphobe;

import java.net.InetAddress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class glyphobeApplication {

	public static void main(String[] args) {
		SpringApplication.run(glyphobeApplication.class, args);
		try {
			System.out.println(InetAddress.getLocalHost().getHostAddress());
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
