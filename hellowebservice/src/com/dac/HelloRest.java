package com.dac;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class HelloRest {

	@GET
	public String hello() {
		System.out.println("...");
		return "HELLO WORLD";
	}
	
	
	@GET
	@Path("student")
	@Produces(MediaType.APPLICATION_JSON)
	public Student hello1() {
		Student s1 = new Student("JAVA", "VERSION-8","java@java.com");
		return s1;
	}
	
}
