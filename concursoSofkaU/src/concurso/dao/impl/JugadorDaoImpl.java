package concurso.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import concurso.conexion.AdministradorDeConexiones;
import concurso.entity.Jugador;
import concurso.exceptions.GenericException;
import consurso.dao.JugadorDao;

public class JugadorDaoImpl implements JugadorDao {

	@Override
	public Jugador create(Jugador jugador) throws GenericException {
		
		String sql = "INSERT INTO jugador (username,nombre,apellido) values(?,?,?)";
		
		try(Connection con = AdministradorDeConexiones.obtenerConexion()) {
			
			try(PreparedStatement st = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
				
				st.setString(1, jugador.getUsername());
				st.setString(2, jugador.getNombre());
				st.setString(3, jugador.getApellido());
				
				st.execute();
				
				try(ResultSet res = st.getGeneratedKeys()) {
					
					if(res.next()) {
						Long lastGeneratedId = res.getLong(1);
						jugador.setId(lastGeneratedId);
					}
				}
			}
		} catch (Exception se) {
			throw new GenericException("No se pudo consultar: " + sql,se);
		}
		return jugador;
	}

	@Override
	public Jugador findByUsername(String username) throws GenericException {
		
		Jugador jugador = null;
		
		String sql = "SELECT * FROM jugador WHERE LOWER(username) = '" + username.toLowerCase() + "'";
		
		try (Connection con = AdministradorDeConexiones.obtenerConexion()) {
			
			try (Statement st = con.createStatement()) {
				
				try (ResultSet res = st.executeQuery(sql)) {
					
					while(res.next()) {
						Long id = res.getLong(1);
						String nombre = res.getString(3);
						String apellido = res.getString(4);

						jugador = new Jugador(id,username,nombre,apellido);
					}
				}
			}
		} catch (Exception e) {
			throw new GenericException("No se pudo consultar: " + sql,e);
		}
		
		return jugador;
	}
	
}
