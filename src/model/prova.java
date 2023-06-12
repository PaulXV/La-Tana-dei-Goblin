package model;

public class prova {

	public static void main(String[] args) {
		
		Giocatore marco = new Giocatore("Marco", "9llo");
		Autore paolo = new Autore("Paolo", "05-01-2005", "ciao");
		
		Gioco a = new Gioco("a", "2023", Iterazione.COOPERATIVO, paolo, false);
		Premio premio = new Premio("premio", "2023", "premio");
		
		Gioco b = new Gioco("b", "2022", Iterazione.COMPETITIVO, new Autore("ciccio", "01348", "ascd"), true);
		b.addAuthor(paolo);
		b.setNumeroMaxPly(4);
		b.setNumeroMinimoPly(2);
		
		paolo.insertPremio(premio, a);
		paolo.insertPremio(premio, b);
		
		System.out.println(paolo.showGiochiConPremio());
	}

}