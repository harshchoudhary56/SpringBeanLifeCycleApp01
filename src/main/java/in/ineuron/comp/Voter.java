package in.ineuron.comp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component(value = "voter")
@PropertySource(value = "in/ineuron/common/application.properties")
public class Voter {
	

	@Value("${voter.info.name}") 
	private String name;
	
	@Value("${voter.info.age}")
	private float age;
	
	private Date dateOfVoting;
	
	static {
		System.out.println("Voter.class is loading...");
	}
	
	public Voter() {
		System.out.println("Voter object is instantiated...");
	}

	public Date getDateOfVoting() {
		return dateOfVoting;
	}

	public void setDateOfVoting(Date dateOfVoting) {
		this.dateOfVoting = dateOfVoting;
	}
	
	// Business logic
	
	@PostConstruct
	public void myInit() {
		System.out.println("Voter.myInit()");
		if (age < 0 || name == null) {
			throw new IllegalArgumentException("Invalid input...");
		}
	}
	
	public String checkEligibility() {
		if (age >= 18) {
			return "You are eligible for voting";
		} else {
			return "You are not eligible for voting";
		}
	}
	
	@PreDestroy
	public void myDestroy() {
		System.out.println("Voter.myDestroy()");
		name = null;
		age = 0.0f;
		dateOfVoting = null;
	}
	
	@Override
	public String toString() {
		return "Voter [name=" + name + ", age=" + age + ", dateOfVoting=" + dateOfVoting + "]";
	}
	
}
