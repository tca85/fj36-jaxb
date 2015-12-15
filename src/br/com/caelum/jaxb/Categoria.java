package br.com.caelum.jaxb;

import javax.xml.bind.annotation.XmlType;

/**
 * A anotation @XmlType serve para mudar o nome do tipo complexo
 * que representa a categoria
 * 
 * @author tca85
 *
 */
@XmlType(name="CAT")
public class Categoria {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
