package com.commons.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;


@Entity
@Table (name = "PEDIDO")
public class Pedido {
	
	@Id
	@GeneratedValue ( strategy = GenerationType.SEQUENCE, generator = "SEQ_PEDIDO" )
	@SequenceGenerator (name = "SEQ_PEDIDO", sequenceName = "SEQ_PEDIDO", allocationSize = 1)
	@Column(name = "ID_PEDIDO")
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
	@JsonBackReference// Esta columna está en la tabla Pedido
    private Cliente cliente;
	
	@Column(name = "TOTAL")
	private Double total;
	
	@Column(name = "ID_ESTATUS")
	private Long idEstatus;
	
	@ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.MERGE  )
	@JoinTable(name = "PEDIDO_PRODUCTO",
	    joinColumns = @JoinColumn(name = "ID_PEDIDO"),
	    inverseJoinColumns = @JoinColumn(name = "ID_PRODUCTO"))
	private List<Producto> productos;

	@Column(name = "FECHA_CREACION", nullable = true)
	private LocalDate fechaCreacion;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Long getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(Long idEstatus) {
		this.idEstatus = idEstatus;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + cliente + ", total=" + total + ", idEstatus=" + idEstatus
				+ ", productos=" + productos + "]";
	}



	
	

}
