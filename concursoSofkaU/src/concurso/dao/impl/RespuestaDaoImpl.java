package concurso.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import concurso.conexion.AdministradorDeConexiones;
import concurso.entity.Respuesta;
import concurso.exceptions.GenericException;
import consurso.dao.RespuestaDao;

public class RespuestaDaoImpl implements RespuestaDao {

	@Override
	public List<Respuesta> findAllByPreguntaId(Long preguntaId) throws GenericException {

		List<Respuesta> listRespuestas = new ArrayList<>();
		
		String sql = "SELECT * FROM respuesta WHERE pregunta_id = " + preguntaId;
		
		try (Connection con = AdministradorDeConexiones.obtenerConexion()) {
			
			try (Statement st = con.createStatement()) {
				
				try (ResultSet res = st.executeQuery(sql)) {
					
					while(res.next()) {
						Long id = res.getLong(1);
						String respuestaStr = res.getString(2);
						Integer correcto = res.getInt(3);
						Respuesta respuesta = new Respuesta(id,respuestaStr,correcto,preguntaId);
						listRespuestas.add(respuesta);
					}
				}
			}
		} catch (Exception e) {
			throw new GenericException("No se pudo consultar: " +sql,e);
		}
		return listRespuestas;
	}

}
