package ejercicios;

import jakarta.persistence.*;
import entidades.*;

public class Ud04TareaEvaluativaB2 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ud04");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
			System.out.println("Borrando una Universidad sin borrar sus estudiantes");
			
			int university_id = 4;
			
			University tempUniversity = entityManager.getReference(University.class, university_id);
			
			//comenzamos la traccación
			entityManager.getTransaction().begin();
			
			//borramos la universidad pero no el estudiante
			entityManager.remove(tempUniversity);
			
			//hacemos commit
			entityManager.getTransaction().commit();
			
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

}
