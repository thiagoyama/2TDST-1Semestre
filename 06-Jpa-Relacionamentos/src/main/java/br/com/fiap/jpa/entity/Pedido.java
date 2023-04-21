package br.com.fiap.jpa.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_PEDIDO")
@SequenceGenerator(name="pedido", sequenceName = "SQ_TB_PEDIDO", allocationSize = 1)
public class Pedido {

	@Id
	@Column(name="cd_pedido")
	@GeneratedValue(generator = "pedido", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_pedido", nullable = false)
	private Calendar data;
	
	@Column(name="vl_pedido", nullable = false)
	private Double valor;
	
	//mappedBy -> nome do atributo que mapeia a FK
	@OneToOne(mappedBy = "pedido") 
	private NotaFiscal nota;
	
	//Relacionamento N:M
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name="TB_ITEM_PEDIDO", 
			joinColumns = @JoinColumn(name="cd_pedido"),
			inverseJoinColumns = @JoinColumn(name="cd_produto"))
	private List<Produto> produtos;
	
	@ManyToOne
	@JoinColumn(name="cd_cliente", nullable = false)
	private Cliente cliente;
	
	public Pedido() {}

	public Pedido(Calendar data, Double valor) {
		this.data = data;
		this.valor = valor;
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

	public NotaFiscal getNota() {
		return nota;
	}

	public void setNota(NotaFiscal nota) {
		this.nota = nota;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
}
