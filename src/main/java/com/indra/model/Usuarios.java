package com.indra.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USUARIOS")
public class Usuarios {
	
	@Id
	private String NOMBREUSUARIO;
	
	@ManyToOne
	@JoinColumn( name = "NOMBREUSUARIO", nullable = true, updatable = false, insertable = false)
	private Roles rol;
	
	private String CLAVE;
	private String EMAIL;
	private String TELEFONO;
	private Integer ACTIVO;
	
	public Roles getRol() {
		return rol;
	}
	public void setRol(Roles rol) {
		this.rol = rol;
	}
	
	public String getNOMBREUSUARIO() {
		return NOMBREUSUARIO;
	}
	public void setNOMBREUSUARIO(String nOMBREUSUARIO) {
		NOMBREUSUARIO = nOMBREUSUARIO;
	}
	public String getCLAVE() {
		return CLAVE;
	}
	public void setCLAVE(String cLAVE) {
		CLAVE = cLAVE;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getTELEFONO() {
		return TELEFONO;
	}
	public void setTELEFONO(String tELEFONO) {
		TELEFONO = tELEFONO;
	}
	public Integer getACTIVO() {
		return ACTIVO;
	}
	public void setACTIVO(Integer aCTIVO) {
		ACTIVO = aCTIVO;
	}
	@Override
	public String toString() {
		return "Usuarios [NOMBREUSUARIO=" + NOMBREUSUARIO + ", CLAVE=" + CLAVE + ", EMAIL=" + EMAIL + ", TELEFONO="
				+ TELEFONO + ", ACTIVO=" + ACTIVO + "]";
	}
	
	
}
