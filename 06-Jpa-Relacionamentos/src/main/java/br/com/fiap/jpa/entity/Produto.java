package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_PRODUTO")
@SequenceGenerator(name="prod", sequenceName = "SQ_TB_PRODUTO", allocationSize = 1)
public class Produto {

	@Id
	@Column(name="cd_produto")
	@GeneratedValue(generator = "prod", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	@Column(name="nm_produto", nullable = false, length = 80)
	private String nome;
	
	@Column(name="vl_produto", nullable = false, precision = 10, scale = 2)
	private Double valor;
	
	@Column(name="qt_estoque", precision = 5)
	private Integer quantidade;
	
}
