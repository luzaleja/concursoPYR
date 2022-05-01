package consurso.dao;

import concurso.entity.Jugador;
import concurso.exceptions.GenericException;

public interface JugadorDao {

	public Jugador create(Jugador jugador) throws GenericException;
	
	public Jugador findByUsername(String username) throws GenericException;
	
}
