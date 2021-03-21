package com.indra.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROLES")
public class Roles {
	@Id
	private String NOMBREUSUARIO;
	private String ROL;
	
	public String getNOMBREUSUARIO() {
		return NOMBREUSUARIO;
	}
	public void setNOMBREUSUARIO(String nOMBREUSUARIO) {
		NOMBREUSUARIO = nOMBREUSUARIO;
	}
	public String getROL() {
		return ROL;
	}
	public void setROL(String rOL) {
		ROL = rOL;
	}
	@Override
	public String toString() {
		return "Roles [NOMBREUSUARIO=" + NOMBREUSUARIO + ", ROL=" + ROL + "]";
	}
	
}
