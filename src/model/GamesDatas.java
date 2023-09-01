package model;
import java.io.*;
import gui.*;

public class GamesDatas
{
	private String path = "src/games.txt";
	private FileReader fr;
	private BufferedReader bufferRead;

	public void appendGame(String giocoDaAppendere, boolean check) throws IOException {
		BufferedWriter out;
		
		if(check)	out = new BufferedWriter(new FileWriter(path, false));
		else	out = new BufferedWriter(new FileWriter(path, true));
		
		out.write(giocoDaAppendere);
		out.close();
	}
	
	public void appendGame(MyLabel giocoDaAppendere) throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(path, true));
		out.write("\n"+giocoDaAppendere.toString());
		out.close();
	}
	
	public String getAllGames() throws IOException {
		
		String s = "";
		
		fr = new FileReader(path);
		bufferRead  = new BufferedReader(fr);;
		String riga;
		riga = bufferRead.readLine();
		if(riga == null)
			return s;
		else{
			while(!riga.isEmpty())
			{
				s += riga;
				riga = bufferRead.readLine();
				
				if(riga==null)
					break;
			}
		}
		return s;
	}

	public int getNumPremiVinti(String nome) throws IOException {
		int premiVinti = 0;
		
		String[] games = getAllGames().split(" div");
		
		for(String s : games) {
			String[] info = s.split("/");
			if(info[0].equals(nome)) {
				if(!info[7].equals("NESSUNO")) {
					premiVinti ++;
				}
			}
		}
		
		return premiVinti;
	}
	
}