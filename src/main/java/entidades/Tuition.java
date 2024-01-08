package entidades;

import jakarta.persistence.*;

@Entity
@Table(name="tuition")
public class Tuition {
	
	//Atributos
	private int id;
	private Double fee;
	private Student student;
	
	//Constructores
	public Tuition() {
		
	}
	
	public Tuition(int id, Double fee, Student student) {
		this.id = id;
		this.fee = fee;
		this.student = student;
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
	
	@Column(name="fee")
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="student_id", referencedColumnName="id")
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}
