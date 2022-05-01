package consurso.dao;

import java.util.List;

import concurso.entity.Respuesta;
import concurso.exceptions.GenericException;

public interface RespuestaDao {
	
	public List<Respuesta> findAllByPreguntaId(Long preguntaId) throws GenericException;

}
