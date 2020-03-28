package br.com.cleitonkiper.testek8;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {
	
	@RequestMapping("/health")
	public String index() {
		return "health";
	}
	
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World";
	}
}
