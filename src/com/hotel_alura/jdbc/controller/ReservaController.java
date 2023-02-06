package com.hotel_alura.jdbc.controller;

import com.hotel_alura.jdbc.factory.ConnectionFactory;
import com.hotel_alura.modelo.Reserva;

import java.sql.Date;
import java.util.List;

import com.hotel_alura.jdbc.dao.ReservaDAO;

public class ReservaController {
	
/////////// ATRIBUTOS ///////////
	
	private ReservaDAO reservaDao;
	
/////////// CONSTRUCTOR ///////////
	
	public ReservaController() {
        var factory = new ConnectionFactory();
        this.reservaDao = new ReservaDAO(factory.recuperaConexion());
	}
	
/////////// MÉTODOS ///////////
	

	/***
	 * Modifica una reserva
	 * @param id clave primaria del registro
	 * @param fecha_ingreso correspondiente a la fecha de emisión de la reserva
	 * @param fecha_salida fecha de vencimiento de la reserva
	 * @param valor precio de la reserva
	 * @param forma_pago forma en la que se pagó la reserva
	 * @return devuelve número entero con el resultado de la operación
	 */
    public int modificar(Integer id, Date fecha_ingreso, Date fecha_salida, Integer valor, String forma_pago) {
        return reservaDao.modificar(id, fecha_ingreso, fecha_salida, valor, forma_pago);
    }
    
    
    /**
     * Elimina un registro de la base de datos según su ID
     * 
     * @param id n�mero de identificación del registro a borrar
     * 
     * */
    public int eliminar(Integer id) {
        return reservaDao.eliminar(id);
    }
    
    
    /***
     * Devuelve una lista con todas las reservas
     * @return lista de reservas
     */
    public List<Reserva> listar() {
        return reservaDao.listar();
    }

    /***
     * Guarda una nueva reserva en la base de datos
     * @param reserva reserva a almacenar
     */
    public void guardar(Reserva reserva) {
        reservaDao.guardar(reserva);
    }

    
    
    
}





