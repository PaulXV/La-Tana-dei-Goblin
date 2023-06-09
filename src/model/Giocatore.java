package model;
import java.util.*;

public class Giocatore
{
	private String nome;
	private String nickname;
	private HashMap<String, Gioco> g = new HashMap<String, Gioco>();
	private ArrayList<Gioco> prossimiAcquisti = new ArrayList<Gioco>();
	
	Giocatore(String nome, String nickname)
	{
		this.nome = nome;
		this.nickname = nickname;
	}

	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	public String getNickname() {return nickname;}
	public void setNickname(String nickname) {this.nickname = nickname;}
	
	public boolean insertGame(String data, Gioco gioco){
		return g.putIfAbsent(data, gioco) != null ? true : false ;
	}
	
	public boolean removeGame(String data, Gioco gioco) {
		return g.remove(data, gioco) ? true : false;
	}
	
	public boolean modifyDate(String oldDate, String newDate, Gioco gioco) {
		if(g.containsKey(oldDate)) {
			g.remove(oldDate, gioco);
			g.put(newDate, gioco);
			return true;
		}else
			return false;
	}
	
	public boolean modifyGame(String date, Gioco oldGame, Gioco newGame) {
		return g.replace(date, oldGame, newGame) ? true : false;
	}
	
	public boolean insertWantedGame(Gioco gioco) {
		if(!prossimiAcquisti.contains(gioco)) {
			prossimiAcquisti.add(gioco);
			return true;
		}else
			return false;
	}
}