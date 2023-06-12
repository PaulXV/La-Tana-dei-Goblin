package model;
import java.util.*;

public class Gioco
{
	private String nome;
	private String annoEdizione;
	private ArrayList<Autore> autori = new ArrayList<Autore>();
	private Iterazione i;
	private int numeroMinimoPly;
	private int numeroMaxPly;
	private boolean solitario;
	
	Gioco(String nome, String annoEdizione, Iterazione i, Autore author, boolean solitario){
		this.nome = nome;
		this.annoEdizione = annoEdizione;
		this.i = i;
		this.solitario = solitario;
		if(author instanceof Autore && author!=null)
			autori.add(author);
		
		//if !solitario ask for num plys
	}
	
	public boolean getSolitario() {return solitario;}
	public void setSolitario(boolean solitario) {this.solitario = solitario;}
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	public String getAnnoEdizione() {return annoEdizione;}
	public void setAnnoEdizione(String annoEdizione) {this.annoEdizione = annoEdizione;}
	public ArrayList<Autore> getAutori() {return autori;}
	public void setAutori(ArrayList<Autore> autori) {this.autori = autori;}
	public Iterazione getI() {return i;}
	public void setI(Iterazione i) {this.i = i;}
	public int getNumeroMinimoPly() {return numeroMinimoPly;}
	public void setNumeroMinimoPly(int numeroMinimoPly) {this.numeroMinimoPly = numeroMinimoPly;}
	public int getNumeroMaxPly() {return numeroMaxPly;}
	public void setNumeroMaxPly(int numeroMaxPly) {this.numeroMaxPly = numeroMaxPly;}
	public boolean removeAuthor(Autore a) {return autori.remove(a);}
	
	public boolean addAuthor(Autore a){
		if(!autori.contains(a)) {
			autori.add(a);
			return true;
		}else
			return false;
	}
	
	public String toString()
	{
		return "Nome: "+nome
				+"\nAnno Edizione: "+annoEdizione
				+"\nAutori: " + stampaAutori()
				+"\nIterazione : "+ i
				+"\nSingle Player: "+ (solitario? ("YES - " + numeroMinimoPly + "/"+numeroMaxPly) :"NO");
	}
	
	public String stampaAutori() {
		String s = "";
		Autore aut = autori.get(autori.size()-1);
		for(Autore a : autori)
			if(a.getNome().equals(aut.getNome()))
				s += a.getNome();
			else
				s += a.getNome() + ", ";
		
		return s;
	}
	
}