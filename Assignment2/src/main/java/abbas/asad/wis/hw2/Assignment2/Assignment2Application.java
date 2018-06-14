package abbas.asad.wis.hw2.Assignment2;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Assignment2Application {


	public static HashMap<Long,Student> hmStudent;
	
	public static void main(String[] args) {
		

		hmStudent = new HashMap<Long,Student>();
		Student one = new Student("Asad Abbas","ITIS");
		hmStudent.put(new Long(one.getID()),one);				
		
		SpringApplication.run(Assignment2Application.class, args);
	}
}
