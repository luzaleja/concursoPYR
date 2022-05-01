package concurso.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import concurso.conexion.AdministradorDeConexiones;
import concurso.entity.Juegos;
import concurso.exceptions.GenericException;
import consurso.dao.JuegosDao;

public class JuegosDaoImpl implements JuegosDao {

	@Override
	public Juegos create(Juegos juego) throws GenericException {

		String sql = "INSERT INTO juegos (jugador_id,puntos_acumulados) values(?,?)";
		
		try(Connection con = AdministradorDeConexiones.obtenerConexion()) {
			
			try(PreparedStatement st = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
				
				st.setLong(1, juego.getJugadorId());
				st.setInt(2, juego.getPuntosAcumulados());
				
				st.execute();
				
				try(ResultSet res = st.getGeneratedKeys()) {
					
					if(res.next()) {
						Long lastGeneratedId = res.getLong(1);
						juego.setId(lastGeneratedId);
					}
				}
			}
		} catch (SQLException e) {
			throw new GenericException("No se pudo consultar: " + sql,e);
		}
		return juego;
	}

}
