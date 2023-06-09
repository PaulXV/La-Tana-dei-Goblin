package model;
import java.util.*;

public class Autore {
	
	private String nome;
	private String dataNascita;
	private String biografia;
	private ArrayList<Premio> premiVinti = new ArrayList<Premio>();
	private ArrayList<Gioco> giochiPremiati = new ArrayList<Gioco>();
	
	Autore(String nome, String dataNascita, String biografia)
	{
		this.nome = nome;
		this.dataNascita = dataNascita;
		this.biografia = biografia;
	}

	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	public String getDataNascita() {return dataNascita;}
	public void setDataNascita(String dataNascita) {this.dataNascita = dataNascita;}
	public String getBiografia() {return biografia;}
	public void setBiografia(String biografia) {this.biografia = biografia;}
	
	public boolean insertPremio(Premio p, Gioco g)
	{
		giochiPremiati.add(g);
		return premiVinti.add(p);
	}
	public boolean removePremio(Premio p, Gioco g)
	{
		giochiPremiati.remove(g);
		return premiVinti.remove(p);
	}
	
	public String showGiochiConPremio()
	{
		String s = "";
		for(Gioco g : giochiPremiati)
			s += g.toString() + ", ";
		
		return s;
	}
}