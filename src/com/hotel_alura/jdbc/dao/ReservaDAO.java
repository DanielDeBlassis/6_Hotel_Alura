package com.hotel_alura.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hotel_alura.modelo.Reserva;

public class ReservaDAO {
	
/////////// ATRIBUTOS ///////////
	private Connection con;
	
	
/////////// CONSTRUCTOR ///////////
	public ReservaDAO(Connection con) {
		
	}

	
/////////// GETTERS Y SETTERS ///////////
	
	
/////////// MÉTODOS ///////////
	
	/***
	 * Guarda una reserva en la base de datos
	 * @param reserva objeto de tipo Reserva a guardar
	 */
	public void guardar(Reserva reserva) {

	       try {
	            PreparedStatement statement;
	                statement = con.prepareStatement(
	                        "INSERT INTO reserva "
	                        + "(id, fecha_ingreso, fecha_salida, valor, forma_pago)"
	                        + " VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
	    
	            try (statement) {
	                statement.setInt(1, reserva.getId());
	                statement.setDate(2, (Date) reserva.getFecha_ingreso());
	                statement.setDate(3, (Date) reserva.getFecha_salida());
	                statement.setInt(4, reserva.getValor());
	                statement.setString(5, reserva.getForma_pago());
	    
	                statement.execute();
	    
	                final ResultSet resultSet = statement.getGeneratedKeys();
	    
	                try (resultSet) {
	                    while (resultSet.next()) {
	                        reserva.setId(resultSet.getInt(1));
	                        
	                        System.out.println(String.format("Fue insertada la reserva: %s", reserva));
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
		
	}
	
	/***
	 * Lista todas las reservas almacenadas en al base de datos
	 * @return objeto de tipo lista con todas las reservas en la base de datos
	 */
	public List<Reserva> listar() {
        List<Reserva> resultado = new ArrayList<>();

        try {
            final PreparedStatement statement = con
                    .prepareStatement("SELECT id, fecha_ingreso, fecha_salida, valor, forma_pago FROM reserva");
    
            try (statement) {
                statement.execute();
    
                final ResultSet resultSet = statement.getResultSet();
    
                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Reserva(
                                resultSet.getInt("id"),
                                resultSet.getDate("fecha_ingreso"),
                                resultSet.getDate("fecha_salida"),
                                resultSet.getInt("valor"),
                                resultSet.getString("forma_pago")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }
	

	/***
	 * Elimina una reserva de la base de datos según su ID
	 * @param id número entero que identifica a la reserva
	 * @return número entero que indica el resultado de la operación
	 */
    public int eliminar(Integer id) {
        try {
            final PreparedStatement statement = con.prepareStatement("DELETE FROM reserva WHERE id = ?");

            try (statement) {
                statement.setInt(1, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    /***
     * Modifica una reserva en la base de datos
     * @param id número entero que identifica la reserva
     * @param fecha_ingreso objeto de tipo date correspondiente a la fecha de ingreso
     * @param fecha_salida objeto de tipo date correspondiente a la fecha de salida
     * @param valor número entero que corresponde al valor de la reserva
     * @param forma_pago cadena de texto que especifica la forma de pago
     * @return número entero con el estado de la modificación
     */
    public int modificar(int id, Date fecha_ingreso, Date fecha_salida, int valor, String forma_pago) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "UPDATE reserva SET "
                    + " fecha_ingreso = ?, "
                    + " fecha_salida = ?,"
                    + " valor = ?,"
                    + " forma_pago = ? "
                    + " WHERE id = ?");

            try (statement) {
                statement.setDate(1, fecha_ingreso);
                statement.setDate(2, fecha_salida);
                statement.setInt(3, valor);
                statement.setString(4, forma_pago);
                statement.setInt(5, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
