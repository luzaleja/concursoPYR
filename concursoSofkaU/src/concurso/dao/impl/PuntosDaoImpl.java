package concurso.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import concurso.conexion.AdministradorDeConexiones;
import concurso.entity.Puntos;
import concurso.exceptions.GenericException;
import consurso.dao.PuntosDao;

public class PuntosDaoImpl implements PuntosDao {

	@Override
	public Puntos findById(Long id) throws GenericException {

		Puntos puntos = null;
		
		String sql = "SELECT * FROM puntos WHERE id = " + id;
		
		try (Connection con = AdministradorDeConexiones.obtenerConexion()) {
			
			try (Statement st = con.createStatement()) {
				
				try (ResultSet res = st.executeQuery(sql)) {
					
					while(res.next()) {
						Integer puntosOtorgar = res.getInt(2);
						puntos = new Puntos(id,puntosOtorgar);
					}
				}
			}
		} catch (Exception e) {
			throw new GenericException("No se pudo consultar: " + sql,e);
		}
		
		return puntos;
	}

}
