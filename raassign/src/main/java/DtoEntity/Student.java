package DtoEntity;

import jakarta.persistence.*;

@Entity
@Table(name="katpa")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment
	private int id;
	
	private String email;
	private String address;
	private String course;
	private int level;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String email, String address, String course, int level) {
		super();
		this.email = email;
		this.address = address;
		this.course = course;
		this.level = level;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", email=" + email + ", address=" + address + ", course=" + course + ", level="
				+ level + "]";
	}
	
}
