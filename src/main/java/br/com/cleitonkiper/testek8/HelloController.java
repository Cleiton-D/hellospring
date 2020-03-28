package br.com.cleitonkiper.testek8;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {
	
	
	@RequestMapping("/hello")
	public String index() {
		return "Hello World";
	}
}
