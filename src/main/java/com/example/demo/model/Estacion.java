package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="estaciones")
@JsonIgnoreProperties(ignoreUnknown = true) //ignorar campos desconocidos en un json entrante 
											//posiblemente tambien ignora campos que estan en la bd y no en la entidad
public class Estacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@Column(nullable = false)
	@Size(min = ConstantesModel.MIN_LENGTH_STRING_FIELD, max = ConstantesModel.MAX_LENGTH_STRING_FIELD )
	private String nombre;
	
	@Column
	private String descripcion; 
	
	@Column
	private String region;
	
	@Column
	private String unidad;
	
	@Column(nullable = false)
	private float latitud;
	
	@Column(nullable = false)
	private float longitud;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idusuario")
	@JsonIgnoreProperties("estaciones")
	private Usuario usuario;
	
	@OneToOne(mappedBy="estacion", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("estacion")
	private Muestreo muestreo; 


	public Estacion() {
		super();
	}

	public Estacion(long id, String nombre, String descripcion, String region, float latitud, float longitud,
			Usuario usuario, Muestreo muestreo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.region = region;
		this.latitud = latitud;
		this.longitud = longitud;
		this.usuario = usuario;
		this.muestreo = muestreo;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public Muestreo getMuestreo() {
		return muestreo;
	}



	public void setMuestreo(Muestreo muestreo) {
		this.muestreo = muestreo;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	
}
