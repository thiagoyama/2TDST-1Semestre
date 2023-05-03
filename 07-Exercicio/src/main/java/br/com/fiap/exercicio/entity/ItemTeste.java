package br.com.fiap.exercicio.entity;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_ITEM_TESTE")
@SequenceGenerator(name="item", sequenceName = "SQ_TAB_ITEM_TESTE", allocationSize = 1)
public class ItemTeste {

	@Id
	@Column(name="cod_item_teste")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item")
	private Integer codigo;
	
	@Column(name="des_item_teste")
	private String descricao;
	
	//Rela��o N:1
	@ManyToOne
	@JoinColumn(name="cod_caso_teste")
	private CasoTeste caso;
	
	//Rela��o N:M
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name="TAB_ITEM_TESTE_USUARIO",
			joinColumns = @JoinColumn(name="cod_item_teste"),
			inverseJoinColumns = @JoinColumn(name="cod_usuario"))
	private List<Usuario> usuarios;

	public ItemTeste() {
	}
	
	public ItemTeste(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CasoTeste getCaso() {
		return caso;
	}

	public void setCaso(CasoTeste caso) {
		this.caso = caso;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}
