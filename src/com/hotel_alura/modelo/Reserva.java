package com.hotel_alura.modelo;

import java.util.Date;

public class Reserva {
	
	
/////////// ATRIBUTOS ///////////
	
	private int id;
	private Date fecha_ingreso;
	private Date fecha_salida;
	private int valor;
	private String forma_pago;
	
/////////// CONSTRUCTOR ///////////
	public Reserva(int id, Date fecha_ingreso, Date fecha_salida, int valor, String forma_pago) {
		this.fecha_ingreso = fecha_ingreso;
		this.fecha_salida = fecha_salida;
		this.valor = valor;
		this.forma_pago = forma_pago;
	}
	
/////////// GETTERS Y SETTERS ///////////

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Date getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getForma_pago() {
		return forma_pago;
	}

	public void setForma_pago(String forma_pago) {
		this.forma_pago = forma_pago;
	}
	
	
/////////// MÉTODOS ///////////
	
    @Override
    public String toString() {
        return String.format(
                "{ id: %d, ingreso: %s, salida: %s, valor: %d, forma_pago: %s }",
                this.id, this.fecha_ingreso, this.fecha_salida, this.valor, this.forma_pago);
    }
	
	
}
