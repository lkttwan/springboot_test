package org.gnrsoft.springboot_test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  
@EnableAutoConfiguration  
public class Example {
	
	@Value("${gnr.name}")
	private String gnrName;
	
    @RequestMapping("/")  
    String home() {  
        return gnrName;  
    }  
      
    @RequestMapping("/hello/{myName}")  
    String index(@PathVariable String myName) {  
        return "Hello "+myName+"!!!";  
    }  

}
