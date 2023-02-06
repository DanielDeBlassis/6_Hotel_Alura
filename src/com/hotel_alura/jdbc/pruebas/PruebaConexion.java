package com.hotel_alura.jdbc.pruebas;

import java.sql.Connection;
import java.sql.SQLException;

import com.hotel_alura.jdbc.factory.ConnectionFactory;

public class PruebaConexion {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection con = factory.recuperaConexion();

        System.out.println("Cerrando la conexión");

        con.close();
    }
	
}
