package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_NOTA_FISCAL")
@SequenceGenerator(name="nota", sequenceName = "SQ_TB_NOTA_FISCAL", allocationSize = 1)
public class NotaFiscal {

	@Id
	@Column(name="cd_nota")
	@GeneratedValue(generator = "nota", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_nota", nullable = false)
	private Calendar data;
	
	@Column(name="vl_nota", nullable = false)
	private Double valor;
	
	//1:1 (FK)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="cd_pedido", nullable = false)
	private Pedido pedido;
	
	public NotaFiscal() {
	}

	public NotaFiscal(Calendar data, Double valor, Pedido pedido) {
		this.data = data;
		this.valor = valor;
		this.pedido = pedido;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	} 
	
}