package model.controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.beans.Curso;
import model.beans.Entidad;


public class CursoControlador extends SuperControlador{

	public static Curso obtenerPrimero() {
		return obtencionUnaSolaEntidad("select * from curso order by id limit 1");
	}
	
	public static Curso obtenerUltimo() {
		return obtencionUnaSolaEntidad("select * from curso order by id  desc limit 1");
	}
	
	public static Curso obtenerSiguiente(int idActual) {
		return obtencionUnaSolaEntidad("select * from curso where id >" + idActual +" order by id limit 1");
	}
	
	public static Curso obtenerAnterior(int idActual) {
		return obtencionUnaSolaEntidad("select * from curso where id <" + idActual +" order by id desc limit 1");
	}
	
	
	public static Curso guardarCurso(Curso cu) {
		if (cu.getId() == 0) {
			return (Curso) creacion(cu);
		}
		else {
			return (Curso) modificacionEntidad(cu);
		}
	}
	
	/**
	 * 
	 */
	private static Curso obtencionUnaSolaEntidad (String sql) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPACentroEducativo");

		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery(sql, Curso.class);
		
		Curso c = null;
		
		try {
			c = (Curso) q.getSingleResult();
		}
		catch (Exception e) {
			
		}
		
		em.close();
		return c;
	}
	
	public static List<Curso> listadoEntidadesSegundoMetodo () {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPACentroEducativo");
		
		EntityManager em = entityManagerFactory.createEntityManager();
		
		TypedQuery<Curso> q = em.createQuery("SELECT c FROM Curso c", Curso.class);
		
		List<Curso> cursos = (List<Curso>) q.getResultList();
		
		for (Curso curso : cursos) {
			System.out.println("Curso: " + curso.getId() + " Descripción: " + curso.getDescripcion());
		}
		
		em.close();
		
		return cursos;
	}
	
	

}
