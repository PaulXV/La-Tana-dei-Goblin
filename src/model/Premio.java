package model;

public class Premio{
	
	private String nome;
	private String anno;
	private String descrizione;
	
	public Premio(String nome, String anno, String descrizione) {
		super();
		this.nome = nome;
		this.anno = anno;
		this.descrizione = descrizione;
	}

	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	public String getAnno() {return anno;}
	public void setAnno(String anno) {this.anno = anno;}
	public String getDescrizione() {return descrizione;}
	public void setDescrizione(String descrizione) {this.descrizione = descrizione;}

}