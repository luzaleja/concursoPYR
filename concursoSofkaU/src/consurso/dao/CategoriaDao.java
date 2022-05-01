package consurso.dao;

import concurso.entity.Categoria;
import concurso.exceptions.GenericException;

public interface CategoriaDao {

	public Categoria findById(Long id) throws GenericException;
}
