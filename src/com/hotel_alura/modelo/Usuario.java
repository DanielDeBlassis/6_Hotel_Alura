package com.hotel_alura.modelo;

public class Usuario {

/////////// ATRIBUTOS ///////////
	
	private int id;
	private String nombre;
	private String password;
	
/////////// CONSTRUCTOR ///////////
	
	public Usuario(String nombre, String password) {
		this.nombre = nombre;
		this.password = password;
	}
/////////// GETTERS Y SETTERS ///////////

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
/////////// MÉTODOS ///////////
	
	
}
