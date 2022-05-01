package consurso.dao;

import concurso.entity.Puntos;
import concurso.exceptions.GenericException;

public interface PuntosDao {
	
	public Puntos findById(Long id) throws GenericException;

}
