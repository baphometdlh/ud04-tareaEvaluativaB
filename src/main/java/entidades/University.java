package entidades;

import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(name="university")
public class University {

	//Atributos
	private int id;
	private String name;
	private Address address;
	List<Student> students = new ArrayList<>();
	
	//constructores
	public University() {
		
	}
	
	public University(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	//ToString
	
	//getters y setters
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Embedded
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@OneToMany(mappedBy="university", cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
