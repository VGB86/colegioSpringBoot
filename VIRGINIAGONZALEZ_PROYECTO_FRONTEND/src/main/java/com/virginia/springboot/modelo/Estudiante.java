package com.virginia.springboot.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estudiante")
public class Estudiante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "mail")
	private String mail;
	
	@Column(name = "numTelf")
	private long numTelf;
	
	
	public Estudiante() {
		super();
	}
	public Estudiante(String nombre, String mail) {
		super();
		this.nombre = nombre;
		this.mail = mail;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public long getNumTelf() {
		return numTelf;
	}
	public void setNumTelf(long numTelf) {
		this.numTelf = numTelf;
	}
}
