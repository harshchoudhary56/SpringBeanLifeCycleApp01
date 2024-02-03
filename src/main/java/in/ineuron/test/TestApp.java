package in.ineuron.test;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.Voter;

public class TestApp {
	public static void main(String[] args) throws IOException {
		
		System.out.println("***********CONTAINER STARTED************");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
		System.out.println("Bean id information :: " + Arrays.toString(context.getBeanDefinitionNames()));
		
		System.in.read();
		
		Voter voter = context.getBean(Voter.class);
		System.out.println(voter);
		System.out.println(voter.checkEligibility());
		
		context.close();
		System.out.println("***********CONTAINER STOPPED************");
		
	}

}
