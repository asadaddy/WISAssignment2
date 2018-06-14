package abbas.asad.wis.hw2.Assignment2;

import java.util.Date;

public class Student {

	private long intID;
	private String strName;
	private String strSubject;
	
	public Student()
	{}
	
	public Student(String name, String subject){
		this.intID = (new Date()).getTime();
		this.strName = name;
		this.strSubject = subject;
	}
	
	public Long getID(){
		return intID;
	}
	
	public String getName() {
		return strName;
	}
	
	public void setName(String name) {
		this.strName = name;
	}
	
	public String getSubject() {
		return strSubject;
	}
	
	public void setSubject(String subject) {
		this.strSubject = subject;
	}
	
	@Override
	public String toString() {
	return "Student{" +
	"ID = " + intID +
	", Name = '" + strName + '\'' +
	", Subject = '" + strSubject + '\'' +
	'}';
	}
}
