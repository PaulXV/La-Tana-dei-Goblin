package model;
import java.io.*;
import gui.*;

public class GamesDatas
{
	private String path = "src/games.txt";
	private FileWriter fw;
	private FileReader fr;
	private BufferedReader bufferRead;

	public void newGame(MyLabel giocoDaAggiungere) throws IOException {
		fw = new FileWriter(path);
		
		String scrivi = giocoDaAggiungere.toString();
		
		fw.write(scrivi);
			
		fw.close();
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
	
}