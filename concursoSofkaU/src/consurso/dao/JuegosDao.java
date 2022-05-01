package consurso.dao;

import concurso.entity.Juegos;
import concurso.exceptions.GenericException;

public interface JuegosDao {
	
	public Juegos create(Juegos juego) throws GenericException;

}
