package consurso.dao;

import java.util.List;

import concurso.entity.Pregunta;
import concurso.exceptions.GenericException;

public interface PreguntaDao {

	public List<Pregunta> findAllByCategoriaId(Long categoriaId) throws GenericException;
}
