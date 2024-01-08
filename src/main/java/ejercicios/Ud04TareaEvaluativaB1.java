package ejercicios;

import java.time.LocalDate;

import entidades.*;
import jakarta.persistence.*;

public class Ud04TareaEvaluativaB1 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ud04");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
			//creamos un objeto Student y University
			System.out.println("Creando un nuevo objeto Student y una Univeristy");
			
			Student student = createStudent();
			University university = createUniversity();
			
			university.getStudents().add(student);
			student.setUniversity(university);
			
			//comenzamos la transaccion
			entityManager.getTransaction().begin();
			
			//guarda el objeto university
			System.out.println("Guardando la universidad y en cascada el estudiante...");
			entityManager.persist(university);
			
			//hacemos commit
			entityManager.getTransaction().commit();
			
			entityManager.getTransaction().begin();
			Student dbStudent = (Student)entityManager.getReference(Student.class, university.getStudents().get(0).getId());
			System.out.println(dbStudent.getUniversity().getName());
			
			
			System.out.println("Hecho!");
			
			
		}
		catch(Exception e) {
			//hacemos rollback
			System.out.println("Realizando Rollback");
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
		finally {
			entityManager.close();
			factory.close();
		}

	}
	
	private static Student createStudent() {
		Student tempStudent = new Student();
		Address tempAddress = new Address();
		
		tempStudent.setFirstName("Carlos");
		tempStudent.setLastName("Gomez");
		tempStudent.setEmail("cgomez@birt.eus");
		tempStudent.getPhones().add("943555666");
		tempStudent.getPhones().add("678543900");
		tempStudent.setBirthdate(LocalDate.parse("1986-01-30"));
		tempAddress.setAddressLine1("Calle gran via 12");
		tempAddress.setAddressLine2("1A");
		tempAddress.setCity("Eibar");
		tempAddress.setZipCode("20600");
		tempStudent.setAddress(tempAddress);
		
		return tempStudent;
		
	}
	
	private static University createUniversity() {
		University tempUniversity = new University();
		Address uniAddress = new Address();
		
		tempUniversity.setName("BIRT");
		uniAddress.setAddressLine1("calle gazteiz");
		uniAddress.setAddressLine2("23");
		uniAddress.setCity("Vitoria");
		uniAddress.setZipCode("30400");
		tempUniversity.setAddress(uniAddress);
		
		return tempUniversity;
		
	}

}
