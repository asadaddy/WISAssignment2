package abbas.asad.wis.hw2.Assignment2;

import java.util.HashMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//DISPLAY
@RestController
@RequestMapping(value="/rest/student")
public class StudentService {
	@RequestMapping(value="/", method = RequestMethod.GET)
	public HashMap<Long,Student> getAllStudents() {
		return Assignment2Application.hmStudent;
}
	
//DISPLAY BY ID	
@RequestMapping(value="/{id}",method = RequestMethod.GET)
public Student getStudent(@PathVariable long id){
	return Assignment2Application.hmStudent.get(new Long(id));
}
	
//INSERT	
@RequestMapping(value="/add",method = RequestMethod.POST)
public Student addStudent(@RequestParam(value="name") String name
	,@RequestParam(value="subject",defaultValue = "unknown") String subject){

	System.out.println("we are here...");
	Student student=new Student(name,subject);
	Assignment2Application.hmStudent.put(new Long(student.getID()), student);
	return student;
}

//UPDATE
@RequestMapping(value="/update",method = RequestMethod.PUT)
public Student updateStudent(@RequestBody Student student) throws Exception {
	if(Assignment2Application.hmStudent.containsKey(new Long(student.getID()))){
		Assignment2Application.hmStudent.put(new Long(student.getID()),student);
	}else{
		throw new Exception("Student "+student.getID()+" does not exists");
	}
return student;
}


//DELETE
@RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
public Student deleteStudent(@PathVariable long id) throws Exception {
	Student student;
	if(Assignment2Application.hmStudent.containsKey(new Long(id))){
		student= Assignment2Application.hmStudent.get(new Long(id));
		Assignment2Application.hmStudent.remove(new Long(id));
	}else{
		throw new Exception("Student "+id+" does not exists");
	}
	return student;
	}
}
