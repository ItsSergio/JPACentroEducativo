package model.controladores;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.beans.Materia;
import model.beans.Entidad;

public class MateriaControlador extends SuperControlador {

	public static Materia obtenerPrimero() {
		return obtencionUnaSolaEntidad("select * from materia order by id limit 1");
	}
	
	public static Materia obtenerUltimo() {
		return obtencionUnaSolaEntidad("select * from materia order by id  desc limit 1");
	}
	
	public static Materia obtenerSiguiente(int idActual) {
		return obtencionUnaSolaEntidad("select * from materia where id >" + idActual +" order by id limit 1");
	}
	
	public static Materia obtenerAnterior(int idActual) {
		return obtencionUnaSolaEntidad("select * from materia where id <" + idActual +" order by id desc limit 1");
	}
	
	
	public static Materia guardarMateria(Materia ma) {
		if (ma.getId() == 0) {
			return (Materia) creacion(ma);
		}
		else {
			return (Materia) modificacionEntidad(ma);
		}
	}
	
	/**
	 * 
	 */
	private static Materia obtencionUnaSolaEntidad (String sql) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPACentroEducativo");

		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery(sql, Materia.class);
		
		Materia m = null;
		
		try {
			m = (Materia) q.getSingleResult();
		}
		catch (Exception e) {
			
		}
		
		em.close();
		return m;
	}

}
