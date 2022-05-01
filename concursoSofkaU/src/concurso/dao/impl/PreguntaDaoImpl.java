package concurso.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import concurso.conexion.AdministradorDeConexiones;
import concurso.entity.Pregunta;
import concurso.exceptions.GenericException;
import consurso.dao.PreguntaDao;

public class PreguntaDaoImpl implements PreguntaDao {

	@Override
	public List<Pregunta> findAllByCategoriaId(Long categoriaId) throws GenericException {
		
		List<Pregunta> listPreguntas = new ArrayList<>();
		
		String sql = "SELECT * FROM pregunta WHERE categoria_id = " + categoriaId;
		
		try (Connection con = AdministradorDeConexiones.obtenerConexion()) {
			
			try (Statement st = con.createStatement()) {
				
				try (ResultSet res = st.executeQuery(sql)) {
					
					while(res.next()) {
						Long id = res.getLong(1);
						String preguntaStr = res.getString(2);
						Pregunta pregunta = new Pregunta(id,preguntaStr,categoriaId);
						listPreguntas.add(pregunta);
					}
				}
			}
		} catch (Exception e) {
			throw new GenericException("No se pudo consultar: " + sql,e);
		}
		
		return listPreguntas;
	}

}
